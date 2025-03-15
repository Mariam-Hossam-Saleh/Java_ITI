import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.*;

public class Task1 extends Applet{
	int x;
	Button b1,b2; 
	public void init(){
		x = 0;
		b1 = new Button("IncButton");
		b2 = new Button("DecButton");
		IncButtonListener incL = new IncButtonListener();
		b1.addActionListener(incL);
		b2.addActionListener(new ActionListener(){
                	public void actionPerformed(ActionEvent e){
                        	x--;
                        	repaint();
                	}
        	});
		add(b1);
		add(b2);
	}
	public void paint(Graphics g){
		g.drawString("Count is :" + x, getWidth()/2-10,getHeight()/2);

	}
	class IncButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			x++;
			repaint();
		}
	}
}


