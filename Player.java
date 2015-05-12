import java.util.Scanner;


public class Player {
	//Fields
	private String playerColor;
	//Constructor
	public Player(String color){
		this.playerColor = color;
	}
	//Method
	public String getColor(){
		return this.playerColor;
	}
	public int getMove(Scanner scanner){
		int column = scanner.nextInt() - 1;
		return column;
	}
}
