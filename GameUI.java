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

public class GameUI extends JFrame implements ActionListener {
	private final int WIDTH = 800;
	private final int HEIGHT = WIDTH / 16 * 9;
	private final Dimension gameDimensions = new Dimension(WIDTH, HEIGHT);
	private final String TITLE = "Connect 4";
	private Graphics g;

	public GameUI() {
		this.setLayout(new BorderLayout());
		init();
		System.out.println("Frame has been made");
	}

	private void init() {
		this.setLocationRelativeTo(null);
		this.setPreferredSize(gameDimensions);
		this.setResizable(false);

		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		addButtons();
		pack();
		this.setVisible(true);
	}
	public void addButtons(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JButton toMenu = new JButton("Connect 4");
		panel.add(toMenu);
		add(panel,BorderLayout.NORTH);
	}
	public void actionPerformed(ActionEvent arg0) {
		//ToDO
	}
}
