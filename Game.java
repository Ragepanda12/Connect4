import java.util.ArrayList;
import java.util.Scanner;


public class Game {
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
			int playerNumber = 0;
			while(playerNumber < players){
				Player player = new Player(playerNumber);
				this.players.add(player);
				playerNumber ++;
			}
		}
	}
	//Method
	public Player runGame(Scanner newScanner){
		Scanner scanner = newScanner;
		int player = 0;
		Player currentPlayer = this.players.get(player);
		while(true){

			this.gameBoard.printBoard();
			System.out.println("It is currently " + currentPlayer.getColor() + "'s turn.");
			System.out.println("Please enter the column you want to put a piece in.");
			int column = currentPlayer.getMove(scanner);
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
					this.gameBoard.printBoard();
					scanner.close();
					break;
				}
				if(turnNumber == this.gameBoard.getColumns() * this.gameBoard.getRows()){
					break;
				}
			}
			currentPlayer = this.players.get(player);
		}
		return currentPlayer;
	}
}
