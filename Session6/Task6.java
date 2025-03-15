import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;

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

public class Task6 extends Applet{
	Line[] line;
	int itr;
	int x1,y1;
	boolean isMousePressed = false;
	public void init(){
		line = new Line[3];
		itr = 0;
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
			}
			public void mouseReleased(MouseEvent e){
				itr++;
				if(itr == 3){
					for(int i = 0 ;i < itr ; i++)
					{
						line[i] = null;
					}
					itr = 0;
				}
			}
		});
		this.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				if(line[itr] == null){
					line[itr] = new Line();
				}
				line[itr].setX1(x1);
                line[itr].setY1(y1);
				line[itr].setX2(e.getX());
                line[itr].setY2(e.getY());
                repaint();
			}
        });
	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		for(int counter = 0; counter <= itr; counter++)
		{
			if(line[itr] != null){
				g.drawLine(line[counter].getX1(),line[counter].getY1(),line[counter].getX2(),line[counter].getY2());
			}
		}
	}
}


