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
import javax.swing.SwingUtilities;

public class GameUI extends JFrame{
	private final int WIDTH = 800;
	private final int HEIGHT = WIDTH / 16 * 9;
	private final Dimension gameDimensions = new Dimension(WIDTH, HEIGHT);
	private final String TITLE = "Connect 4";
	private Graphics g;
	private SinglePlayerMenu single;
	private MultiPlayerMenu multi;
	private MainMenu mainMenu;
	private int defaultRow = 6;
	private int defaultCol = 7;
	private int defaultWin = 4;
	private int defaultPlayer = 2;
	
	public static void main(String[] args){
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            GameUI game = new GameUI();
	        }
	    });
	}

	public GameUI() {
		this.setLayout(new BorderLayout());
		init();
	}

	public int getDefaultRow(){
		return this.defaultRow;
	}
	
	public int getDefaultCol(){
		return this.defaultCol;
	}
	
	public int getDefaultWin(){
		return this.defaultWin;
	}
	
	public int getDefaultPlayer(){
		return this.defaultPlayer;
	}
	
	private void init() {
		this.setLocationRelativeTo(null);
		this.setPreferredSize(gameDimensions);
		this.setResizable(false);

		this.setTitle(TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SinglePlayerMenu single = new SinglePlayerMenu(this);
		MultiPlayerMenu multi = new MultiPlayerMenu(this);
		MainMenu main = new MainMenu(this);
		this.single = single;
		this.multi = multi;
		this.mainMenu = main;
		this.add(main);
		this.pack();
		this.setVisible(true);
		this.single.setVisible(false);
		this.multi.setVisible(false);
		this.setContentPane(this.mainMenu);
		this.mainMenu.setVisible(true);
		
	}
	public SinglePlayerMenu getSinglePlayerMenu(){
		return this.single;
	}
	public MultiPlayerMenu getMultiPlayerMenu(){
		return this.multi;
	}
	public MainMenu getMainMenu(){
		return this.mainMenu;
	}
}
