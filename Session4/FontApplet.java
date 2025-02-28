import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Toolkit;


public class FontApplet extends Applet{
	private String[] s;
	private Toolkit t = Toolkit.getDefaultToolkit();
	public void init()
	{
		s = t.getFontList(); 
	}	
	public void paint(Graphics g){
		for(int i = 0 ; i < s.length; i++)
		{
			g.drawString(s[i],100,100 + i*20);
		}

	}
}
