import java.util.ArrayList;
import java.util.Scanner;


public class Game {
	//Fields
	private Board gameBoard;
	private ArrayList<Player> players;
	//Constructor
	public Game(){
		this.gameBoard = new Board(6, 7);
		Player red = new Player("red");
		Player yellow = new Player("yellow");
		this.players = new ArrayList<Player>();
		this.players.add(red);
		this.players.add(yellow);
	}
	//Method
	public static void main(String args[]){
		Game newGame = new Game();
		Player winner = newGame.runGame();
		System.out.println(winner.getColor() + " wins!");
	}
	public Player runGame(){
		Scanner scanner = new Scanner(System.in);
		int player = 0;
		Player currentPlayer = this.players.get(player);
		while(true){

			this.gameBoard.printBoard();
			System.out.println("It is currently " + currentPlayer.getColor() + "'s turn.");
			System.out.println("Please enter the column you want to put a piece in.");

			int column = scanner.nextInt() - 1;
			Spot successMove = gameBoard.addPiece(currentPlayer, column);
			if(successMove != null){
				if(player == 0){
					player ++;
				}
				else{
					player --;
				}
				if(this.gameBoard.hasConnectFour(currentPlayer, successMove).size() >= 4){
					scanner.close();
					break;
				}
			}
			currentPlayer = this.players.get(player);
		}
		return currentPlayer;
	}
}
