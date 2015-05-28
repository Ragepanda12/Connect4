import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * JPanel which contains the main menu screen.
 * @author Mendel
 *
 */
public class MainMenu extends JPanel{
	//fields
	private final GameUI parentFrame;
	private JPanel bottomHalf;
	private boolean hasResume;
	//Constructor
	/**
	 * Constructor for the MainMenu class.
	 * @param parent is the JFrame in which this JPanel is contained.
	 */
	public MainMenu(GameUI parent){
		this.parentFrame = parent;
		this.hasResume = false;
		GridLayout grid = new GridLayout(2,1);
		this.setLayout(grid);
		JPanel topHalf = new JPanel();
		JPanel bottomHalf = new JPanel();
		this.bottomHalf = bottomHalf;
		AALabel welcome = new AALabel("Welcome to Connect Four!"){
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D graphics2d = (Graphics2D) g;
                graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                super.paintComponent(g);
            }
        };
		welcome.setFont(new Font("Serif", Font.BOLD, 20));
		AAButton Singleplayer = new AAButton("Singleplayer");
		Singleplayer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				parentFrame.setContentPane(parentFrame.getSinglePlayerMenu());
				parentFrame.pack();
				parentFrame.getSinglePlayerMenu().setVisible(true);
				
			}
		});
		AAButton Multiplayer = new AAButton("Multiplayer");
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
	/**
	 * Adds a new button to the Main menu screen.
	 * Intended for use for adding in the resume button when "Back to main menu" is pressed in a game.
	 * @param n is a button to be added to the top of the bottom half of the main menu screen.
	 */
	public void addButton(AAButton n){
		if(this.hasResume == false){
			n.setAlignmentX(Component.CENTER_ALIGNMENT);
			n.setAlignmentY(Component.CENTER_ALIGNMENT);
			this.bottomHalf.add(Box.createRigidArea(new Dimension(10,50)),0);
			this.bottomHalf.add(n, 0);
			this.revalidate();
			this.hasResume = true;
		}
	}
}
