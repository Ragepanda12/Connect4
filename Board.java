import java.util.ArrayList;


public class Board {
	//Fields
	private ArrayList<ArrayList<Spot>> board;
	private int columns;
	private int rows;
	
	//Constructor
	public Board(){
		//Columns containing spots (Go across the top row of 7 and generate down 6 spots)
		//Spots index start from the 'bottom' of the game board
		int columns = 0;
		int spotsInColumn = 0;
		ArrayList<ArrayList<Spot>> Columns = new ArrayList<ArrayList<Spot>>();
		while(columns < 7){
			ArrayList<Spot> Row = new ArrayList<Spot>();
			while(spotsInColumn < 6){
				Spot s = new Spot();
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
				System.out.print(s.getState() + " ");
			}
			System.out.println();
			rowOfSpots.clear();
			row ++;
			column = 0;
		}
	}
	public boolean addPiece(Player p, int column){
		boolean addSuccess = false;
		ArrayList<Spot> columnToAdd = this.board.get(column);
		int index = this.getRows() - 1;
		while(!(columnToAdd.get(index).getState().equals("Blank")) && index > 0){
			index --;
		}
		if(columnToAdd.get(index).getState().equals("Blank")){
			addSuccess = true;
			columnToAdd.get(index).changeState(p.getColor());
		}
		return addSuccess;
	}
	public boolean hasConnectFour(Player p){
		boolean hasConnectFour = false;
		if(!hasConnectFour){
			hasConnectFour = hasVertConnectFour(p);
		}
		if(!hasConnectFour){
			hasConnectFour = hasHoriConnectFour(p);
		}
		if(!hasConnectFour){
			hasConnectFour = hasDiagConnectFour(p);
		}
		return hasConnectFour;
	}
	public boolean hasVertConnectFour(Player p){
		boolean hasConnectFour = false;
		String type = p.getColor();
		for(ArrayList<Spot> a : this.board){
			int index = 0;
			int connected = 0;
			while(index < getRows()){
				if(a.get(index).getState().equals(type)){
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
				break;
			}
		}
		if(hasConnectFour){
			System.out.print("vertical win");
		}
		return hasConnectFour;
	}
	public boolean hasHoriConnectFour(Player p){
		boolean hasConnectFour = false;
		String type = p.getColor();
		int index = 0;
		int connected = 0;
		while(index < this.getRows()){
			for(ArrayList<Spot> a : this.board){
				if(a.get(index).getState().equals(type)){
					connected ++;
					if(connected >= 4){
						hasConnectFour = true;
						break;
					}
				}
			}
			index ++;
		}
		if(hasConnectFour){
			System.out.println("Hi");
		}
		return hasConnectFour;
	}
	//This one is complicated.
	//TODO
	public boolean hasDiagConnectFour(Player p){
		boolean hasConnectFour = false;
		
		return hasConnectFour;
	}
}
