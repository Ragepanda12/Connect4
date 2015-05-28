import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * An enclosing JPanel for the visual game board and for a set of buttons.
 * @author Mendel
 *
 */
public class GameEnclosure extends JPanel{
	private GameScreen board;
	private GameUI parentFrame;
	private AALabel turnCounter;
	/**
	 * Constructor for the gameEnclosure screen.
	 * @param game is a UI game board.
	 * @param parent is the parent JFrame.
	 */
	public GameEnclosure(GameScreen game,  GameUI parent){
		this.parentFrame = parent;
		JPanel buttons = new JPanel();
		AALabel currentTurnText = new AALabel("Current Turn: ");
		AALabel currentTurn = new AALabel("1 :Red             ");
		this.turnCounter = currentTurn;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.board = game;
		AAButton back = new AAButton("Back to Main Menu");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				parentFrame.setContentPane(parentFrame.getMainMenu());
				parentFrame.getMainMenu().setVisible(true);
				AAButton resume = new AAButton("Resume Game");
				parentFrame.getMainMenu().addButton(resume);
				resume.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						setVisible(false);
						parentFrame.setContentPane(parentFrame.getGameScreen());
						parentFrame.pack();
						parentFrame.getGameScreen().setVisible(true);		
					}
				});
			}
		});
		buttons.setLayout(new FlowLayout());
		buttons.add(back);
		buttons.add(currentTurnText);
		buttons.add(this.turnCounter);
		buttons.setMaximumSize(buttons.getPreferredSize());
		
		this.add(buttons);
		this.setVisible(true);

	}
	/**
	 * Getter function for the visual gameboard.
	 * @return the JPanel containing the visual game board.
	 */
	public GameScreen getGame(){
		return this.board;
	}
	/**
	 * Used to change the turn text to the appropriate number, despite being called increment turn.
	 * Can be called to change the turn number back to zero if the current turn is zero.
	 */
	public void incrementTurnText(){
		Player currentPlayer = this.board.getGameState().getCurrentPlayer();
		String color = "";
		if(currentPlayer.getColor() == 1){
			color = "Red";
		}
		else if(currentPlayer.getColor()  == 2){
			color = "Yellow";
		}
		else if(currentPlayer.getColor()  == 3){
			color = "Green";
		}
		else if(currentPlayer.getColor()  == 4){
			color = "Black";
		}
		else if(currentPlayer.getColor()  == 5){
			color = "Cyan";
		}
		else if(currentPlayer.getColor()  == 6){
			color = "Pink";
		}
		else if(currentPlayer.getColor()  == 7){
			color = "Grey";
		}
		setTurnText(String.valueOf(this.board.getGameState().getTurnNumber() + 1) + " :" + color);
	}
	/**
	 * public interface for changing the text of the turn counter JLabel
	 * @param m is the string to change the JLabel to.
	 */
	public void setTurnText(String m){
		this.turnCounter.setText(m);
	}
	/**
	 * Sets a new game into the gameEnclosure.
	 * @param g is a UI game screen.
	 */
	public void setGame(GameScreen g){
		this.board = g;
		this.add(board, 0);
		this.parentFrame.revalidate();
	}
}
