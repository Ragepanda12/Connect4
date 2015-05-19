import java.awt.GridLayout;

import javax.swing.JPanel;


public class SinglePlayerMenu extends JPanel{
	public SinglePlayerMenu(){
		GridLayout g = new GridLayout(0,2);
		this.setLayout(g);
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		this.add(left);
		this.add(right);
		
	}
}
