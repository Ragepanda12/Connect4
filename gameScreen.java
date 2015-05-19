import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;


public class gameScreen extends GameUI{
	private Board gameBoard;
	public gameScreen(){
		this.gameBoard = new Board(6,7,4);
	}
	public static void main(String args[]){
		//System.out.println("Type 1 for AI, 2 for 2p");
		//Scanner newScanner = new Scanner(System.in);
		//int gameMode = newScanner.nextInt();
		//Game newGame = new Game(gameMode);
		gameScreen gui = new gameScreen();
		//Player winner = newGame.runGame(newScanner);
		//System.out.println(winner.getColor() + " wins!");
	}
	/*@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		System.out.println(gameBoard.getColumns());
		System.out.println(this.getWidth());
		int xIncr = (this.getWidth() -100)/gameBoard.getColumns();
		int yIncr = (this.getHeight() -100)/gameBoard.getRows();
		for(int i =0,xPos = 50;i < gameBoard.getColumns();i++){
			for(int j =0,yPos = 100; j< gameBoard.getRows();j++){
				if(i %2 == 0 && j%2 == 0){
					g2d.setColor(Color.YELLOW);
				}else{
					g2d.setColor(Color.RED);
				}
				g2d.drawOval(xPos, yPos, 30, 30);
				yPos += yIncr;
			}
			xPos += xIncr;
		}
	}*/
}
