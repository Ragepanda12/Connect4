import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainMenu extends JPanel{
	//fields
	private final GameUI parentFrame;
	//Constructor
	public MainMenu(GameUI parent){
		this.parentFrame = parent;
		GridLayout grid = new GridLayout(2,1);
		this.setLayout(grid);
		JPanel topHalf = new JPanel();
		JPanel bottomHalf = new JPanel();
		JLabel welcome = new JLabel("Welcome to Connect Four!");
		welcome.setFont(new Font("Serif", Font.BOLD, 20));
		JButton Singleplayer = new JButton("Singleplayer");
		Singleplayer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				parentFrame.setContentPane(parentFrame.getSinglePlayerMenu());
				parentFrame.pack();
				parentFrame.getSinglePlayerMenu().setVisible(true);
				
			}
		});
		JButton Multiplayer = new JButton("Multiplayer");
		Multiplayer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				parentFrame.setContentPane(parentFrame.getMultiPlayerMenu());
				parentFrame.pack();
				parentFrame.getMultiPlayerMenu().setVisible(true);
			}
		});
		welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		welcome.setAlignmentY(Component.CENTER_ALIGNMENT);
		Singleplayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		Singleplayer.setAlignmentY(Component.CENTER_ALIGNMENT);
		Multiplayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		Multiplayer.setAlignmentY(Component.CENTER_ALIGNMENT);
		topHalf.add(Box.createRigidArea(new Dimension(0, 50)));
		topHalf.add(welcome);
		bottomHalf.setLayout(new BoxLayout(bottomHalf, BoxLayout.Y_AXIS));
		bottomHalf.add(Singleplayer);
		bottomHalf.add(Box.createRigidArea(new Dimension(10, 50)));
		bottomHalf.add(Multiplayer);
		this.add(topHalf);
		this.add(bottomHalf);
		this.setVisible(false);
	}

}
