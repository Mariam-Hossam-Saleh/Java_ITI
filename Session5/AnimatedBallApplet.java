import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;

public class AnimatedBallApplet extends Applet implements Runnable{
	Thread th;
	int x = getWidth()/2;
	int y = getHeight()/2;
	boolean dir = true;
	boolean dir1 = true;
	Font f = new Font("Arial",Font.BOLD,20);
	public void init()
	{
		th = new Thread(this);
		th.start();
	}
	public void paint(Graphics g)
	{
		g.setFont(f);
		g.setColor(Color.RED);
		if(dir == true)
		{
			if(x == getWidth()-50)
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
			if( x == 0)
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
                        if(y == getHeight()-50)
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
                        if( y == 0)
                        {
                                dir1 = true;
                        }
                        else
                        {
                                y-=10;
                        }
                }
		g.fillOval(x,y,50,50);
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
