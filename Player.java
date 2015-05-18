import java.util.Scanner;


public class Player {
	//Fields
	private int playerColor;
	//Constructor
	public Player(int color){
		this.playerColor = color;
	}
	//Method
	public int getColor(){
		return this.playerColor;
	}
	public int getMove(Scanner scanner){
		int column = scanner.nextInt() - 1;
		return column;
	}
}
