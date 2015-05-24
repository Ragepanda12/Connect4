import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	public GameScreen(int column, int row, int players, int winning, int gameMode, GameUI parent){
		super.addMouseListener(this);
		this.numCols = column;
		this.numRows = row;
		this.players = players;
		this.winning = winning;
		this.gameState = new Game(column, row, players, winning, gameMode);
		this.parentFrame = parent;
		xIncr = (parent.getWidth() - PADDING *2)/numCols;
		System.out.println(getWidth());
		yIncr = ((parent.getHeight()*4/5)/numRows);
		coinRadius = (int) (yIncr/1.5);
		Thread thread2 = new Thread(this.gameState);
		thread2.start();
	}
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponents(g);
		//Make Grid
		for(int i=0; i<numCols;i++){
			drawCol(g2d, i, Color.BLUE);
		}
	}
	public void drawCol(Graphics g2d, int index, Color Background){
		g2d.setColor(Background);
		int xPos = PADDING + (index * xIncr);
		g2d.fillRect(xPos, 0, xIncr, getHeight());
		for(int j =0,yPos = PADDING; j< numRows;j++){
			g2d.setColor(Color.WHITE);
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
		int xPos = e.getX();
		int cPos = 0;
		while(xPos> PADDING){
			cPos++;
			xPos -= xIncr;
		}
		if(cPos > 0 && cPos <= numCols){
			this.gameState.getCurrentPlayer().setNextMove(new Move(cPos));
			System.out.println(cPos);
			drawCol(this.getGraphics(), cPos -1, Color.BLUE);
		}else{
			System.out.println("padding");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
