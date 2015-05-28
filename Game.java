import java.util.ArrayList;
import java.util.Scanner;
/**
 * The game representation, this class links together the use of the board and the players.
 * @author Mendel
 *
 */

public class Game{
	//Fields
	private Board gameBoard;
	private ArrayList<Player> players;
	private int turnNumber;
	private int gameMode;
	private int remainingSpace;
	//Constructor
	/**
	 * Constructor for the Game class
	 * @param columns is the number of columns on the game board
	 * @param rows is the number of rows on the game board
	 * @param players is the number of players to be playing the game
	 * @param winningNumber is the number of connected pieces required to win the game
	 * @param gameMode determines if it is single player or multiplayer mode.
	 * @param aiLevel determines the level of the ai if playing in single player mode.
	 */
	public Game(int columns, int rows, int players, int winningNumber, int gameMode, int aiLevel){
		this.players = new ArrayList<Player>();
		this.gameMode = gameMode;
		this.remainingSpace = columns * rows;
		if(gameMode == 1){
			this.gameBoard = new Board(columns , rows ,winningNumber);
			Player red = new Player(1);
			AI yellow = new AI(2, this.gameBoard, aiLevel);
			this.players.add(red);
			this.players.add(yellow);
			this.turnNumber = 0;
		}
		if(gameMode == 2){
			this.gameBoard = new Board(columns, rows, winningNumber);
			int playerNumber = 1;
			while(playerNumber <= players){
				Player player = new Player(playerNumber);
				this.players.add(player);
				playerNumber ++;
			}
		}
	}
	//Method
	/**
	 * Returns the current gameMode as an int
	 * @return the current gameMode as an int 
	 */
	public int getGameMode(){
		return this.gameMode;
	}
	/**
	 * Returns true if a column is not yet full
	 * @param column is the column to be checked 
	 * @return True if there is still space in the column, false otherwise.
	 */
	public boolean colIsNotFull(int column){
		column -= 1;
		return this.gameBoard.getBoard()[column][0].getState() == 0;
	}
	/**
	 * setMove will add a piece to the board given by the position of the input Move
	 * This is called by the front end for human player inputs.
	 * @param m is a Move object
	 * @return an arrayList of Spots which will be empty if there is no win, or contain a winning sequence.
	 */
	public ArrayList<Spot> setMove(Move m){
		Player currentPlayer = this.players.get(this.turnNumber % this.players.size());
		Spot s = this.gameBoard.addPiece(currentPlayer, m.getColumn() - 1);
		ArrayList<Spot> win = null;
		if(s != null){
			currentPlayer.addMove(m);
			win = this.gameBoard.hasConnectFour(currentPlayer, s);
		}
		if(win.size() < this.gameBoard.getWinningNumber()){
			this.turnNumber ++;
			this.remainingSpace --;
		}
		return win;
	}
	/**
	 * setAIMove will add a piece to the board based on AI input.
	 * This is called by the front end for AI player inputs.
	 * @return an arrayList of Spots which will contain the move made if there is no win, or contain a winning sequence.
	 */
	public ArrayList<Spot> setAIMove(){
		Player currentPlayer = this.players.get(this.turnNumber % this.players.size());
		Spot s = this.gameBoard.addPiece(currentPlayer, currentPlayer.getMove().getColumn());
		ArrayList<Spot> win = new ArrayList<Spot>();
		if(s != null){
			currentPlayer.addMove(new Move(s.getX()));
			win = this.gameBoard.hasConnectFour(currentPlayer, s);
			this.remainingSpace --;
		}
		if(win.size() < this.gameBoard.getWinningNumber()){
			this.turnNumber ++;
			win.add(s);
		}
		return win;
	}
	/**
	 * Returns whether or not the board has been filled.
	 * @return true if the board is full, else false.
	 */
	public boolean boardIsFull(){
		return this.remainingSpace <= 0;
	}
	/**
	 * Getter function for the board stored in game.
	 * @return the board stored in game.
	 */
	public Board getGameBoard(){
		return this.gameBoard;
	}
	/**
	 * Getter function for the current Turn Number
	 * @return the current turn number as as int
	 */
	public int getTurnNumber(){
		return this.turnNumber;
	}
	/**
	 * Getter function for the list of players.
	 * @return the list of players.
	 */
	public ArrayList<Player> getPlayers(){
		return this.players;
	}
	/**
	 * Getter function for a specific player.
	 * @param index is the index of the player in the list.
	 * @return the player at the index in the list.
	 */
	public Player getPlayer(int index){
		return this.players.get(index);
	}
	/**
	 * Getter function for the current player.
	 * @return the current player as determined by the turn number.
	 */
	public Player getCurrentPlayer(){
		return this.players.get(this.turnNumber % (this.players.size()));
	}
	/**
	 * Get the previous player.
	 * @return the previous player as determined by the turn number.
	 */
	public Player getPreviousPlayer(){
		int index = this.turnNumber % (this.players.size()) - 1;
		if(index < 0){
			index = this.players.size() - 1;
		}
		return this.players.get(index);
	}
}
