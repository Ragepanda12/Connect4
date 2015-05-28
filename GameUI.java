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

/**
 * Parent JFrame class for all JPanels.
 * Operates by generating all other major JPanels at startup, and switching between them using setVisible.
 * Game is launched from this class.
 * @author Mendel, Lance
 *
 */

public class GameUI extends JFrame{
	private final int WIDTH = 800;
	private final int HEIGHT = WIDTH / 16 * 9;
	private final Dimension gameDimensions = new Dimension(WIDTH, HEIGHT);
	private final String TITLE = "Connect 4";
	private Graphics g;
	private SinglePlayerMenu single;
	private MultiPlayerMenu multi;
	private MainMenu mainMenu;
	private GameEnclosure game;
	private int defaultRow = 6;
	private int defaultCol = 7;
	private int defaultWin = 4;
	private int defaultPlayer = 2;
	
	public static void main(String[] args){
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	GameUI g = new GameUI();
	        }
	    });
	}
	/**
	 * Constructor for the new parent JFrame.
	 */
	public GameUI() {
		this.setLayout(new BorderLayout());
		init();
	}
	/**
	 * Getter function for the width of the screen.
	 * @return the width of the screen as an int.
	 */
	public int getWidth(){
		return this.WIDTH;
	}
	/**
	 * Getter function for the height of the screen.
	 * @return the height of the screen as an int.
	 */
	public int getHeight(){
		return this.HEIGHT;
	}
	/**
	 * Getter function for the dimensions of the JPanel
	 * @return the Dimension object holding the dimensions of the JPanel.
	 */
	public Dimension getDimension(){
		return this.gameDimensions;
	}
	/**
	 * Getter function for the default number of rows in a Connect Four game.
	 * @return the default number of rows in a Connect Four game.
	 */
	public int getDefaultRow(){
		return this.defaultRow;
	}
	/**
	 * Getter function for the default number of columns in a Connect Four game.
	 * @return the default number of columns in a Connect Four game.
	 */
	public int getDefaultCol(){
		return this.defaultCol;
	}
	/**
	 * Getter function for the default number of pieces required to be connected to win a game in Connect Four.
	 * @return the default number of pieces required to be connected to win a game in Connect Four.
	 */
	public int getDefaultWin(){
		return this.defaultWin;
	}
	/**
	 * Getter function for the default number of players  in Connect Four.
	 * @return the default number of players in connect four.
	 */
	public int getDefaultPlayer(){
		return this.defaultPlayer;
	}
	/**
	 * Initialise the JFrame.
	 * Will create all other major JPanels and add them to the JFrame.
	 * Will set the MainMenu JPanel to visible as the default starting menu.
	 */
	private void init() {
		this.setLocationRelativeTo(null);
		this.setPreferredSize(gameDimensions);
		this.setResizable(false);

		this.setTitle(TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SinglePlayerMenu single = new SinglePlayerMenu(this);
		MultiPlayerMenu multi = new MultiPlayerMenu(this);
		MainMenu main = new MainMenu(this);
		GameEnclosure gameFrame = new GameEnclosure(null, this);
		this.game = gameFrame;
		this.single = single;
		this.multi = multi;
		this.mainMenu = main;
		this.pack();
		this.setVisible(true);
		this.single.setVisible(false);
		this.multi.setVisible(false);
		this.setContentPane(this.mainMenu);
		this.mainMenu.setVisible(true);
	}
	/**
	 * Getter function for the JPanel of the single player menu.
	 * @return the JPanel of the single player menu.
	 */
	public SinglePlayerMenu getSinglePlayerMenu(){
		return this.single;
	}
	/**
	 * Getter function for the JPanel of the multi player menu.
	 * @return the JPanel of the multi player menu.
	 */
	public MultiPlayerMenu getMultiPlayerMenu(){
		return this.multi;
	}
	/**
	 * Getter function for the JPanel of the main menu.
	 * @return the JPanel of the main menu.
	 */
	public MainMenu getMainMenu(){
		return this.mainMenu;
	}
	/**
	 * Setter function for the GameEnclosure in the parent JFrame.
	 * @param g is the new gameEnclosure to be used.
	 */
	public void setGameEnclosure(GameEnclosure g){
		this.game = g;
	}
	/**
	 * Getter function for the JPanel of the gameEnclosure.
	 * @return the JPanel of the gameEnclosure.
	 */
	public GameEnclosure getGameScreen(){
		return this.game;
	}
}
