import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class gameScreen extends GameUI{
	private Board gameBoard;
	public gameScreen(){
		this.gameBoard = new Board(6,7,4);
	}
	/*@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponents(g);
		//Make Background
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, super.getWidth(), super.getHeight());
		//Make Grid
		int xIncr = (this.getWidth() -100)/6;
		int yIncr = (this.getHeight() -100)/7;
		for(int i =0,xPos = 50;i < 6;i++){
			for(int j =0,yPos = 100; j< 7;j++){
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
	public void mouseClicked(MouseEvent arg0) {
		System.out.println(arg0.getXOnScreen());
		
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("!");
		System.out.println(e.getX());
		
	}

	}*/

}
