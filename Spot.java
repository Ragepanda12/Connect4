
public class Spot {
	//Fields
	private String state;
	private int xcoord;
	private int ycoord;
	//Constructor
	public Spot(int xcoord, int ycoord){
		//There has to be a better way of doing this....
		this.state = "Blank";
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}
	//Methods
	public String getState(){
		return this.state;
	}
	public void changeState(String color){
		this.state = color;
	}
	public int getX(){
		return this.xcoord;
	}
	public int getY(){
		return this.ycoord;
	}
	public String getStateShort(){
		String firstLetter = this.state.substring(0, 1);
		return firstLetter;
	}
}
