import java.util.ArrayList;


public class Board {
	//Fields
	private ArrayList<ArrayList<Spot>> board;
	private int columns;
	private int rows;
	
	//Constructor
	public Board(){
		//Columns containing spots (Go across the top row of 7 and generate down 6 spots)
		//Spots index start from the 'top' of the game board, but is reversed in the addPiece function for printing functionality.
		int columns = 0;
		int spotsInColumn = 0;
		ArrayList<ArrayList<Spot>> Columns = new ArrayList<ArrayList<Spot>>();
		while(columns < 7){
			ArrayList<Spot> Row = new ArrayList<Spot>();
			while(spotsInColumn < 6){
				Spot s = new Spot(columns, spotsInColumn);
				Row.add(s);
				spotsInColumn ++;
			}
			spotsInColumn = 0;
			Columns.add(Row);
			columns ++;
		}
		this.board = Columns;
		this.columns = Columns.size();
		this.rows = Columns.get(0).size();
	}
	//Methods
	public ArrayList<ArrayList<Spot>> getBoard(){
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
		return this.rows - 1;
	}
	public void printBoard(){
		System.out.println("Printing board...");
		int row = 0;
		int column = 0;
		ArrayList<Spot> rowOfSpots = new ArrayList<Spot>();
		while(row < this.getRows()){
			while(column < this.getColumns()){
				rowOfSpots.add(board.get(column).get(row));
				column ++;
			}
			for (Spot s : rowOfSpots){
				System.out.print(s.getStateShort() + " ");
			}
			System.out.println();
			rowOfSpots.clear();
			row ++;
			column = 0;
		}
	}
	public Spot addPiece(Player p, int column){
		Spot toReturn = null;
		ArrayList<Spot> columnToAdd = this.board.get(column);
		int index = this.getRowsIndex();
		while(!(columnToAdd.get(index).getState().equals("Blank")) && index > 0){
			index --;
		}
		if(index > 0){
			if(columnToAdd.get(index).getState().equals("Blank")){
				toReturn = columnToAdd.get(index);
				columnToAdd.get(index).changeState(p.getColor());
			}
		}
		return toReturn;
	}
	//Only check for connect4 after someone has played a move.
	public boolean hasConnectFour(Player p, Spot s){
		boolean hasConnectFour = false;
		if(!hasConnectFour){
			hasConnectFour = hasVertConnectFour(p, s);
		}
		if(!hasConnectFour){
			hasConnectFour = hasHoriConnectFour(p, s);
		}
		if(!hasConnectFour){
			hasConnectFour = hasDiagConnectFour(p, s);
		}
		return hasConnectFour;
	}
	public boolean hasVertConnectFour(Player p, Spot s){
		boolean hasConnectFour = false;
		String type = p.getColor();
		int index = 0;
		int connected = 0;
		while(index < getRows()){
			if(this.board.get(s.getX()).get(index).getState().equals(type)){
				connected ++;
				if(connected >= 4){
					hasConnectFour = true;
					break;
				}
			}
			else{
				connected = 0;
			}
			index ++;
		}
		if(hasConnectFour){
			System.out.print("vertical win");
		}
		return hasConnectFour;
	}
	private boolean hasHoriConnectFour(Player p, Spot s){
		boolean hasConnectFour = false;
		String type = p.getColor();
		int index = 0;
		int connected = 0;
		while(index < this.getColumns()){
			if(this.board.get(index).get(s.getY()).getState().equals(type)){
				connected ++;
				if(connected >= 4){
					hasConnectFour = true;
					break;
				}
			}
			else{
				connected = 0;
			}
			index ++;
		}
		return hasConnectFour;
	}
	//This one is complicated. Still not working atm.
	//TODO
	private boolean hasDiagConnectFour(Player p, Spot s){
		boolean hasConnectFour = false;
		int connected = 0;
		int numChecked = 0;
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
		int xOrigin = xCoord;
		int yOrigin = yCoord;
		while(yCoord < getRows() && xCoord < getColumns()){
			numChecked ++;
			if(this.board.get(yCoord).get(xCoord).equals(p.getColor())){
				connected ++;
			}
			else{
				connected = 0;
			}
			if(numChecked > 4){
				if(this.board.get(yOrigin).get(xOrigin).equals(p.getColor())){
					connected --;
				}
				xOrigin ++;
				yOrigin ++;
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
	
}
