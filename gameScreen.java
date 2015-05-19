import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


<<<<<<< HEAD
public class gameScreen extends GameUI{
	private Board gameBoard;
	public gameScreen(){
		this.gameBoard = new Board(6,7,4);
	}
	/*@Override
=======
public class gameScreen extends GameUI  implements MouseListener{
	/*
	public gameScreen(Board b){
		this.addMouseListener(l);
	}
	*/
	private int numCols;
	private int numRows;
	public gameScreen(){
		super.addMouseListener(this);
		numCols = 20;
		numRows = 10;
	}
	@Override
>>>>>>> fd27d7eb8ce091c5cd2f1ed1e4f7b7e1cd53f8ce
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponents(g);
		//Make Background
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, super.getWidth(), super.getHeight());
		//Make Grid
		int xIncr = (this.getWidth() -100)/numCols;
		int yIncr = (this.getHeight() -100)/numRows;
		for(int i =0,xPos = 50;i < numCols;i++){
			for(int j =0,yPos = 100; j< numRows;j++){
				if(i %2 == 0 && j%2 == 0){
					g2d.setColor(Color.BLACK);
				}else{
					g2d.setColor(Color.BLACK);
				}
				g2d.drawOval(xPos, yPos, 30, 30);
				yPos += yIncr;
			}
			xPos += xIncr;
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

	}*/

}
