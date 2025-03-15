import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.*;
import java.awt.Color;

public class Task3 extends Applet implements Runnable{
	Thread th;
	int x,y;
	boolean dir,dir1;
	Button b1,b2; 
	boolean startState = true;
	public void init(){
		x = getWidth()/2;
		y = getHeight()/2;
		dir = true;
		dir1 = true;
		th = new Thread(this);
		b1 = new Button("Start");
		b2 = new Button("Pause");
		b1.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                                if(startState)
				{
					th.start();
					startState = false;
				}
				else
				{
					th.resume();
				}
                        }
                });
		b2.addActionListener(new ActionListener(){
                	public void actionPerformed(ActionEvent e){
                        	th.suspend();
                	}
        	});
		add(b1);
		add(b2);
	}
	 public void paint(Graphics g)
        {
		if(dir == true)
		{
			if(x >= getWidth()-100)
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
                        if(y >= getHeight()-100)
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
		g.setColor(Color.BLUE);
		g.fillOval(x,y,100,100);
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

