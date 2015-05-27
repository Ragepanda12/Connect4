import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextArea;

/**
 * Anti-Aliased extension of JTextAreas.
 * @author Mendel/Lance/Carmen/Aaron
 *
 */
public class AATextArea extends JTextArea{  
 /**
  * Create a new Text area
  * @param a is the number of rows in the JTextArea
  * @param b is the number of columns in the JTextArea
  */
	  public AATextArea(int a, int b)
	  {
	    super(a, b);

	  }
	  
	 
	  public void paintComponent(Graphics gr)
	  {
	    final Graphics2D g2d = (Graphics2D) gr;
	  
	    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	  
	    super.paintComponent(gr);
	  }
	  
}
