/**
 * Move is an int wrapper class used as ArrayLists cannot hold primitive types.
 * @author Mendel
 *
 */
public class Move {
	private int column;
	/**
	 * Constructor for Move class.
	 * @param column is the column in which the move added a piece.
	 */
	public Move(int column){
		this.column = column;
	}
	/**
	 * Getter function for the column in which the move added a piece.
	 * @return the column in which the move added a piece.
	 */
	public int getColumn(){
		return this.column;
	}
}
