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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class MultiPlayerMenu extends JPanel{
	private GameUI parentFrame;
	public MultiPlayerMenu(GameUI parent){
		this.parentFrame = parent;
		Border empty = BorderFactory.createEmptyBorder(10,10,10,10);
		GridLayout g = new GridLayout(0,2);
		this.setLayout(g);

		
		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
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
		JLabel options = new JLabel("Multiplayer Mode");
		options.setAlignmentX(Component.CENTER_ALIGNMENT);
		options.setAlignmentY(Component.CENTER_ALIGNMENT);
		int inputRows = 6;
		int inputColumns = 7;
		int inputPlayers = 2;
		int winningNumber = 4;
		
		JLabel numrows = new JLabel("Number of Rows");
		JLabel numGameRows = new JLabel(String.valueOf(inputRows) + " (Max 20.)");
	    
	    numrows.setAlignmentX(Component.LEFT_ALIGNMENT);
	    numrows.setAlignmentY(Component.LEFT_ALIGNMENT);
	    numGameRows.setAlignmentX(Component.LEFT_ALIGNMENT);
	    numGameRows.setAlignmentY(Component.LEFT_ALIGNMENT);
	    
	    JPanel sizeBoardRow = new JPanel();
	    sizeBoardRow.setLayout(new GridLayout(0,1));
	    
		sizeBoardRow.add(numrows);
		sizeBoardRow.add(numGameRows);
	    
	    JPanel sizeBoardColumn = new JPanel();
	    sizeBoardColumn.setLayout(new GridLayout(0,1));
	    
		JLabel numCol = new JLabel("Number of Columns");
		JLabel numGameCols= new JLabel(String.valueOf(inputColumns) + " (Max 20.)");
	    
	    numCol.setAlignmentX(Component.LEFT_ALIGNMENT);
	    numCol.setAlignmentY(Component.LEFT_ALIGNMENT);
	    numGameCols.setAlignmentX(Component.LEFT_ALIGNMENT);
	    numGameCols.setAlignmentY(Component.LEFT_ALIGNMENT);
		
	    sizeBoardColumn.add(numCol);
	    sizeBoardColumn.add(numGameCols);
	    
	    JPanel numPlayers = new JPanel();
	    numPlayers.setLayout(new GridLayout(0,1));
	    JLabel players = new JLabel("Number of Players");
	    JLabel numplay = new JLabel(String.valueOf(inputPlayers) + " (Max 8.)");
	    numPlayers.add(players);
	    numPlayers.add(numplay);
	    
	    JPanel victoryPoints = new JPanel();
	    victoryPoints.setLayout(new GridLayout(0,1));
	    JLabel declaration = new JLabel("Number connected required to win");
	    JLabel numwin = new JLabel(String.valueOf(winningNumber) + " (Max 10.)");
	    victoryPoints.add(declaration);
	    victoryPoints.add(numwin);
	    
		right.add(options);
		right.add(Box.createRigidArea(new Dimension(10,20)));
		right.add(sizeBoardRow);
		right.add(sizeBoardColumn);
		right.add(numPlayers);
		right.add(victoryPoints);
		//right.add(Box.createRigidArea(new Dimension(10, 20)));
		
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
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
		left.add(textArea);
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
		left.add(Box.createRigidArea(new Dimension(10, 20)));
		left.add(back);
		right.add(start);
		left.add(Box.createRigidArea(new Dimension(10, 20)));
		right.add(Box.createRigidArea(new Dimension(10,20)));
		right.setBorder(empty);
		left.setBorder(empty);

		this.add(left);
		this.add(right);

	}
}
