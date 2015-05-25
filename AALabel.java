import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;


public class AALabel extends JLabel{  
 
	  public AALabel(String text)
	  {
	    super(text);
	  }
	  
	 
	  public void paintComponent(Graphics gr)
	  {
	    final Graphics2D g2d = (Graphics2D) gr;
	  
	    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	  
	    super.paintComponent(gr);
	  }
	  
}
