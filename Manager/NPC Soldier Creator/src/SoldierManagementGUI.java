import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.Attributes.Name;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Aaron
 * 
 * Last Edit: 2-9-2018 Aaron
 *
 */
public class SoldierManagementGUI extends JFrame 
									implements ActionListener {
	
	private Container pane;
	private int rows;
	private int cols;
	private Names NAMES;
	
	
	public SoldierManagementGUI(int NUMBER_OF_SOLDIERS, Names NAMES) {
		
		//gets the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		
		
		//making Jframe
		setTitle("Soldier Management");
		setSize(width/2, height/2);
		setLocation(width/4, height/4);
		setResizable(true);
		
		
		
		//store NAMES instance so save processing 
		this.NAMES = NAMES;
		
		//rename so easier to type
		int NUM = NUMBER_OF_SOLDIERS;
		
		//if 8 or fewer soldiers 2 cols, and as many rows as it needs
		if(NUM <= 8) {
			cols = 2;
			
			//0 means it will expand to needed amount
			rows = 0;
		}
		
		//if 12 for fewer 3 cols
		else if(NUM <= 12) {
			cols = 3;
			rows = 0;
		}
		//16 or fewer 4 cols
		else if(NUM <= 16) {
			cols = 4;
			rows = 0;
		}
		//else 6 cols
		else {
			cols = 6;
			rows = 0;
		}
		
		
		
		// sets the pane to a grid layout
		pane=getContentPane();
		pane.setLayout(new GridLayout(rows,cols));
		
		addSoliders(NUM);
		
		/**
		for(int i = 0; i < NUM; i++) {
			pane.add(new JButton(NAMES.generateRandomName()));
		}*/
		
		//makes it so you can see the window
		setVisible(true);
		
		//Not _really_ needed from my understanding but a good practice
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	//adds NUM soldier to the pane
	private void addSoliders(int NUM) {
		for(int i = 0; i < NUM; i++) {
			SoldierComponent toAdd = new SoldierComponent(NAMES.generateRandomName());
			pane = toAdd.makeGUI(pane);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		revalidate();
	}

}
