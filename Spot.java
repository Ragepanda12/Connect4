
public class Spot {
	//Fields
	private int state;
	private int xcoord;
	private int ycoord;
	//Constructor
	public Spot(int xcoord, int ycoord){
		//There has to be a better way of doing this....
		this.state = 0;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}
	//Methods
	public int getState(){
		return this.state;
	}
	public void changeState(int color){
		this.state = color;
	}
	public int getX(){
		return this.xcoord;
	}
	public int getY(){
		return this.ycoord;
	}
}
