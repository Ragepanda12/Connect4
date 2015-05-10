import java.util.ArrayList;


public class Board {
	//Fields
	private Spot[][] board;
	private int columns;
	private int rows;
	
	//Constructor
	public Board(int column, int rows){
		//2d array stores the board, (0,0) is in the top left
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
		while(column < getColumns()){	
			while(spot < getRows()){
				System.out.print(this.board[column][spot].getState() + " ");
				spot ++;
			}
			spot = 0;
			System.out.println();
			column ++;
		}
	}
	public Spot addPiece(Player p, int column){
		Spot toReturn = null;
		int spot = getColumnsIndex();
		while(spot >= 0){
			if(this.board[spot][column].getState().equals("Blank")){
				this.board[spot][column].changeState(p.getColor());
				toReturn = this.board[spot][column];
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
		/*if(hasConnectFour.size() < 4){
			hasConnectFour = hasDiagConnectFour(p, s);
		}*/
		return hasConnectFour;
	}
	public ArrayList<Spot> hasVertConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		int searchFrom = s.getX() - 3;
		int searchUntil = s.getX() + 3;
		if(searchFrom < 0){
			searchFrom = 0;
		}
		if(searchUntil > getRowsIndex()){
			searchUntil = getRowsIndex();
		}
		while(searchFrom != searchUntil){
			if(this.board[searchFrom][s.getX()].getState().equals(p.getColor())){
				hasConnectFour.add(this.board[searchFrom][s.getX()]);
			}
			else{
				hasConnectFour.clear();
			}
			if(hasConnectFour.size() >= 4){
				break;
			}
			searchFrom ++;
		}
		return hasConnectFour;
	}
	private ArrayList<Spot> hasHoriConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		int searchFrom = s.getY() - 3;
		int searchUntil = s.getY() + 3;
		if(searchFrom < 0){
			searchFrom = 0;
		}
		if(searchUntil > getColumnsIndex()){
			searchUntil = getColumnsIndex();
		}
		while(searchFrom != searchUntil){
			if(this.board[s.getY()][searchFrom].getState().equals(p.getColor())){
				hasConnectFour.add(this.board[s.getY()][searchFrom]);
			}
			else{
				hasConnectFour.clear();
			}
			if(hasConnectFour.size() >= 4){
				break;
			}
			searchFrom ++;
		}
		return hasConnectFour;
	}
	/*
	//This one is complicated. Still not working atm.
	//TODO
	private ArrayList<Spot> hasDiagConnectFour(Player p, Spot s){
		//Left to right down checking
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		int connected = 0;
		int yCoord = s.getX();
		int xCoord = s.getY();
		if(yCoord > xCoord){
			yCoord -= xCoord;
			xCoord = 0;
		}
		else if(xCoord < yCoord){
			xCoord -= yCoord;
			yCoord = 0;
		}
		else{
			xCoord = 0;
			yCoord= 0;
		}
		while(yCoord < getRowsIndex() && xCoord < getColumnsIndex()){
			if(this.board.get(yCoord).get(xCoord).equals(p.getColor())){
				connected ++;
			}
			else{
				connected = 0;
			}
			if(connected >= 4){
				hasConnectFour = true;
				break;
			}
			yCoord ++;
			xCoord ++;
		}
		return hasConnectFour;
	}
	*/
}
