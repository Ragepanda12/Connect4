/**
 * Representation of each of the 'holes' in the board for Connect Four.
 * @author Mendel
 *
 */
public class Spot {
	//Fields
	private int state;
	private int xcoord;
	private int ycoord;
	//Constructor
	/**
	 * Constructor for the Spot class.
	 * @param xcoord is the x position of the spot.
	 * @param ycoord is the y position of the spot.
	 */
	public Spot(int xcoord, int ycoord){
		//There has to be a better way of doing this....
		this.state = 0;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}
	//Methods
	/**
	 * Getter function for what color/id the Spot contains.
	 * @return the color/id of the Spot.
	 */
	public int getState(){
		return this.state;
	}
	/**
	 * Setter function for changing the color/id of the Spot.
	 * @param color is the color/id to change the Spot to.
	 */
	public void changeState(int color){
		this.state = color;
	}
	/**
	 * Getter function for the X coordinate of the Spot.
	 * @return the X coordinate of the Spot.
	 */
	public int getX(){
		return this.xcoord;
	}
	/**
	 * Getter function for the Y coordinate of the Spot.
	 * @return the Y coordinate of the Spot.
	 */
	public int getY(){
		return this.ycoord;
	}
}
