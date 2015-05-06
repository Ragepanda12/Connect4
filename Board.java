import java.util.ArrayList;


public class Board {
	//Fields
	private ArrayList<ArrayList<Spot>> board;
	private int columns;
	private int rows;
	
	//Constructor
	public Board(){
		//Columns containing rows (Go across the top row of 7 and generate down 6 rows of 1
		//Spots index start from the 'bottom' of the game board
		int counter = 0;
		int counterTwo = 0;
		ArrayList<ArrayList<Spot>> Columns = new ArrayList<ArrayList<Spot>>();
		System.out.println("Generating Board...");
		while(counterTwo < 7){
			ArrayList<Spot> Row = new ArrayList<Spot>();
			while(counter < 6){
				System.out.print("Blank ");
				Spot s = new Spot();
				Row.add(s);
				counter ++;
			}
			System.out.println();
			counter = 0;
			Columns.add(Row);
			counterTwo ++;
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
		while(column < this.columns){
			while(row < this.rows){
			System.out.print(this.board.get(column).get(row).getState() + " ");
			row ++;
			}
			row = 0;
			column ++;
			System.out.println();
		}
		System.out.println();
	}
	public boolean addPiece(Player p, int column){
		boolean addSuccess = false;
		ArrayList<Spot> columnToAdd = this.board.get(column);
		int index = 0;
		while(!(columnToAdd.get(index).getState().equals("Blank")) && index < 6){
			index ++;
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
	public boolean hasDiagConnectFour(Player p){
		boolean hasConnectFour = false;
		
		return hasConnectFour;
	}
}
