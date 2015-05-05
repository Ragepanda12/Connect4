
public class Spot {
	//Fields
	private String state;
	//Constructor
	public Spot(){
		//There has to be a better way of doing this....
		this.state = "Blank";
	}
	//Methods
	public String getState(){
		return this.state;
	}
	public void changeState(String color){
		this.state = color;
	}
}
