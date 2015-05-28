import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 * JPanel implementation of the single player options menu.
 * @author Mendel
 *
 */
public class SinglePlayerMenu extends JPanel{
	private GameUI parentFrame;
	/**
	 * Constructor for the single player options menu/ SinglePlayerMenu class.
	 * @param parent is the parent JFrame of the JPanel.
	 */
	public SinglePlayerMenu(GameUI parent){
		this.parentFrame = parent;
		Border empty = BorderFactory.createEmptyBorder(10,10,10,10);
		GridLayout g = new GridLayout(0,2);
		this.setLayout(g);

		
		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		AAButton back = new AAButton("Back to Main Menu");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				parentFrame.setContentPane(parentFrame.getMainMenu());
				parentFrame.getMainMenu().setVisible(true);
			}
		});
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setAlignmentY(Component.CENTER_ALIGNMENT);
		AALabel options = new AALabel("Singleplayer Mode");
		options.setAlignmentX(Component.CENTER_ALIGNMENT);
		options.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		AALabel howHard = new AALabel("Please select the AI Difficulty");
		howHard.setAlignmentX(Component.CENTER_ALIGNMENT);
		howHard.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JRadioButton easy = new JRadioButton("Easy");
		easy.setMnemonic(KeyEvent.VK_B);
	    easy.setActionCommand("Easy");
	    easy.setSelected(true);
	    easy.setAlignmentX(Component.CENTER_ALIGNMENT);
	    easy.setAlignmentY(Component.CENTER_ALIGNMENT);
		
	    JRadioButton medium = new JRadioButton("Medium");
	    medium.setMnemonic(KeyEvent.VK_B);
	    medium.setActionCommand("Medium");
	    medium.setAlignmentX(Component.CENTER_ALIGNMENT);
	    medium.setAlignmentY(Component.CENTER_ALIGNMENT);
	    
	    JRadioButton hard = new JRadioButton("Hard");
	    hard.setMnemonic(KeyEvent.VK_B);
	    hard.setActionCommand("Hard");
	    hard.setAlignmentX(Component.CENTER_ALIGNMENT);
	    hard.setAlignmentY(Component.CENTER_ALIGNMENT);
	    
	    
	    final ButtonGroup group = new ButtonGroup();
        group.add(easy);
        group.add(medium);
        group.add(hard);
	    
		right.add(options);
		right.add(Box.createRigidArea(new Dimension(10, 100)));
		right.add(howHard);
		right.add(Box.createRigidArea(new Dimension(10, 25)));
		right.add(easy);
		right.add(medium);
		right.add(hard);
		right.add(Box.createRigidArea(new Dimension(10,50)));

		right.add(Box.createRigidArea(new Dimension(10, 80)));
		
		
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		String text = 
			    "Play Connect Four against an AI player in this mode.\n" +
			    "How to play:  Click on a column to place a piece in that column.\n" +
			    " Try to connect four or more pieces in a row vertically, horizontally, or diagonally to win\n" +
			    "Click on a column to add a piece to that column.";
		AATextArea textArea = new AATextArea(1,1);
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		textArea.setAlignmentY(Component.CENTER_ALIGNMENT);
		textArea.setText(text);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		left.add(textArea);
		AAButton start = new AAButton("Start Game");
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String AILevel = group.getSelection().getActionCommand();
				int ai = 0;
				if(AILevel.equals("Easy")){
					ai = 1;
				}
				else if(AILevel.equals("Medium")){
					ai = 2;
				}
				else if(AILevel.equals("Hard")){
					ai = 3;
				}
				if(parentFrame.getGameScreen().getGame() != null){
					int agree = JOptionPane.showConfirmDialog(
							null,
							"A previous game is still going. Would you like to start a new game?",
							"",
							JOptionPane.YES_NO_OPTION
					);
					if(agree == 0){

						GameScreen game = new GameScreen(parentFrame.getDefaultCol(), parentFrame.getDefaultRow(), parentFrame.getDefaultPlayer(), parentFrame.getDefaultWin(), 1, parentFrame.getGameScreen(), ai);
						setVisible(false);
						parentFrame.getGameScreen().remove(0);
						parentFrame.getGameScreen().setGame(game);
						parentFrame.getGameScreen().incrementTurnText();
						parentFrame.setContentPane(parentFrame.getGameScreen());
						parentFrame.pack();
						parentFrame.getGameScreen().setVisible(true);
						parentFrame.repaint();
					}
				}
				else{	
					GameScreen game = new GameScreen(parentFrame.getDefaultCol(), parentFrame.getDefaultRow(), parentFrame.getDefaultPlayer(), parentFrame.getDefaultWin(), 1, parentFrame.getGameScreen(), ai);
					setVisible(false);
					parentFrame.getGameScreen().setGame(game);
					parentFrame.setContentPane(parentFrame.getGameScreen());
					parentFrame.pack();
					parentFrame.getGameScreen().setVisible(true);
				}	
			}
		});
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentY(Component.CENTER_ALIGNMENT);
		left.add(Box.createRigidArea(new Dimension(10, 20)));
		left.add(back);
		right.add(start);
		left.add(Box.createRigidArea(new Dimension(10, 20)));
		right.setBorder(empty);
		left.setBorder(empty);

		this.add(left);
		this.add(right);

	}
}
