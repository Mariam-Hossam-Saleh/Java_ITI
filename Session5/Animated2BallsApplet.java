import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;

public class Animated2BallsApplet extends Applet implements Runnable{
	Thread th;
	int x;
	int y;
	boolean dir;
	boolean dir1;

	int x2;
        int y2;
        boolean dir_;
        boolean dir_1;

	Font f = new Font("Arial",Font.BOLD,20);
	public void init()
	{
		x = 0;
        	y = 0;
        	dir = true;
        	dir1 = true;

        	x2 = getWidth();
        	y2 = getHeight();
        	dir_ = false;
                dir_1 = false;
		th = new Thread(this);
		th.start();
	}
	public void paint(Graphics g)
	{
		g.setFont(f);
		g.setColor(Color.RED);
		if(Math.sqrt((Math.pow((x - x2),(x - x2))+Math.pow((y - y2),(y - y2)))) <= 50)
		{
			dir = !dir;
			dir_ = !dir_;
		}
		else{
		if(dir == true)
		{
			if(x >= getWidth()-50)
			{
				dir = false;
			}
			else
			{
				x+=10;
			}
		}
		else
		{
			if( x <= 0)
			{
				dir = true;
			}
			else
			{
				x-=10;
			}
		}
		if(dir1 == true)
                {
                        if(y >= getHeight()-50)
                        {
                                dir1 = false;
                        }
                        else
                        {
                                y+=10;
                        }
                }
                else
                {
                        if( y <= 0)
                        {
                                dir1 = true;
                        }
                        else
                        {
                                y-=10;
                        }
                }
		}
		g.fillOval(x,y,50,50);
		g.setColor(Color.BLUE);
                if(dir_ == true)
                {
                        if(x2 == getWidth()-50)
                        {
                                dir_ = false;
                        }
                        else
                        {
                                x2+=10;
                        }
                }
                else
                {
                        if( x2 == 0)
                        {
                                dir_ = true;
                        }
                        else
                        {
                                x2-=10;
                        }
                }
                if(dir_1 == true)
                {
                        if(y2 == getHeight()-50)
                        {
                                dir_1 = false;
                        }
                        else
                        {
                                y2+=10;
                        }
                }
                else
                {
                        if( y2 == 0)
                        {
                                dir_1 = true;
                        }
                        else
                        {
                                y2-=10;
                        }
                }
		g.fillOval(x2,y2,50,50);
	}
	public void run()
	{
	        while(true)
                {
			try
			{
				repaint();
                        	Thread.sleep(50);
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}

                }
	}
}
