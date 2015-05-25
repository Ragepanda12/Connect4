import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Player {
	//Fields
	private int playerColor;
	private ArrayList<Move> moves;
	private int latestMove;
	private int latestInputMove;
	//Constructor
	public Player(int color){
		this.playerColor = color;
		this.latestMove = 0;
		this.latestInputMove = 0;
		this.moves = new ArrayList<Move>();
	}
	//Method
	public int getColor(){
		return this.playerColor;
	}
	/*public Move getMove(){

	}*/
}
