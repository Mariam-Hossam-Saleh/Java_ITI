import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;

class Line{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	Line(){
		x1 = x2 = y1 = y2 = 0;
	}
	Line(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
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

public class Task7 extends Applet{
	ArrayList<Line> lines;
	int x1,y1;
	boolean isLineCreated = false;
	public void init(){
		lines = new ArrayList<Line>();
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
			}
			public void mouseReleased(MouseEvent e){
				isLineCreated = false;
			}
		});
		this.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				if(isLineCreated == false)
				{
					isLineCreated = true;
					lines.add(new Line(x1,y1,e.getX(),e.getY()));
				}
				lines.get(lines.size()-1).setX2(e.getX());
				lines.get(lines.size()-1).setY2(e.getY());
				repaint();
			}
    	});
	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		for(int counter = 0; counter < lines.size(); counter++)
		{
			g.drawLine(lines.get(counter).getX1(),lines.get(counter).getY1(),lines.get(counter).getX2(),lines.get(counter).getY2());
		}
	}
}