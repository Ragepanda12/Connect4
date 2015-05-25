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
		JPanel gameBoard = new JPanel();
		AALabel currentTurnText = new AALabel("Current Turn: ");
		AALabel currentTurn = new AALabel("0         ");
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
	public GameScreen getGame(){
		return this.board;
	}
	public void incrementTurnText(){
		this.turnCounter.setText(String.valueOf(this.board.getGameState().getTurnNumber()));
	}
	public void setTurnText(String m){
		this.turnCounter.setText(m);
	}
	public void setGame(GameScreen g){
		this.board = g;
		this.add(board);
		this.parentFrame.revalidate();
	}
}
