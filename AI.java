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
	public Move getMove(){
		int toPut = 0;
		if(!(b.getBoard()[toPut][0].getState() == 0)){
			toPut ++;
		}
		Move m = new Move(toPut);
		return m;
	}

}

