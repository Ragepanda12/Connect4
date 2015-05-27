import java.util.ArrayList;
import java.util.Scanner;


public class Game{
	//Fields
	private Board gameBoard;
	private ArrayList<Player> players;
	private int turnNumber;
	private int gameMode;
	private int remainingSpace;
	//Constructor
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
	public int getGameMode(){
		return this.gameMode;
	}
	public ArrayList<Spot> setMove(Move m){

		Player currentPlayer = this.players.get(this.turnNumber % this.players.size());
		Spot s = this.gameBoard.addPiece(currentPlayer, m.getColumn() - 1);
		ArrayList<Spot> win = null;
		if(s != null){
			currentPlayer.addMove(m);
			win = this.gameBoard.hasConnectFour(currentPlayer, s);
			this.turnNumber ++;
			this.remainingSpace --;
		}
		return win;
	}
	public ArrayList<Spot> setAIMove(){
		Player currentPlayer = this.players.get(this.turnNumber % this.players.size());
		Spot s = this.gameBoard.addPiece(currentPlayer, currentPlayer.getMove().getColumn());
		ArrayList<Spot> win = new ArrayList<Spot>();
		if(s != null){
			currentPlayer.addMove(new Move(s.getX()));
			System.out.println(win.size());
			win = this.gameBoard.hasConnectFour(currentPlayer, s);
			System.out.println(win.size());
			this.turnNumber ++;
			this.remainingSpace --;
		}
		if(win.size() < 4){
			win.add(s);
		}
		return win;
	}
	public int undoMove(){
		if(this.turnNumber > 0){
			this.turnNumber --;
			int index = 0;
			while(this.gameBoard.getBoard()[getCurrentPlayer().getMoves().get(getCurrentPlayer().getMoves().size()).getColumn()][index].getState() == 0){
				index ++;
			}
			this.gameBoard.getBoard()[getCurrentPlayer().getMoves().get(getCurrentPlayer().getMoves().size()).getColumn()][index].changeState(0);
		}
		return getCurrentPlayer().getMoves().get(getCurrentPlayer().getMoves().size()).getColumn();
	}
	/*public void redoMove(){
		
	}*/
	public boolean boardIsFull(){
		return this.remainingSpace <= 0;
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
	public Player getPreviousPlayer(){
		int index = this.turnNumber % (this.players.size()) - 1;
		if(index < 0){
			index = this.players.size() - 1;
		}
		return this.players.get(index);
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
