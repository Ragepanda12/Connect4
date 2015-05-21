import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private int inputRows;
	private int inputColumns;
	private int inputPlayers;
	private int winningNumber;
	public MultiPlayerMenu(GameUI parent){
		this.parentFrame = parent;
		inputRows = this.parentFrame.getDefaultRow();
		inputColumns = this.parentFrame.getDefaultCol();
		inputPlayers = this.parentFrame.getDefaultPlayer();
		winningNumber = this.parentFrame.getDefaultWin();
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

		
		JLabel numrows = new JLabel("Number of Rows");
		final JLabel numGameRows = new JLabel(String.valueOf(inputRows) + " (Max 20.)");
	    
	    numrows.setAlignmentX(Component.LEFT_ALIGNMENT);
	    numrows.setAlignmentY(Component.LEFT_ALIGNMENT);
	    numGameRows.setAlignmentX(Component.LEFT_ALIGNMENT);
	    numGameRows.setAlignmentY(Component.LEFT_ALIGNMENT);
	    
	    JPanel rowButtons = new JPanel();
	    rowButtons.setLayout(new FlowLayout());
	    
	    JButton plusRow = new JButton("+");
	    plusRow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(inputRows < 20){
					inputRows ++;
					numGameRows.setText(String.valueOf(inputRows) + " (Max 20.)");
					parentFrame.repaint();
				}
			}
		});
	    JButton minusRow = new JButton("-");
	    minusRow.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if(inputRows > 1){
	    			inputRows --;
	    			numGameRows.setText(String.valueOf(inputRows) + " (Max 20.)");
	    			parentFrame.repaint();
	    		}
	    	}
	    });
	    
	    rowButtons.add(plusRow);
	    rowButtons.add(minusRow);
	    
	    JPanel sizeBoardRow = new JPanel();
	    sizeBoardRow.setLayout(new GridLayout(2,2));
	    
		sizeBoardRow.add(numrows);
		sizeBoardRow.add(Box.createRigidArea(new Dimension(0,0)));
		sizeBoardRow.add(numGameRows);
		sizeBoardRow.add(rowButtons);
	    
	    JPanel sizeBoardColumn = new JPanel();
	    sizeBoardColumn.setLayout(new GridLayout(2,2));
	    
		JLabel numCol = new JLabel("Number of Columns");
		final JLabel numGameCols= new JLabel(String.valueOf(inputColumns) + " (Max 20.)");
	    
		JPanel columnButtons = new JPanel();
		columnButtons.setLayout(new FlowLayout());
		
	    JButton plusCol = new JButton("+");
	    plusCol.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(inputColumns < 20){
					inputColumns ++;
					numGameCols.setText(String.valueOf(inputColumns) + " (Max 20.)");
					parentFrame.repaint();
				}
			}
		});
	    JButton minusCol = new JButton("-");
	    minusCol.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if(inputColumns > 1){
	    			inputColumns --;
	    			numGameCols.setText(String.valueOf(inputColumns) + " (Max 20.)");
	    			parentFrame.repaint();
	    		}
	    	}
	    });
		
	    numCol.setAlignmentX(Component.LEFT_ALIGNMENT);
	    numCol.setAlignmentY(Component.LEFT_ALIGNMENT);
	    numGameCols.setAlignmentX(Component.LEFT_ALIGNMENT);
	    numGameCols.setAlignmentY(Component.LEFT_ALIGNMENT);
		
	    columnButtons.add(plusCol);
	    columnButtons.add(minusCol);
	    
	    sizeBoardColumn.add(numCol);
	    sizeBoardColumn.add(Box.createRigidArea(new Dimension(0,0)));
	    sizeBoardColumn.add(numGameCols);
	    sizeBoardColumn.add(columnButtons);
	    
	    JPanel numPlayers = new JPanel();
	    numPlayers.setLayout(new GridLayout(2,2));
	    JLabel players = new JLabel("Number of Players");
	    final JLabel numplay = new JLabel(String.valueOf(inputPlayers) + " (Max 8.)");
	    
	    JPanel playerButtons = new JPanel();
	    playerButtons.setLayout(new FlowLayout());
	    
	    JButton plusPlay = new JButton("+");
	    plusPlay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(inputPlayers < 8){
					inputPlayers ++;
					numplay.setText(String.valueOf(inputPlayers) + " (Max 8.)");
					parentFrame.repaint();
				}
			}
		});
	    JButton minusPlay = new JButton("-");
	    minusPlay.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if(inputPlayers > 1){
	    			inputPlayers --;
	    			numplay.setText(String.valueOf(inputPlayers) + " (Max 8.)");
	    			parentFrame.repaint();
	    		}
	    	}
	    });
	    
	    playerButtons.add(plusPlay);
	    playerButtons.add(minusPlay);
	    numPlayers.add(players);
	    numPlayers.add(Box.createRigidArea(new Dimension(0,0)));
	    numPlayers.add(numplay);
	    numPlayers.add(playerButtons);
	    
	    JPanel victoryPoints = new JPanel();
	    victoryPoints.setLayout(new GridLayout(2,2));
	    JLabel declaration = new JLabel("Winning Connection Number");
	    final JLabel numWin = new JLabel(String.valueOf(winningNumber) + " (Max 10.)");
	    
	    JButton plusWin = new JButton("+");
	    plusWin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(winningNumber < 10){
					winningNumber ++;
					numWin.setText(String.valueOf(winningNumber) + " (Max 10.)");
					parentFrame.repaint();
				}
			}
		});
	    JButton minusWin = new JButton("-");
	    minusWin.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if(winningNumber > 1){
	    			winningNumber --;
	    			numWin.setText(String.valueOf(winningNumber) + " (Max 10.)");
	    			parentFrame.repaint();
	    		}
	    	}
	    });
	    JPanel winButtons = new JPanel();
	    winButtons.setLayout(new FlowLayout());
	    winButtons.add(plusWin);
	    winButtons.add(minusWin);
	    
	    victoryPoints.add(declaration);
	    victoryPoints.add(Box.createRigidArea(new Dimension(10, 20)));
	    victoryPoints.add(numWin);
	    victoryPoints.add(winButtons);
	    
		right.add(options);
		right.add(Box.createRigidArea(new Dimension(10,20)));
		right.add(sizeBoardRow);
		right.add(sizeBoardColumn);
		right.add(numPlayers);
		right.add(victoryPoints);
		right.add(Box.createRigidArea(new Dimension(10, 25)));
		
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		String text = 
			    "Pit your Connect 4 skills against your friends in multiplayer mode!"
				+ "Set up to 8 players in a board up to 20 columns x 20 rows."
			    + "Alternatively, try new strategies in Connect 5, or even Connect 6! Anything goes, up to Connect 10."
				;
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
		
		JButton defaults = new JButton("Default Setting");
		defaults.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				inputRows = parentFrame.getDefaultRow();
				inputColumns = parentFrame.getDefaultCol();
				inputPlayers = parentFrame.getDefaultPlayer();
				winningNumber = parentFrame.getDefaultWin();
				numGameRows.setText(String.valueOf(inputRows) + " (Max 20.)");
				numGameCols.setText(String.valueOf(inputColumns) + " (Max 20.)");
				numplay.setText(String.valueOf(inputPlayers) + " (Max 8.)");
				numWin.setText(String.valueOf(winningNumber) + " (Max 10.)");
				parentFrame.repaint();
			}
		});
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(defaults);
		buttons.add(start);
		
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentY(Component.CENTER_ALIGNMENT);
		left.add(Box.createRigidArea(new Dimension(10, 20)));
		left.add(back);
		right.add(buttons);
		left.add(Box.createRigidArea(new Dimension(10, 20)));
		right.add(Box.createRigidArea(new Dimension(10,20)));
		right.setBorder(empty);
		left.setBorder(empty);

		this.add(left);
		this.add(right);

	}
}
