import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;


public class GameScreen extends JPanel  implements MouseListener{
	private int numCols;
	private int numRows;
	private int players;
	private int winning;
	private Game gameState;
	private GameUI parentFrame;
	private int xIncr, yIncr;
	private int coinRadius;
	private final int PADDING = 25;
	private Move nextMove;
	private boolean gameWon;
	public GameScreen(int column, int row, int players, int winning, int gameMode, GameUI parent){
		super.addMouseListener(this);
		this.gameWon = false;
		this.numCols = column;
		this.numRows = row;
		this.players = players;
		this.winning = winning;
		this.gameState = new Game(column, row, players, winning, gameMode);
		this.parentFrame = parent;
		xIncr = (parent.getWidth() - PADDING *2)/numCols;
		yIncr = ((parent.getHeight()*4/5)/numRows);
		coinRadius = (int) (yIncr/1.5);
		repaint();
	}
	public Game getGameState(){
		return this.gameState;
	}
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponents(g);
		//Make Grid
		for(int i=0; i<numCols;i++){
			drawCol(g2d, i, Color.BLUE);
		}
	}
	public void drawCol(Graphics g2d, int index, Color Background){
		((Graphics2D) g2d).setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Background);
		int xPos = PADDING + (index * xIncr);
		g2d.fillRect(xPos, 0, xIncr, getHeight());
		Spot[][] board = this.gameState.getGameBoard().getBoard();
		for(int j =0,yPos = PADDING; j< numRows;j++){
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
			else if(board[index][j].getState() == 8){
				g2d.setColor(Color.MAGENTA);
			}
			g2d.fillOval(xPos + (xIncr/2 -15), yPos, coinRadius, coinRadius);
			g2d.setColor(Color.BLACK);
			g2d.drawOval(xPos + (xIncr/2 -15), yPos, coinRadius, coinRadius);
			yPos += yIncr;
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(this.gameWon == false){
			int xPos = e.getX();
			int cPos = 0;
			while(xPos> PADDING){
				cPos++;
				xPos -= xIncr;
			}
			if(cPos > 0 && cPos <= numCols){
				ArrayList<Spot> winning = this.gameState.setMove(new Move(cPos));
				this.parentFrame.getGameScreen().incrementTurnText();
				//System.out.println(cPos);
				drawCol(this.getGraphics(), cPos -1, Color.BLUE);
				if(winning != null && winning.size() >= 4){
					this.gameWon = true;
				}
				
				if(this.gameState.getGameMode() == 1){
					winning = this.gameState.setAIMove();
					if(winning.size() == 1){
						cPos = winning.get(0).getX();
					}
					drawCol(this.getGraphics(), cPos, Color.BLUE);
					if(winning != null && winning.size() >= 4){
						this.gameWon = true;
					}
				}

			}else{
			//	System.out.println("padding");
			}
		}
		else{
			//No more moves if someone wins
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
