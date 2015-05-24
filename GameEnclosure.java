import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameEnclosure extends JPanel{
	private GameScreen board;
	private GameUI parentFrame;
	public GameEnclosure(GameScreen game,  GameUI parent){
		this.parentFrame = parent;
		JPanel buttons = new JPanel();

		JPanel gameBoard = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
		buttons.setMaximumSize(buttons.getPreferredSize());
		this.add(buttons);
		this.setVisible(true);

	}
	public GameScreen getGame(){
		return this.board;
	}
	public void setGame(GameScreen g){
		this.board = g;
		this.add(board);
		this.parentFrame.revalidate();
	}
}
