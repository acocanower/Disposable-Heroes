/**
 * 
 */

/**
 * @author Aaron
 * 
 * Last Edit: 2-8-2018 Aaron
 *
 */

//IMPORTS
//for parsing
import java.io.*;
//for random generation
import java.util.concurrent.ThreadLocalRandom;

public class Names {
	//String Arrays for random name grabbing
	private String[] FIRSTNAMES;
	private String[] MID_IN;
	private String[] SURNAMES;
	//File names of names
	private String FILE_NAME_FIRSTS = "firstName.txt";
	private String FILE_NAME_MID_INS = "midIN.txt";
	private String FILE_NAME_SURNAMES = "surname.txt";
	
	//Constructor
	public Names() {
		//try to pull info from files
		try {
			this.FIRSTNAMES = getArrayFromFile(FILE_NAME_FIRSTS);
			this.MID_IN = getArrayFromFile(FILE_NAME_MID_INS);
			this.SURNAMES = getArrayFromFile(FILE_NAME_SURNAMES);
		}
		//In event of failure, display Error message and Close to prevent further errors
		catch(Exception e) {
			System.out.println("ERROR:   "+e);
			System.exit(0);
		}
	}
	
	//Parses the file of names into an array
	private String[] getArrayFromFile(String FILE_NAME) throws FileNotFoundException, IOException {
		
		//load file into RAM
		File file = new File(FILE_NAME);
		
		//turn file into an Input
		FileInputStream fis = new FileInputStream(file);

		//create a byte array the size of the file	
		byte[] data = new byte[(int) file.length()];
		
		//Load in the byte array from the file
		fis.read(data);
		//close the input
		fis.close();

		
		//change the byte array into one long String
		String str = new String(data, "UTF-8");
		
		//Split the String at each new line
		String strArray[] = str.replace("\n", " ").split(" ");
		
		//return the Array of Strings
		return strArray;
	}
	
	//used to generate the name
	public String generateRandomName() {
		
		//initialize the String for the name
		String name = "";
		
		
		//There are 1000 first names
		int min = 0;
		int max = 1000;
		
		//generate a random number from 0-999
		int FIRST_NAME_INDEX = ThreadLocalRandom.current().nextInt(min, max);
		
		//parses so that new lines are removed, and also new lines are removed
		name = FIRSTNAMES[FIRST_NAME_INDEX].replace("\n", "").replace("\r", "");
		
		
		//there are 26 letters for middle name
		min = 0;
		max = 26;
		
		//generates a number from 0-25
		int MID_IN_INDEX = ThreadLocalRandom.current().nextInt(min, max);
		
		//parses so that new lines are removed, and also new lines are removed Adds an '.'
		name+=" "+MID_IN[MID_IN_INDEX].replace("\n", "").replace("\r", "")+".";
		
		
		//There are 1000 Surnames
		min = 0;
		max = 1000;
		
		//generate a random number from 0-999
		int SURNAME_INDEX = ThreadLocalRandom.current().nextInt(min, max);
		
		//parses so that new lines are removed, and also new lines are removed
		name+=" "+SURNAMES[SURNAME_INDEX].replace("\n", "").replace("\r", "");
		
		
		//return the whole name
		return name;
	}
	
}
