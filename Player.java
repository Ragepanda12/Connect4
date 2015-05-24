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
	public Move getMove(){
		boolean inputIsReady = false;
		while(!inputIsReady){
			System.out.println("Heyo");
			try {
				if(this.latestMove == 0){
					System.out.println("Sup");
					Thread.sleep(500);
				}
				else if(this.moves.get(latestInputMove) != null){
					System.out.println("HI");
					inputIsReady = true;
				}
				else{
					System.out.println("I'm here");
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		latestInputMove ++;
		return this.moves.get(latestInputMove - 1);
	}
	public void setNextMove(Move m){
		//if(this.latestInputMove != this.latestMove){
			this.moves.add(m);
			this.latestMove ++;
		//}
	}
}
