import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class GameEnclosure extends JPanel{
	private GameScreen board;
	private GameUI parentFrame;
	private AALabel turnCounter;
	public GameEnclosure(GameScreen game,  GameUI parent){
		this.parentFrame = parent;
		JPanel buttons = new JPanel();
		AALabel currentTurnText = new AALabel("Current Turn: ");
		AALabel currentTurn = new AALabel("1 :Red                    ");
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
		AAButton undo = new AAButton("Undo");
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(board.getGameState().getGameMode() == 1){
					board.getGameState().undoMove();
				}
				board.getGameState().undoMove();
				board.repaint();
				incrementTurnText();
			}
		});
		buttons.setLayout(new FlowLayout());
		buttons.add(back);
		buttons.add(currentTurnText);
		buttons.add(this.turnCounter);
		buttons.add(undo);
		buttons.setMaximumSize(buttons.getPreferredSize());
		
		this.add(buttons);
		this.setVisible(true);

	}
	public GameScreen getGame(){
		return this.board;
	}
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
		this.turnCounter.setText(String.valueOf(this.board.getGameState().getTurnNumber() + 1) + " :" + color);
	}
	public void setTurnText(String m){
		this.turnCounter.setText(m);
	}
	public void setGame(GameScreen g){
		this.board = g;
		this.add(board, 0);
		this.parentFrame.revalidate();
	}
}
