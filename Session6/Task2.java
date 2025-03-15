import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

public class Task2 extends Applet{
	int x,y; 
	public void init(){
		x = getWidth()/2;
		y = getHeight()/2;
		this.addKeyListener(new KeyAdapter(){
        		public void keyPressed(KeyEvent e){	
			if(x <= 0){
				x = getWidth();
			}
			else if(x >= getWidth()){
				x = 0;
			}
			if(y <= 0){
                                y = getWidth();
                        }
                        else if(y >= getWidth()){
                                y = 0;
                        }
			switch(e.getExtendedKeyCode())
			{
				case KeyEvent.VK_UP:
					y-=10;
				break;
				case KeyEvent.VK_DOWN:
					y+=10;
				break;
				case KeyEvent.VK_LEFT:
					x-=10;
				break;
				case KeyEvent.VK_RIGHT:
				       	x+=10;	
				break;
			}
       			repaint();
			}
        	});
	}
	public void paint(Graphics g){
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setColor(Color.MAGENTA);
		g.drawString("Java", x,y);

	}
}


