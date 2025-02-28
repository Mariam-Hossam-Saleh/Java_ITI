import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;

public class BannerApplet extends Applet implements Runnable{
	Thread th;
	int x = 0;
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
		if(x < getWidth())
		{
			x+=5;
		}
		else
		{
			x = -200;
		}
		g.drawString("Java World",x,getHeight()/2);
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
