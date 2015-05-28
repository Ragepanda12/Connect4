import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Representation of a player of Connect Four.
 * @author Mendel
 *
 */

public class Player {
	//Fields
	private int playerColor;
	private ArrayList<Move> moves;
	private int latestMove;
	private int latestInputMove;
	//Constructor
	/**
	 * Constructor for the player class.
	 * @param color is the color/id of the player.
	 */
	public Player(int color){
		this.playerColor = color;
		this.latestMove = 0;
		this.latestInputMove = 0;
		this.moves = new ArrayList<Move>();
	}
	//Method
	/**
	 * Getter function for the color/id of the player.
	 * @return the color/id of the player as an int.
	 */
	public int getColor(){
		return this.playerColor;
	}
	/**
	 * Placeholder function for getting moves. Returns null.
	 * @return null
	 */
	public Move getMove(){
		Move m = null;
		return m;
	}
	/**
	 * Adds a move to the arraylist of moves used for the undo function.
	 * @param m is the move that the player just performed.
	 */
	public void addMove(Move m){
		this.moves.add(m);
	}
	/**
	 * Getter function for the list of moves performed by the player.
	 * @return an ArrayList of moves.
	 */
	public ArrayList<Move> getMoves(){
		return this.moves;
	}
}
