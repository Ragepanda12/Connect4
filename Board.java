import java.util.ArrayList;


public class Board {
	//Fields
	private ArrayList<ArrayList<Spot>> board;
	
	//Constructor
	public Board(){
      //Columns containing rows
		int counter = 0;
		int counterTwo = 0;
		ArrayList<ArrayList<Spot>> Columns = new ArrayList<ArrayList<Spot>>();
		while(counterTwo < 6){
			ArrayList<Spot> Row = new ArrayList<Spot>();
			while(counter < 7){
				Spot s = new Spot();
				Row.add(s);
				counter ++;
			}
			Columns.add(Row);
			counterTwo ++;
		}
		this.board = Columns;
	}
	//Methods
	public ArrayList<ArrayList<Spot>> getBoard(){
		return this.board;
	}
	public boolean hasConnectFour(Player p){
		boolean hasConnectFour = false;
		if(!hasConnectFour){
			hasConnectFour = hasHoriConnectFour(p);
		}
		if(!hasConnectFour){
			hasConnectFour = hasVertConnectFour(p);
		}
		if(!hasConnectFour){
			hasConnectFour = hasDiagConnectFour(p);
		}
		return hasConnectFour;
	}
	public boolean hasHoriConnectFour(Player p){
		boolean hasConnectFour = false;
		String type = p.getColor();
		for(ArrayList<Spot> a : this.board){
			int index = 0;
			int connected = 0;
			while(index < 7){
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
		}
		return hasConnectFour;
	}
	public boolean hasVertConnectFour(Player p){
		boolean hasConnectFour = false;
		String type = p.getColor();
		int index = 0;
		int connected = 0;
		while(index < 6){
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
		return hasConnectFour;
	}
	//This one is complicated.
	public boolean hasDiagConnectFour(Player p){
		boolean hasConnectFour = false;
		
		return hasConnectFour;
	}
}
