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
	private String[] FIRSTNAMES;
	private String[] MID_IN;
	private String[] SURNAMES;
	private String FILE_NAME_FIRSTS = "firstName.txt";
	private String FILE_NAME_MID_INS = "midIN.txt";
	private String FILE_NAME_SURNAMES = "surname.txt";
	public Names() {
		try {
			this.FIRSTNAMES = getArrayFromFile(FILE_NAME_FIRSTS);
			this.MID_IN = getArrayFromFile(FILE_NAME_MID_INS);
			this.SURNAMES = getArrayFromFile(FILE_NAME_SURNAMES);
		}
		catch(Exception e) {
			System.out.println("ERROR:   "+e);
		}
	}
	
	//Parses the file of names into an array
	private String[] getArrayFromFile(String FILE_NAME) throws FileNotFoundException, IOException {
		File file = new File(FILE_NAME);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();

		String str = new String(data, "UTF-8");
		String strArray[] = str.replace("\n", " ").split(" ");
		return strArray;
	}
	
	//
	public String generateRandomName() {
		String name = "";
		int min = 0;
		int max = 1000;
		int FIRST_NAME_INDEX = ThreadLocalRandom.current().nextInt(min, max);
		name = FIRSTNAMES[FIRST_NAME_INDEX].replace("\n", " ").replace("\r", "");
		min = 0;
		max = 26;
		int MID_IN_INDEX = ThreadLocalRandom.current().nextInt(min, max);
		name+=" "+MID_IN[MID_IN_INDEX].replace("\n", " ").replace("\r", "")+".";
		min = 0;
		max = 1000;
		int SURNAME_INDEX = ThreadLocalRandom.current().nextInt(min, max);
		name+=" "+SURNAMES[SURNAME_INDEX].replace("\n", " ").replace("\r", "");
		return name;
	}
	
}
