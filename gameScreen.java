import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class gameScreen extends JPanel  implements MouseListener{
	private int numCols;
	private int numRows;
	private int players;
	private int winning;
	private Game gameState;
	private GameUI parentFrame;
	public gameScreen(int column, int row, int players, int winning, int gameMode, GameUI parent){
		super.addMouseListener(this);
		this.numCols = column;
		this.numRows = row;
		this.players = players;
		this.winning = winning;
		this.gameState = new Game(column, row, players, winning, gameMode);
		this.parentFrame = parent;
	}
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponents(g);
		int xIncr = (this.parentFrame.getWidth() - 100) / numCols;
		int yIncr = (this.parentFrame.getHeight() - 100) / numRows;
		//Make Background
		g2d.setColor(Color.WHITE);
		for(int i = 50; i + xIncr <= this.parentFrame.getWidth(); i++){
			g2d.fillRect(i, 0, xIncr, this.parentFrame.getHeight());
			i += xIncr;
		}
		//Make Grid
		for(int i =0,xPos = 50; i < numCols;i++){
			for(int j =0, yPos = 100; j < numRows; j++){
				g2d.setColor(Color.BLACK);
				g2d.drawOval(xPos + (xIncr/2 -15), yPos, 30, 30);
				yPos += yIncr;
			}
			xPos += xIncr;
		}
	}
	/*
	@Override
	public void repaint(){
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponents(g);
		int xIncr = (this.getWidth() -100)/numCols;
		int yIncr = (this.getHeight() -100)/numRows;
		//Make Background
		g2d.setColor(Color.WHITE);
		for(int i=50; i+ xIncr<=getWidth();i++){
			g2d.fillRect(i, 0, xIncr, getHeight());
			i+=xIncr;
		}
		//Make Grid
		for(int i =0,xPos = 50;i < numCols;i++){
			for(int j =0,yPos = 100; j< numRows;j++){
				g2d.setColor(Color.BLACK);
				g2d.drawOval(xPos + (xIncr/2 -15), yPos, 30, 30);
				yPos += yIncr;
			}
			xPos += xIncr;
		}
	}
	*/
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
		int xPos = e.getX()+50;
		int cPos = 0;
		while(xPos - (this.getWidth()/numCols) > 0){
			cPos++;
			xPos -= this.getWidth()/numCols;
		}
		System.out.println(cPos);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
