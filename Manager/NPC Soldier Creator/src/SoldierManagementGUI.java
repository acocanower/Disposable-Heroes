import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	
	public SoldierManagementGUI(int NUMBER_OF_SOLDIERS) {
		
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
	}
	
	private void test() {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
