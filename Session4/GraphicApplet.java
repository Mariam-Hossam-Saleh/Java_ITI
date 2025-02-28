import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
import java.awt.Color;

public class GraphicApplet extends Applet{
	public void paint(Graphics g){	
		g.setColor(Color.CYAN);
		g.fillOval(100,100,200,50);
		g.fillOval(175,175,50,100);
		g.fillOval(120,190,30,70);
                g.fillOval(250,190,30,70);
		g.setColor(Color.BLACK);
		g.drawOval(100,100,200,50);
                g.drawOval(175,175,50,100);
		g.drawOval(120,190,30,70);
                g.drawOval(250,190,30,70);
                g.drawLine(100,125,70,250);
		g.drawLine(300,125,330,250);
		g.drawArc(70,200,260,100,180,180);
		g.drawLine(180,300,150,380);
		g.drawLine(220,300,250,380);
		g.drawRect(100,380,200,25);
	}
}
