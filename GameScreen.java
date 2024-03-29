import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * The UI representation of the Connect Four game board.
 * @author Mendel, Lance
 *
 */

public class GameScreen extends JPanel  implements MouseListener{
	private int numCols;
	private int numRows;
	private int players;
	private int winning;
	private Game gameState;
	private GameEnclosure parentPanel;
	private int xIncr, yIncr;
	private int coinRadius;
	private int PADDING;
	private Move nextMove;
	private boolean gameWon;
	/**
	 * Constructor for the UI game board.
	 * Also makes a new backend game and uses it as a reference for what to draw.
	 * @param column is the number of columns in the new game.
	 * @param row is the number of rows in the new game.
	 * @param players is the number of players in the new game.
	 * @param winning is the number of connected pieces required to win in the new game.
	 * @param gameMode is the mode of the game, either single player against AI, or multiplayer.
	 * @param parent is the parent JFrame.
	 * @param ai is the level of the AI to use if the single player mode is used.
	 */
	public GameScreen(int column, int row, int players, int winning, int gameMode, GameEnclosure parent, int ai){
		super.addMouseListener(this);
		this.gameWon = false;
		this.numCols = column;
		this.numRows = row;
		this.players = players;
		this.winning = winning;
		this.PADDING = 0;
		this.gameState = new Game(column, row, players, winning, gameMode, ai);
		this.parentPanel = parent;
		xIncr = (parent.getParentFrame().getWidth())/numCols;
		yIncr = ((parent.getParentFrame().getHeight()*9/10)/(numRows + 1));
		coinRadius = (int) (yIncr/1.05);
		repaint();
	}
	/**
	 * Getter function for the backend game representation.
	 * @return the backend Game object.
	 */
	public Game getGameState(){
		return this.gameState;
	}
	@Override
	/**
	 * Override function of a JPanel, will paint the board.
	 * @param g is the graphics object used to draw the board.
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponents(g);
		//Make Grid
		for(int i=0; i<numCols;i++){
			drawCol(g2d, i, new Color(31, 190, 214,255));
		}
	}
	/**
	 * drawCol will redraw a given column in the JPanel.
	 * @param g2d is the graphics object used to draw the graphics
	 * @param index is the index of the column to be redrawn
	 * @param Background is the color of the background to be drawn.
	 */
	public void drawCol(Graphics g2d, int index, Color Background){
		((Graphics2D) g2d).setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Background);
		int xPos = PADDING + (index * xIncr);
		g2d.fillRect(xPos, 0, xIncr, getHeight());
		Spot[][] board = this.gameState.getGameBoard().getBoard();
		for(int j =0,yPos = this.yIncr/2; j< numRows;j++){
			if(board[index][j].getState() == 0){
				g2d.setColor(Color.WHITE);
			}
			else if(board[index][j].getState() == 1){
				g2d.setColor(Color.RED);
			}
			else if(board[index][j].getState() == 2){
				g2d.setColor(Color.YELLOW);
			}
			else if(board[index][j].getState() == 3){
				g2d.setColor(Color.GREEN);
			}
			else if(board[index][j].getState() == 4){
				g2d.setColor(Color.BLACK);
			}
			else if(board[index][j].getState() == 5){
				g2d.setColor(Color.CYAN);
			}
			else if(board[index][j].getState() == 6){
				g2d.setColor(Color.PINK);
			}
			else if(board[index][j].getState() == 7){
				g2d.setColor(Color.LIGHT_GRAY);
			}
			else if(board[index][j].getState() == -1){
				g2d.setColor(Color.MAGENTA);
			}
			g2d.fillOval(xPos + (xIncr/2 -15), yPos, coinRadius, coinRadius);
			g2d.setColor(Color.BLACK);
			g2d.drawOval(xPos + (xIncr/2 -15), yPos, coinRadius, coinRadius);
			yPos += yIncr;
		}
	}


	@Override
	/**
	 * Function for handling player inputs on the board via clicking.
	 * Will add a piece into the given column, and update turn counters, etc as required.
	 * @param e is the event produced when a click occurs.
	 */
	public void mousePressed(MouseEvent e) {
		if(this.gameWon == false && !this.getGameState().boardIsFull()){
			int xPos = e.getX();
			int cPos = 0;
			while(xPos> PADDING){
				cPos++;
				xPos -= xIncr;
			}
			if(cPos > 0 && cPos <= numCols){
				if(this.gameState.colIsNotFull(cPos)){
					ArrayList<Spot> winning = this.gameState.setMove(new Move(cPos));
					if(winning != null){
						drawCol(this.getGraphics(), cPos -1, new Color(31, 190, 214,255));
					
						if(winning != null && winning.size() >= this.gameState.getGameBoard().getWinningNumber()){
							for(Spot s : winning){
								this.gameState.getGameBoard().getBoard()[s.getX()][s.getY()].changeState(-1);
								drawCol(this.getGraphics(), s.getX(), new Color(31, 190, 214,255));
							}
							this.gameWon = true;
							Player currentPlayer = this.gameState.getCurrentPlayer();
							String color = "";
							if(currentPlayer.getColor() == 1){
								color = "Red";
							}
							else if(currentPlayer.getColor()  == 2){
								color = "Yellow";
							}
							else if(currentPlayer.getColor()  == 3){
								color = "Green";
							}
							else if(currentPlayer.getColor()  == 4){
								color = "Black";
							}
							else if(currentPlayer.getColor()  == 5){
								color = "Cyan";
							}
							else if(currentPlayer.getColor()  == 6){
								color = "Pink";
							}
							else if(currentPlayer.getColor()  == 7){
								color = "Grey";
							}
							JOptionPane.showMessageDialog(this.parentPanel.getParentFrame(), "Player " + currentPlayer.getColor() + " (" + color + ") won!");
						}
						if(this.gameWon != true){
							if(this.gameState.getGameMode() == 1){
								winning = this.gameState.setAIMove();
								if(winning.size() == 1){
									cPos = winning.get(0).getX();
									drawCol(this.getGraphics(), cPos, new Color(31, 190, 214,255));
								}
								if(winning != null && winning.size() >= this.gameState.getGameBoard().getWinningNumber()){
									for(Spot s : winning){
										this.gameState.getGameBoard().getBoard()[s.getX()][s.getY()].changeState(-1);
										drawCol(this.getGraphics(), s.getX(), new Color(31, 190, 214,255));
									}
									this.gameWon = true;
									JOptionPane.showMessageDialog(this.parentPanel.getParentFrame(), "The AI Player won!");
								}
							}
						}
						this.parentPanel.getParentFrame().getGameScreen().incrementTurnText();
					}
					if(this.getGameState().boardIsFull()){
						JOptionPane.showMessageDialog(this.parentPanel.getParentFrame(), "Game Draw!");
					}
					this.parentPanel.getParentFrame().getGameScreen().incrementTurnText();
				}
			}
		}
		else{
			//No more moves if someone wins
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
