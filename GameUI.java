import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameUI extends JFrame{
	private final int WIDTH = 800;
	private final int HEIGHT = WIDTH / 16 * 9;
	private final Dimension gameDimensions = new Dimension(WIDTH, HEIGHT);
	private final String TITLE = "Connect 4";
	private Graphics g;

	public GameUI() {
		this.setLayout(new BorderLayout());
		init();
	}

	private void init() {
		this.setLocationRelativeTo(null);
		this.setPreferredSize(gameDimensions);
		this.setResizable(false);

		this.setTitle(TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SinglePlayerMenu single = new SinglePlayerMenu();
		MultiPlayerMenu multi = new MultiPlayerMenu();
		MainMenu main = new MainMenu(single, multi);
		this.add(main);
		this.pack();
		this.setVisible(true);
		single.setVisible(false);
		main.setVisible(true);
		
	}
}
