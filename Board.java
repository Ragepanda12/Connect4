import java.util.ArrayList;

/**
 * Backend representation of board state in Connect Four.
 * @author Mendel
 *
 */
public class Board {
	//Fields
	private Spot[][] board;
	private int columns;
	private int rows;
	private int goal;
	/**
	 * Create a new game board.
	 * 2d array stores the 'board', (0,0) is in the top left
	 * @param column is the number of columns in the game board.
	 * @param rows is the number of rows in the game board.
	 * @param goal is the number of connected pieces on the game board required for a win.
	 */
	//Constructor
	public Board(int column, int rows, int goal){
		this.board = new Spot[column][rows];
		int columns = 0;
		int spot = 0;
		while (columns < column){
			while(spot < rows){
				Spot s = new Spot(columns, spot);
				this.board[columns][spot] = s;
				spot ++;
			}
			spot = 0;
			columns ++;

		}
		this.columns = column;
		this.rows = rows;
		this.goal = goal;
	}
	//Methods
	/**
	 * Getter function for 2d array holding the game pieces
	 * @return the 2d array of the game
	 */
	public Spot[][] getBoard(){
		return this.board;
	}
	/**
	 * Getter function for number of columns on game board
	 * @return the number of columns as an int
	 */
	public int getColumns(){
		return this.columns;
	}
	/**
	 * Getter function for the number of rows on the game board
	 * @return the number of rows as an int
	 */
	public int getRows(){
		return this.rows;
	}
	/**
	 * Getter function for the number of rows on the game board as an array index 
	 * i.e it returns the total number of rows - 1
	 * @return The total number of rows - 1 as an int
	 */
	public int getRowsIndex(){
		return this.rows - 1;
	}
	/**
	 * Getter function for the number of columns on the game board as an array index 
	 * i.e it returns the total number of columns - 1
	 * @return The total number of columns - 1 as an int
	 */
	public int getColumnsIndex(){
		return this.columns - 1;
	}
	/**
	 * Prints out the board in an ascii state.
	 */
	public void printBoard(){
		int spot = 0;
		int column = 0;

		while(spot <= getRowsIndex()){
			while(column <= getColumnsIndex()){	
				System.out.print(this.board[column][spot].getState() + " ");
				column ++;
			}
			column = 0;
			System.out.println();
			spot ++;
		}
	}
	/**
	 * Prints out the x and y coordinates of an input list
	 * To be called when a winning list was found
	 * @param win is a list of spots containing a winning combination
	 */
	public void printWinning(ArrayList<Spot> win){
		for(Spot s : win){
			System.out.println(s.getX() + " " + s.getY());
		}
	}
	/**
	 * Adds a piece to the board.
	 * @param p is the player who is adding a piece to the board
	 * @param column is the column in which the piece is being added
	 * @return the spot in which the piece was placed.
	 */
	public Spot addPiece(Player p, int column){
		Spot toReturn = null;
		int spot = getRowsIndex();
		while(spot >= 0 ){
			if(this.board[column][spot].getState() == 0){
				this.board[column][spot].changeState(p.getColor());
				toReturn = this.board[column][spot];
				break;
			}
			spot --;
		}
		return toReturn;
	}
	/**
	 * hasConnectFour checks if a player has a winning combination spanning from an input spot.
	 * Usually called immediately after a player has played a piece to check if their input has won.
	 * @param p is the player who is being checked for being the winner
	 * @param s is the spot from which the winning checking will begin.
	 * @return a list of the winning combination if there is a win, otherwise null.
	 */
	public ArrayList<Spot> hasConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		if(hasConnectFour.size() < this.goal){
			hasConnectFour = hasVertConnectFour(p, s);
		}
		
