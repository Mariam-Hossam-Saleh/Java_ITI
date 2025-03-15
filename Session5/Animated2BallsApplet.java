import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

class Ball {
    public int x;
    public int y;
    public boolean rightDir;
    public boolean upDir;
    public int ovalSize;
    private Animated2BallsApplet applet;

    Ball(int xDim, int yDim, boolean rDir, boolean uDir, int size, Animated2BallsApplet applet) {
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

public class Animated2BallsApplet extends Applet implements Runnable {
    Thread th;
    Ball b1;
    Ball b2;
    Font f = new Font("Arial", Font.BOLD, 20);

    public void init() {
        int appletWidth = getWidth();
        int appletHeight = getHeight();

        b1 = new Ball(appletWidth/2, 0, true, true, 50, this);
        b2 = new Ball(appletWidth,appletHeight, false, false, 50, this);

        th = new Thread(this);
        th.start();
    }
    public double getBallsDis(Ball ball1,Ball ball2)
    {
	    return (Math.sqrt((Math.pow((ball1.x - ball2.x),2)+Math.pow((ball1.y - ball2.y),2))));
    }
    public void paint(Graphics g) {
        g.setFont(f);
	if(getBallsDis(b1,b2) <= 50)
	{
		b1.rightDir = !b1.rightDir;
		b1.upDir = !b1.upDir;
		b2.rightDir = !b2.rightDir;
                b2.upDir = !b2.upDir;
	}
        g.setColor(Color.RED);
        b1.moveBall();
        g.fillOval(b1.x, b1.y, b1.ovalSize, b1.ovalSize);

        g.setColor(Color.BLUE);
        b2.moveBall();
        g.fillOval(b2.x, b2.y, b2.ovalSize, b2.ovalSize);
    }

    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

