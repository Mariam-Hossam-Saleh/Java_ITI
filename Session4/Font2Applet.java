import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.awt.Font;

public class Font2Applet extends Applet{
	private String[] s;
	private GraphicsEnvironment graphic = GraphicsEnvironment.getLocalGraphicsEnvironment();
	public void init()
	{
		s = graphic.getAvailableFontFamilyNames();
	}	
	public void paint(Graphics g){

		for(int i = 0 ; i < s.length; i++)
		{
			Font f = new Font(s[i],Font.BOLD,20);
			g.setFont(f);
			g.drawString(s[i],10,20 + i*20);
		}

	}
}