		if(hasConnectFour.size() < this.goal){
			hasConnectFour = hasHoriConnectFour(p, s);
		}
		if(hasConnectFour.size() < this.goal){
			hasConnectFour = hasDiagDownRightConnectFour(p, s);
		}
		if(hasConnectFour.size() < this.goal){
			hasConnectFour = hasDiagUpRightConnectFour(p, s);
		}
		if(hasConnectFour.size() < this.goal){
			hasConnectFour.clear();
		}
		return hasConnectFour;
	}
	/**
	 * A private function called by hasConnectFour to check for vertical wins.
	 * @param p is the player who is being checked for being the winner
	 * @param s is the spot from which the winning checking will begin.
	 * @return a list of the winning combination if there is a win, otherwise null.
	 */
	private ArrayList<Spot> hasVertConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		int yPos = s.getY() - this.goal - 1;
		int toYPos = s.getY() + this.goal - 1;
		boolean alreadyHasConnectFour = false;
		if(yPos < 0){
			yPos = 0;
		}
		if(toYPos > getRowsIndex()){
			toYPos = getRowsIndex();
		}
		while(yPos <= toYPos){
			if(this.board[s.getX()][yPos].getState() == p.getColor()){
				hasConnectFour.add(this.board[s.getX()][yPos]);
				if(hasConnectFour.size() >= this.goal){
					alreadyHasConnectFour = true;
				}
			}
			else{
				if(!alreadyHasConnectFour){
					hasConnectFour.clear();
				}
				else{
					break;
				}
			}
			yPos ++;
		}
		return hasConnectFour;
	}
	/**
	 * A private function called by hasConnectFour to check for horizontal wins.
	 * @param p is the player who is being checked for being the winner
	 * @param s is the spot from which the winning checking will begin.
	 * @return a list of the winning combination if there is a win, otherwise null.
	 */
	private ArrayList<Spot> hasHoriConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		int xPos = s.getX() - this.goal - 1;
		int toXPos = s.getX() + this.goal - 1;
		boolean alreadyHasConnectFour = false;
		if(xPos < 0){
			xPos = 0;
		}
		if(toXPos > getColumnsIndex()){
			toXPos = getColumnsIndex();
		}
		while(xPos <= toXPos){
			if(this.board[xPos][s.getY()].getState() == p.getColor()){
				hasConnectFour.add(this.board[xPos][s.getY()]);
				if(hasConnectFour.size() >= this.goal){
					alreadyHasConnectFour = true;
				}
			}
			else{
				if(!alreadyHasConnectFour){
					hasConnectFour.clear();
				}
				else{
					break;
				}
			}
			xPos ++;
		}
		return hasConnectFour;
	}
	/**
	 * A private function called by hasConnectFour to check for descending towards the right wins.
	 * @param p is the player who is being checked for being the winner
	 * @param s is the spot from which the winning checking will begin.
	 * @return a list of the winning combination if there is a win, otherwise null.
	 */
	private ArrayList<Spot> hasDiagDownRightConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		int yPos = s.getY();
		int xPos = s.getX();
		int toCheck = this.goal - 1;
		boolean alreadyHasConnectFour = false;
		while(xPos > 0 && yPos > 0 && toCheck > 0){
			xPos --;
			yPos --;
			toCheck --;
		}
		int checked = 0;
		while(checked <= ((this.goal - 1) * 2 ) + 1){
			if(this.board[xPos][yPos].getState() == p.getColor()){
				hasConnectFour.add(this.board[xPos][yPos]);
				if(hasConnectFour.size() >= this.goal){
					alreadyHasConnectFour = true;
				}
			}
			else{
				if(!alreadyHasConnectFour){
					hasConnectFour.clear();
				}
				else{
					break;
				}
			}
			if(yPos < getRowsIndex()){
				yPos ++;
			}
			else{
				break;
			}
			if(xPos < getColumnsIndex()){
				xPos ++;
			}
			else{
				break;
			}
			checked ++;
		}
		return hasConnectFour;
	}
	/**
	 * A private function called by hasConnectFour to check for rising rightwards wins.
	 * @param p is the player who is being checked for being the winner
	 * @param s is the spot from which the winning checking will begin.
	 * @return a list of the winning combination if there is a win, otherwise null.
	 */
	private ArrayList<Spot> hasDiagUpRightConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		int yPos = s.getY();
		int xPos = s.getX();
		int toCheck = this.goal - 1;
		boolean alreadyHasConnectFour = false;
		while(xPos > 0 && yPos < getRowsIndex() && toCheck > 0){
			xPos --;
			yPos ++;
			toCheck --;
		}
		int checked = 0;
		while(checked <= ((this.goal - 1) * 2) + 1){
			if(this.board[xPos][yPos].getState() == p.getColor()){
				hasConnectFour.add(this.board[xPos][yPos]);
				if(hasConnectFour.size() >= this.goal){
					alreadyHasConnectFour = true;
				}
			}
			else{
				if(!alreadyHasConnectFour){
					hasConnectFour.clear();
				}
				else{
					break;
				}
			}
			if(yPos > 0){
				yPos --;
			}
			else{
				break;
			}
			if(xPos < getColumnsIndex()){
				xPos ++;
			}
			else{
				break;
			}
			checked ++;
		}
		return hasConnectFour;
	}
	/**
	 * Getter function for the number of connected pieces required to win.
	 * @return the number of connected pieces required to win as an int.
	 */
	public int getWinningNumber(){
		return this.goal;
	}
}
