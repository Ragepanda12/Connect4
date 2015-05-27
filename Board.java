import java.util.ArrayList;


public class Board {
	//Fields
	private Spot[][] board;
	private int columns;
	private int rows;
	private int goal;
	
	//Constructor
	public Board(int column, int rows, int goal){
		//2d array stores the board, (0,0) is in the top left
		//Coord of a spot is this.board[toReturn.getY()][toReturn.getX()]
		this.board = new Spot[column][rows];
		int columns = 0;
		int spot = 0;
		while (columns < column){
			while(spot < rows){
				Spot s = new Spot(columns, spot);
				this.board[columns][spot] = s;
				spot ++;
			}
			spot = 0;
			columns ++;

		}
		//Yes.
		this.columns = column;
		this.rows = rows;
		this.goal = goal;
	}
	//Methods
	public Spot[][] getBoard(){
		return this.board;
	}
	//Gets the total number of columns
	public int getColumns(){
		return this.columns;
	}
	//Gets the total number of rows
	public int getRows(){
		return this.rows;
	}
	//Gets the total number of rows starting from 0
	public int getRowsIndex(){
		return this.rows - 1;
	}
	//Gets the total number of columns starting from 0
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
				System.out.print(this.board[column][spot].getState() + " ");
				column ++;
			}
			column = 0;
			System.out.println();
			spot ++;
		}
	}
	public void printWinning(ArrayList<Spot> win){
		for(Spot s : win){
			System.out.println(s.getX() + " " + s.getY());
		}
	}
	public Spot addPiece(Player p, int column){
		Spot toReturn = null;
		int spot = getRowsIndex();
		while(spot >= 0 ){
			if(this.board[column][spot].getState() == 0){
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
	//Print out coordinates of winning
	public ArrayList<Spot> hasConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		if(hasConnectFour.size() < this.goal){
			hasConnectFour = hasVertConnectFour(p, s);
		}
		
		if(hasConnectFour.size() < this.goal){
			hasConnectFour = hasHoriConnectFour(p, s);
		}
		if(hasConnectFour.size() < this.goal){
			hasConnectFour = hasDiagDownRightConnectFour(p, s);
		}
		if(hasConnectFour.size() < this.goal){
			hasConnectFour = hasDiagUpRightConnectFour(p, s);
		}
		if(hasConnectFour.size() >= goal){
			printWinning(hasConnectFour);
		}
		else{
			hasConnectFour.clear();
		}
		return hasConnectFour;
	}
	private ArrayList<Spot> hasVertConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
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
			if(this.board[s.getX()][yPos].getState() == p.getColor()){
				hasConnectFour.add(this.board[s.getX()][yPos]);
				if(hasConnectFour.size() >= this.goal){
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
			if(this.board[xPos][s.getY()].getState() == p.getColor()){
				hasConnectFour.add(this.board[xPos][s.getY()]);
				if(hasConnectFour.size() >= this.goal){
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
	private ArrayList<Spot> hasDiagDownRightConnectFour(Player p, Spot s){
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
			if(this.board[xPos][yPos].getState() == p.getColor()){
				hasConnectFour.add(this.board[xPos][yPos]);
				if(hasConnectFour.size() >= this.goal){
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
			if(this.board[xPos][yPos].getState() == p.getColor()){
				hasConnectFour.add(this.board[xPos][yPos]);
				if(hasConnectFour.size() >= this.goal){
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
	public int getWinningNumber(){
		return this.goal;
	}
}
