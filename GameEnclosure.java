import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameEnclosure extends JPanel{
	private gameScreen board;
	private GameUI parentFrame;
	public GameEnclosure(int columns, int rows, int players, int winningNumber, int gameMode,  GameUI parent){
		this.parentFrame = parent;
		JPanel buttons = new JPanel();
		JPanel gameBoard = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		gameScreen game = new gameScreen(columns, rows, players, winningNumber, gameMode, this.parentFrame);
		game.setVisible(true);
		this.board = game;
		JButton back = new JButton("Back to Main Menu");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				parentFrame.setContentPane(parentFrame.getMainMenu());
				parentFrame.getMainMenu().setVisible(true);
			}
		});
		buttons.add(back);
		gameBoard.add(this.board);
		this.add(buttons);
		this.add(gameBoard);
		this.setVisible(true);
		this.parentFrame.revalidate();
	}
}
