import java.util.ArrayList;
import java.util.Scanner;


public class Game{
	//Fields
	private Board gameBoard;
	private ArrayList<Player> players;
	private int turnNumber;
	//Constructor
	public Game(int columns, int rows, int players, int winningNumber, int gameMode){
		this.players = new ArrayList<Player>();
		if(gameMode == 1){
			this.gameBoard = new Board(columns , rows ,winningNumber);
			Player red = new Player(1);
			AI yellow = new AI(2, this.gameBoard);
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
	public ArrayList<Spot> setMove(Move m){

		Player currentPlayer = this.players.get(this.turnNumber % this.players.size());
		Spot s = this.gameBoard.addPiece(currentPlayer, m.getColumn() - 1);
		ArrayList<Spot> win = null;
		if(s != null){
			win = this.gameBoard.hasConnectFour(currentPlayer, s);
			this.turnNumber ++;
		}
		return win;
	}

	public Board getGameBoard(){
		return this.gameBoard;
	}
	public int getTurnNumber(){
		return this.turnNumber;
	}
	public ArrayList<Player> getPlayers(){
		return this.players;
	}
	public Player getPlayer(int index){
		return this.players.get(index);
	}
	public Player getCurrentPlayer(){
		return this.players.get(this.turnNumber % (this.players.size()));
	}
	/*Currently Broken.
	public Player runAsciiGame(){
		int player = 0;
		Player currentPlayer = this.players.get(player);
		while(true){
			//this.gameBoard.printBoard();
			System.out.println("It is currently " + currentPlayer.getColor() + "'s turn.");
			System.out.println("Please enter the column you want to put a piece in.");
			int column = currentPlayer.getMove().getColumn();
			Spot successMove = null;
			if(column >= 0 && column <= this.gameBoard.getColumnsIndex()){
				successMove = gameBoard.addPiece(currentPlayer, column);
			}
			if(successMove != null){
				if(player == 0){
					player ++;
				}
				else{
					player --;
				}
				this.turnNumber ++;
				if(this.gameBoard.hasConnectFour(currentPlayer, successMove).size() >= 4){
					//this.gameBoard.printBoard();
					break;
				}
				if(turnNumber == this.gameBoard.getColumns() * this.gameBoard.getRows()){
					break;
				}
			}
			currentPlayer = this.players.get(player);
		}
		return currentPlayer;
	}*/
}
