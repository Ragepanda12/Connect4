import java.util.Scanner;


public class AI extends Player{
	//Fields
	private Board b;
	//Constructor
	public AI(int color, Board b){
		super(color);
		this.b = b;
	}
	//Method
	@Override
	//10/10 strat
	public int getMove(Scanner scanner){
		int toPut = 0;
		if(!(b.getBoard()[toPut][0].getState() == 0)){
			toPut ++;
		}
		return toPut;
	}

}

