/**
 * @author Aaron
 * 
 * Last Edit: 2-8-2018 Aaron
 *
 */
//Imports
//User interface
import java.util.Scanner;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		
		/**test = new Soldier(name.generateRandomName());
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

}
