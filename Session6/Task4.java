import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;

public class Task4 extends Applet{
	int x,y,offsetX,offsetY;
	boolean isMousePressed;
	public void init(){
		x = getWidth()/2;
		y = getHeight()/2;
		offsetX = offsetY = 0;
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				offsetX = e.getX()-x;	
				offsetY = e.getY()-y;
				if((e.getX() >= x) && (e.getX() <= x+100) && (e.getY() >= y) && (e.getY() <= y+100))
				{
					isMousePressed = true;
				}
			}
			public void mouseReleased(MouseEvent e){
				isMousePressed = false;
			}
		});
		this.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				if(isMousePressed){
					x = e.getX()-offsetX;
                			y = e.getY()-offsetY;
				}
			    repaint();
			}
        	});
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillOval(x,y,100,100);
	}
}

