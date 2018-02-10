/**
 * @author Aaron
 * 
 * Last Edit: 2-9-2018 Aaron
 *
 */
//Imports
//GUI
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Container;

//listeners
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//command line interface and parsing
import java.util.Scanner;


public class Runner extends JFrame 
					implements ActionListener {
	
	//Interface
	private JButton BTNcreateSoldiers;
	private JTextField TXFnumberOfSoldiers;
	private JLabel LBLheader;
	private Container pane;
	
	//JFrame constants
	private String WINDOW_TITLE = "Soldier Generator";
    private final int WIDTH=400;
    private final int HEIGTH=200;
    
    //Back ground stuff
    private Names NAMES;

	/**
	 * Autogened because I have no idea what it is....
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runner run = new Runner();
		
		//saving for later use
		/**
		//Loads keyboard
		Scanner keyboard = new Scanner(System.in);
		//
		Names name = new Names();
		Soldier test = new Soldier(name.generateRandomName());
		int damage = 0;
		boolean alive = true;
		
		System.out.println("Enter damage of 99999 to exit");
		System.out.print("Please enter damage to "+test.getNameAndRank()+":: ");
		
		while(alive && (damage = keyboard.nextInt()) != 99999) {
			test.takeDamage(damage);
			int hp = test.getHP();
			System.out.println("HP: "+hp);
			if(hp <= 0) {
				alive = false;
				test.kill();
			}
			else {
				System.out.print("Please enter damage to "+test.getNameAndRank()+":: ");
			}
		}
		
		test = new Soldier(name.generateRandomName());
		test.kill();
		test = new Soldier(name.generateRandomName());
		test.kill();
		test = new Soldier(name.generateRandomName());
		test.kill();
		test = new Soldier(name.generateRandomName());
		test.kill();
		test = new Soldier(name.generateRandomName());
		test.kill();
		test = new Soldier(name.generateRandomName());
		test.kill();
		test = new Soldier(name.generateRandomName());
		test.kill();
		test = new Soldier(name.generateRandomName());*/
	}
	
	public Runner() {

		//load name generator once to less processing
		NAMES = new Names();
		
		//Initialing fields and buttons and stuff
		BTNcreateSoldiers = new JButton("Generate Soldiers");
		TXFnumberOfSoldiers = new JTextField("1");
		LBLheader = new JLabel("Enter Number of Soldiers to Generate",0);
		
		//making Jframe
		setTitle("Soldier Generator");
		setSize(WIDTH,HEIGTH);
		setResizable(false);
		
		//sets layout
		pane=getContentPane();
		pane.setLayout(null);
		
		//sets size and location for the Label
		LBLheader.setSize(WIDTH,30);
		LBLheader.setLocation(0, 0);
		
		// sets size and location for the number of soldiers field
		TXFnumberOfSoldiers.setSize(WIDTH/2,30);
		TXFnumberOfSoldiers.setLocation(WIDTH/4,HEIGTH/4);

		// sets size and location for the go button
		BTNcreateSoldiers.setSize(WIDTH/2,30);//sets size for buttons
		BTNcreateSoldiers.setLocation(WIDTH/4,HEIGTH/2);//bee do bee doo bee bee doo smooth jazz is the best, see above for comment but for button
		
		//add it all to the Jframe
		pane.add(LBLheader);
		pane.add(TXFnumberOfSoldiers);
		pane.add(BTNcreateSoldiers);
		
		//makes it so clicking the button triggers something to happen
		BTNcreateSoldiers.addActionListener(this);
		
		//makes it so you can see the window
		setVisible(true);
	
		//Not _really_ needed from my understanding but a good practice
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//only action that can be performed is is clicking make soldiers button
		
		Scanner getNum = new Scanner(TXFnumberOfSoldiers.getText());
		
		//if something is entered
		if(getNum.hasNext()) {
			//then try to parse it as an int
			try {
				//parsing
				int num = getNum.nextInt();
				try {
					//output as placeholder to make a soldier management window
					SoldierManagementGUI GUI = new SoldierManagementGUI(num, NAMES);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
			//if it is not an Integer, than throw error message
			catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Please enter a valid Integer",
					    "Parsing Error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//if nothing is entered, throw an error message
		else {
			JOptionPane.showMessageDialog(this, "Please enter a valid Integer",
				    "Parsing Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}

}
