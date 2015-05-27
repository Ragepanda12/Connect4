import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;


public class AI extends Player{
	//Fields
	private Board b;
	private ArrayList<ArrayList<Integer>> ratings;
	private int level;


	private static int MAX_COLS = 7;
	private static int MAX_ROWS = 6;

	private static int GOAL = 4;


	//Constructor
	public AI(int color, Board b, int level){
		super(color);
		this.b = b;
		this.level = level;
		//Init arraylist
		ratings = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < MAX_COLS; i++) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			ratings.add(newList);
		}
	}


	//Method
	@Override
	public Move getMove(){
		//System.out.println("last move is "+scanner.next());
		//int requestedMove = Integer.parseInt(scanner.next());

		int finalMove = 0;
		//Select strategy
		int strategy = this.level; //Keep this at one for now

		if (strategy == 1) {
			//random ai
			finalMove = random();
		} else if (strategy == 2) {
			//Sometimes defensive ai
			Random rng = new Random();
			int randomInt = rng.nextInt(20);
			if(randomInt % 2 == 0){
				finalMove = searchForMove();
			}
			else{
				finalMove = random();
			}
		
		} else if (strategy == 3){
			//defensive ai
			finalMove = searchForMove();
		} else {//strategy ==3
			//harder ai if we get to it
		}
		Move m = new Move(finalMove);
		return m;

	}


	private int searchForMove()  {

		/* Defensive Strategy
		 * Note Opponent = red
		 *      AI = yellow
		 *
		 */

		//Declare Variables
		Player opponent = new Player(1); //Assuming opponent red.
											 //This is okay since we compare colours
										     //to distinguish players
		int x;
		int numVert, numHoriLeft, numHoriRight, numBottomLeft, numBottomRight, numTopLeft, numTopRight;


		/* Strategy
		 * Perform search for surrounding pieces and assign
		 * a score for each possible move
		 *
		 */

		//Define extra functions to check this
		//Can also use functions in spot class etc
		//and modify them


		for (int i = 0; i < MAX_COLS; i++) {
			//Find first available row for each column
			//Check that this method is finding the correct row with no one-off errors
			x = findFirstAvailableRow(i);
			if (x == -1) {
				continue; //Skip rows that are full
			} else if (x < -1) {
				System.out.println("****************************************INVALID ROW**********************************88");
				
			}
			//Mark this as the current spot X
			Spot currentSpot  = new Spot(i, x);
			//Compute possible moves
			numVert = hasVertConnectFour(opponent, currentSpot);

			numHoriLeft = horLeft(opponent, currentSpot);
			numHoriRight = horRight(opponent, currentSpot);
			numBottomLeft = bottomLeft(opponent, currentSpot);
			numBottomRight = bottomRight(opponent, currentSpot);
			numTopLeft = topLeft(opponent, currentSpot);
			numTopRight = topRight(opponent, currentSpot);

			if (numVert == 0 && numHoriLeft == 0 && numHoriRight == 0 && numBottomLeft == 0 && numBottomRight == 0 && numTopLeft == 0 && numTopRight == 0) {
				//continue;
			}

			//Now add ratings to the list for the current column
			addRating(numHoriLeft, numHoriRight, numVert, numBottomLeft, numBottomRight, numTopLeft, numTopRight, i);
		}

		//Calculate Best Move
		int bestMove = computeBestMove();
		//System.out.println("Best move is " +bestMove);

		//System.out.println(ratings);

		//Clear ArrayList before next calculation
		for (int i = 0; i < MAX_COLS; i++) {
			ratings.get(i).clear();
		}

		return bestMove;
	}



	/* Returns a column with the highest score (which will result in the best move) */
	private int computeBestMove() {

		int result = 0;
		int chosenColumn = 0;

		//Iterate through every column
		for (int i = 0; i < MAX_COLS; i++) {

			ArrayList<Integer> currentList = ratings.get(i);
			int temp = getHighestValue(currentList);
			if (temp > result) {
				result  = temp;
				chosenColumn = i;
			}
		}

		return chosenColumn;
	}

	/* Returns the highest value from the ArrayList */
	/* Could use priority queue, but this is simpler */
	private int getHighestValue(ArrayList<Integer> list) {
		int result = 0;
		for (Integer i: list) {
			if (i > result) {
				result = i;
			}
		}
		return result;
	}


	/* Finds first available row for a specified column (from top) */
	private int findFirstAvailableRow(int column) {
		int result = -1; //Searching from the top of board
		boolean isEmpty = true;

		//Iterate until we find a spot which is not blank
		//THen return the row before that

		for (int i = 0; i < MAX_ROWS; i++) {
			
		
			if (!(b.getBoard()[column][i].getState() == 0)) {  //Not Blank
				result = i-1;//available row is one above(-1)
				isEmpty = false;
				break;
			}
		}
		

		if (!isEmpty) {//there is at least one element in the column
			return result;
		} else {
			
			return 5;//empty therefore return bottom row (5)
		}
		

	}


	/* Adds a rating for a particular column */
	/* At this point only does horizontal/vertical */
	private void addRating(int numHorLeft, int numHorRight, int numVert, int numBottomLeft, int numBottomRight, int numTopLeft, int numTopRight, int column) {
		//Add Ratings
		int rating;

		rating = (int) Math.pow(2, numVert);
		ratings.get(column).add(rating);

		rating = (int) Math.pow(2, numHorLeft+numHorRight);
		ratings.get(column).add(rating);

		rating = (int) Math.pow(2, numBottomLeft);
		ratings.get(column).add(rating);

		rating = (int) Math.pow(2, numBottomRight);
		ratings.get(column).add(rating);

		rating = (int) Math.pow(2, numTopLeft);
		ratings.get(column).add(rating);

        	rating = (int) Math.pow(2, numTopRight);
		ratings.get(column).add(rating);
	}



	/* Given player & current position determines how many vert */
	private int hasVertConnectFour(Player p, Spot s){
		ArrayList<Spot> hasConnectFour = new ArrayList<Spot>();
		int yPos = s.getY() - 3;
		int toYPos = s.getY() + 3;
		boolean alreadyHasConnectFour = false;
		if(yPos < 0){
			yPos = 0;
		}
		if(toYPos > getRowsIndex()){
			toYPos = getRowsIndex();
		}
		while(yPos <= toYPos){
			if(this.b.getBoard()[s.getX()][yPos].getState() == p.getColor()){
				hasConnectFour.add(this.b.getBoard()[s.getX()][yPos]);
				if(hasConnectFour.size() >= GOAL){
					alreadyHasConnectFour = true;
				}
			}
			else{
				if(!alreadyHasConnectFour){
				}
				else{
					break;
				}
			}
			yPos ++;
		}
		return hasConnectFour.size();
	}


	/* Check for moves horizontally towards the left direction */
	/* Need to work backwards from current position */
	private int horLeft(Player p, Spot s){
		int score = 0;
		int xPos = s.getX() -1 ;
		int yPos = s.getY();
		
		//Start at xPos
		//Then move one left

		while (xPos > 0) {
			if (yPos <=0) {
				return score;
			}
			//If a red piece is found
			if(this.b.getBoard()[xPos][yPos].getState() == p.getColor()){
				score++;
			} else {
				break;
			}

			xPos--;
		}

		return score;
	}

	/* Check for moves horizontally towards the right direction */
	private int horRight(Player p, Spot s){
		int score = 0;
		int xPos = s.getX() + 1;
		int yPos = s.getY();

		//Start at xPos
		//Then move one left
		while (xPos < getColumnsIndex()) {
			if (yPos < 0) {
				return score;
			}
			//If a red piece is found
			if(this.b.getBoard()[xPos][yPos].getState() == (p.getColor())){
				score++;
			} else {
				break;
			}

			xPos++;
		}

		return score;
	}

	/* Check for moves diagonal towards the bottom left direction */
	private int topLeft(Player p, Spot s){
		int score = 0;
		int xPos = s.getX() - 1;
		int yPos = s.getY() - 1;
		
		//Start at xPos
		//Then move one left
		while (xPos < getColumnsIndex() && yPos <getRowsIndex()) {
			if((xPos < 0)|| (yPos < 0)){
				return score;
			}

			//If a red piece is found
			if(this.b.getBoard()[xPos][yPos].getState() == (p.getColor())){
				score++;
			} else {
				break;
			}

			xPos--;
			yPos--;
		}
		if (score != 0) {
			//System.out.println("****Current Spot is: "+s);
			//System.out.println("****In topLeft() and score is : "+score);
		}
		return score;
	}

	/* Check for moves diagonal towards the top left direction */
	private int bottomLeft(Player p, Spot s){
		int score = 0;
		int xPos = s.getX() - 1;
		int yPos = s.getY() + 1;
		//Start at xPos
		//Then move one left
		while (xPos < getColumnsIndex() && yPos <getRowsIndex()) {
			if((xPos < 0)||(yPos > 5)){
				return score;
			}
			//If a red piece is found
			if(this.b.getBoard()[xPos][yPos].getState() == (p.getColor())){
				score++;
			} else {
				break;
			}

			xPos--;
			yPos++;
		}
		
		if (score != 0) {
			//System.out.println("****Current Spot is: "+s);
			//System.out.println("****In bottomLeft() and score is : "+score);
		}

		return score;
	}

	/* Check for moves diagonal towards the bottom right direction */
	private int topRight(Player p, Spot s){
		int score = 0;
		int xPos = s.getX() + 1;
		int yPos = s.getY() - 1;
		//Start at xPos
		//Then move one left
		while (xPos < getColumnsIndex() && yPos <getRowsIndex()) {
			if((xPos > 6)||(yPos < 0)){
				return score;
			}

			//If a red piece is found
			if(this.b.getBoard()[xPos][yPos].getState() == (p.getColor())){
				score++;
			} else {
				break;
			}

			xPos++;
			yPos--;
		}
		if (score != 0) {
			//System.out.println("****Current Spot is: "+s);
			//System.out.println("****In topRight() and score is : "+score);
		}
		return score;
	}

	/* Check for moves diagonal towards the top right direction */
	private int bottomRight(Player p, Spot s){
		int score = 0;
		int xPos = s.getX() + 1;
		int yPos = s.getY() + 1;
		//Start at xPos
		//Then move one left
		while (xPos < getColumnsIndex() && yPos <getRowsIndex()) {

			//If a red piece is found
			if(this.b.getBoard()[xPos][yPos].getState() == (p.getColor())){
				score++;
				if((xPos > 6)||(yPos > 5)){
					return score;
				}				
			} else {
				break;
			}

			xPos++;
			yPos++;
		}

		
		
		if (score != 0) {
		//	System.out.println("****Current Spot is: "+s); 
		//	System.out.println("****In bottomRight() and score is : "+score);
		}
		return score;
	}
	
	private int random(){
		//returns column number
		Random rand = new Random(System.currentTimeMillis());
		//n is the column number
		int n = 7;
		int i = -1;
		int x = -1;
		while(x == -1){
			i = rand.nextInt() % n;
			if(i > 0 && i < this.MAX_COLS){
				x = findFirstAvailableRow(i);
			}
		}
		return i;
		
	}

	private int getColumnsIndex() {
		return MAX_COLS - 1;
	}

	private int getRowsIndex() {
		return MAX_ROWS - 1;
	}







}
