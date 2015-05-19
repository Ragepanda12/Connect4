import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class SinglePlayerMenu extends JPanel{
	private GameUI parentFrame;
	public SinglePlayerMenu(GameUI parent){
		this.parentFrame = parent;
		Border empty = BorderFactory.createEmptyBorder(10,10,10,10);
		GridLayout g = new GridLayout(0,2);
		this.setLayout(g);

		
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		JButton back = new JButton("Back to Main Menu");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				parentFrame.setContentPane(parentFrame.getMainMenu());
				parentFrame.getMainMenu().setVisible(true);
			}
		});
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setAlignmentY(Component.CENTER_ALIGNMENT);
		JLabel options = new JLabel("Singleplayer Mode");
		options.setAlignmentX(Component.CENTER_ALIGNMENT);
		options.setAlignmentY(Component.CENTER_ALIGNMENT);
		left.add(options);
		left.add(Box.createRigidArea(new Dimension(10, 50)));
		left.add(back);
		left.add(Box.createRigidArea(new Dimension(10, 50)));
		
		
		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		String text = 
			    "This is a placeholder text " +
			    "it will hold the rules for connect 4 " +
			    "and some explanations of options in the multiplayer menu. " +
			    "Refridgerator.";
		JTextArea textArea = new JTextArea(1,1);
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		textArea.setAlignmentY(Component.CENTER_ALIGNMENT);
		textArea.setText(text);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		right.add(textArea);
		JButton start = new JButton("Start Game");
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				parentFrame.setContentPane(parentFrame.getMainMenu());
				parentFrame.pack();
				parentFrame.getMainMenu().setVisible(true);
			}
		});
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentY(Component.CENTER_ALIGNMENT);
		right.add(Box.createRigidArea(new Dimension(10, 20)));
		right.add(start);
		right.add(Box.createRigidArea(new Dimension(10, 20)));
		left.setBorder(empty);
		right.setBorder(empty);
		this.add(left);
		this.add(right);

	}
}
