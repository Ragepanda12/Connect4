import java.util.ArrayList;


public class Board {
	//Fields
	private Spot[][] board;
	private int columns;
	private int rows;
	
	//Constructor
	public Board(int column, int rows){
		//2d array stores the board, (0,0) is in the top left
		//Coord of a spot is this.board[toReturn.getY()][toReturn.getX()]
		this.board = new Spot[column][rows];
		int columns = 0;
		int spot = 0;
		while (columns < column){
			while(spot < rows){
				Spot s = new Spot(spot, columns);
				this.board[columns][spot] = s;
				spot ++;
			}
			spot = 0;
			columns ++;

		}
		//Yes.
		this.columns = column;
		this.rows = rows;
	}
	//Methods
	public Spot[][] getBoard(){
		return this.board;
	}
	public int getColumns(){
		return this.columns;
	}
	public int getRows(){
		return this.rows;
	}
	public int getRowsIndex(){
		return this.rows - 1;
	}
	public int getColumnsIndex(){
		return this.columns - 1;
	}
	public Spot[] getSpecificColumnIndex(int column){
		return this.board[column];
	}
	public void printBoard(){
		System.out.println("Printing board...");
		int spot = 0;
		int column = 0;

		while(spot <= getRowsIndex()){
			while(column <= getColumnsIndex()){	
				System.out.print(this.board[column][spot].getStateShort() + " ");
				column ++;
			}
			column = 0;
			System.out.println();
			spot ++;
		}
	}
	public Spot addPiece(Player p, int column){
		Spot toReturn = null;
		int spot = getRowsIndex();
		while(spot >= 0 ){
			if(this.board[column][spot].getState().equals("Blank")){
				this.board[column][spot].changeState(p.getColor());
				toReturn = this.board[column][spot];
				break;
			}
			spot --;
		}
		return toReturn;
	}
	//Only check for connect4 after someone has played a move.
	//Return a list of the connect 4 generated, empty list if no connect 4
	public ArrayList<Spot> hasConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		if(hasConnectFour.size() < 4){
			hasConnectFour = hasVertConnectFour(p, s);
		}
		if(hasConnectFour.size() < 4){
			hasConnectFour = hasHoriConnectFour(p, s);
		}
		if(hasConnectFour.size() < 4){
			hasConnectFour = hasDiagDownRightConnectFour(p, s);
		}
		if(hasConnectFour.size() < 4){
			hasConnectFour = hasDiagUpRightConnectFour(p, s);
		}
		return hasConnectFour;
	}
	public ArrayList<Spot> hasVertConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		//this.board[s.getX()][s.getY()];
		int yPos = s.getY() - 3;
		int toYPos = s.getY() + 3;
		boolean alreadyHasConnectFour = false;
		if(yPos < 0){
			yPos = 0;
		}
		if(toYPos > getRowsIndex()){
			toYPos = getRowsIndex();
		}
		while(yPos <= toYPos){
			if(this.board[s.getX()][yPos].getState().equals(p.getColor())){
				hasConnectFour.add(this.board[s.getX()][yPos]);
				if(hasConnectFour.size() >= 4){
					System.out.println("Vert");
					alreadyHasConnectFour = true;
				}
			}
			else{
				if(!alreadyHasConnectFour){
					hasConnectFour.clear();
				}
				else{
					break;
				}
			}
			yPos ++;
		}
		return hasConnectFour;
	}
	private ArrayList<Spot> hasHoriConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		//this.board[s.getX()][s.getY()];
		int xPos = s.getX() - 3;
		int toXPos = s.getX() + 3;
		boolean alreadyHasConnectFour = false;
		if(xPos < 0){
			xPos = 0;
		}
		if(toXPos > getColumnsIndex()){
			toXPos = getColumnsIndex();
		}
		while(xPos <= toXPos){
			if(this.board[xPos][s.getY()].getState().equals(p.getColor())){
				hasConnectFour.add(this.board[xPos][s.getY()]);
				if(hasConnectFour.size() >= 4){
					System.out.println("Hori");
					alreadyHasConnectFour = true;
				}
			}
			else{
				if(!alreadyHasConnectFour){
					hasConnectFour.clear();
				}
				else{
					break;
				}
			}
			xPos ++;
		}
		return hasConnectFour;
	}
	
	//This one is complicated. Still not working atm.
	//TODO
	private ArrayList<Spot> hasDiagDownRightConnectFour(Player p, Spot s){
		//DOWNRIGHT MATCHING
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		int yPos = s.getY();
		int xPos = s.getX();
		int three = 3;
		boolean alreadyHasConnectFour = false;
		while(xPos > 0 && yPos > 0 && three > 0){
			xPos --;
			yPos --;
			three--;
		}
		int checked = 0;
		while(checked <= 7){
			if(this.board[xPos][yPos].getState().equals(p.getColor())){
				hasConnectFour.add(this.board[xPos][yPos]);
				if(hasConnectFour.size() >= 4){
					alreadyHasConnectFour = true;
				}
			}
			else{
				if(!alreadyHasConnectFour){
					hasConnectFour.clear();
				}
				else{
					break;
				}
			}
			if(yPos < getRowsIndex()){
				yPos ++;
			}
			else{
				break;
			}
			if(xPos < getColumnsIndex()){
				xPos ++;
			}
			else{
				break;
			}
			checked ++;
		}
		return hasConnectFour;
	}
	private ArrayList<Spot> hasDiagUpRightConnectFour(Player p, Spot s){
		//UPRIGHT MATCHING
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		int yPos = s.getY();
		int xPos = s.getX();
		int three = 3;
		boolean alreadyHasConnectFour = false;
		while(xPos > 0 && yPos < getRowsIndex() && three > 0){
			xPos --;
			yPos ++;
			three--;
		}
		int checked = 0;
		while(checked <= 7){
			if(this.board[xPos][yPos].getState().equals(p.getColor())){
				hasConnectFour.add(this.board[xPos][yPos]);
				if(hasConnectFour.size() >= 4){
					alreadyHasConnectFour = true;
				}
			}
			else{
				if(!alreadyHasConnectFour){
					hasConnectFour.clear();
				}
				else{
					break;
				}
			}
			if(yPos > 0){
				yPos --;
			}
			else{
				break;
			}
			if(xPos < getColumnsIndex()){
				xPos ++;
			}
			else{
				break;
			}
			checked ++;
		}
		return hasConnectFour;
	}
}
