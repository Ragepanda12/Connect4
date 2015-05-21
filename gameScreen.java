import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


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
		numCols = 6;
		numRows = 7;
	}
	@Override
	public void paint(Graphics g) {
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
