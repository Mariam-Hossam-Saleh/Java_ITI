import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

class Ball {
    public int x;
    public int y;
    public boolean rightDir;
    public boolean upDir;
    public int ovalSize;
    private AnimatedBallsApplet applet;

    Ball(int xDim, int yDim, boolean rDir, boolean uDir, int size, AnimatedBallsApplet applet) {
        this.x = xDim;
        this.y = yDim;
        this.rightDir = rDir;
        this.upDir = uDir;
        this.ovalSize = size;
        this.applet = applet;
    }

    public void moveBall() {
        int appletWidth = applet.getWidth();
        int appletHeight = applet.getHeight();

        if (rightDir) {
            if (x >= appletWidth - ovalSize) {
                rightDir = false;
            } else {
                x += 10;
            }
        } else {
            if (x <= 0) {
                rightDir = true;
            } else {
                x -= 10;
            }
        }

        if (upDir) {
            if (y >= appletHeight - ovalSize) {
                upDir = false;
            } else {
                y += 10;
            }
        } else {
            if (y <= 0) {
                upDir = true;
            } else {
                y -= 10;
            }
        }
    }
}

public class AnimatedBallsApplet extends Applet implements Runnable {
    Thread th;
    Ball[] balls;
    Color[] ballsColors = {Color.RED, Color.BLUE, Color.MAGENTA, Color.GREEN, Color.CYAN, Color.PINK, Color.YELLOW, Color.GRAY, Color.ORANGE};
    int counter1;
    int counter2;
    private static final int MAX_BALL_NUM = 50;
    private static final int BALL_SIZE = 80;
    private long lastBallCreationTime; // Timestamp of the last ball creation
    private static final long COOLDOWN_PERIOD = 1000; // Cooldown period in milliseconds (1 second)

    public void init() {
        int appletWidth = getWidth();
        int appletHeight = getHeight();

        balls = new Ball[MAX_BALL_NUM];
        balls[0] = new Ball(appletWidth/2, appletHeight/2, true, true, BALL_SIZE, this);
        balls[1] = new Ball(appletWidth, 3*appletHeight/4, false, false, BALL_SIZE, this);
        counter1 = 2;
        counter2 = 2;
	
        th = new Thread(this);
        th.start();
    }

    public double getBallsDis(Ball ball1, Ball ball2) {
        return Math.sqrt(Math.pow(ball1.x - ball2.x, 2) + Math.pow(ball1.y - ball2.y, 2));
    }

    public void paint(Graphics g) {
        long currentTime = System.currentTimeMillis(); // Get the current time

        for (int i = 0; i < counter1; i++) {
            for (int j = 1; j < counter1; j++) {
                if (i != j) {
                    if (getBallsDis(balls[i], balls[j]) <= 100) {
                        balls[i].rightDir = !balls[i].rightDir;
                        balls[i].upDir = !balls[i].upDir;
                        balls[j].rightDir = !balls[j].rightDir;
                        balls[j].upDir = !balls[j].upDir;

                        // Check if the cooldown period has elapsed
                        if (counter2 < MAX_BALL_NUM && currentTime - lastBallCreationTime >= COOLDOWN_PERIOD) {
                            balls[counter2] = new Ball(balls[i].x, balls[i].y, balls[i].rightDir, !balls[j].upDir, BALL_SIZE, this);
                            counter2++;
                            lastBallCreationTime = currentTime; // Update the last creation time
                        } else if (counter2 >= MAX_BALL_NUM) {
                            counter2 = 2;
                        }
                    }
                }
            }
        }

        counter1 = counter2;
        for (int itr = 0; itr < counter2; itr++) {
            g.setColor(ballsColors[itr % 9]);
            balls[itr].moveBall();
            g.fillOval(balls[itr].x, balls[itr].y, balls[itr].ovalSize, balls[itr].ovalSize);
        }
    }

    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
