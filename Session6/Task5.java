import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
//import java.awt.geom.Line2D;

class Line{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	Line(){
		x1 = x2 = y1 = y2 = 0;
	}
	public void setX1(int x){
		x1 = x;
	}
	public void setY1(int y){
                y1 = y;
        }
	public void setX2(int x){
                x2 = x;
        }
        public void setY2(int y){
                y2 = y;
        }
	public int getX1(){
                return x1;
        }
	public int getY1(){
                return y1;
        }
	public int getX2(){
                return x2;
        }
	public int getY2(){
                return y2;
        }
}

public class Task5 extends Applet{
	Line line;
	public void init(){
		line = new Line();
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				line.setX1(e.getX());
				line.setY1(e.getY());
			}
		});
		this.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				line.setX2(e.getX());
                                line.setY2(e.getY());
                                repaint();
			}
        	});
	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.drawLine(line.getX1(),line.getY1(),line.getX2(),line.getY2());
	}
}


