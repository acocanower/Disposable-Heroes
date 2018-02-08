/**
 * 
 */

/**
 * @author Aaron
 * 
 * Last edit: 2-7-18 by Aaron
 *
 */

//Imports
//for getting name
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
//for random generation
import java.util.concurrent.ThreadLocalRandom;
//for writing bio upon death
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class Soldier {
	//soldiers name
	String NAME;
	String RANK;
	
	
	//Constructor
	public Soldier() {
		//retrive the soldier's name
		
		try {
			this.NAME = makeName();
		} catch (IOException e) {
			this.NAME = "Unknown Soldier";
			System.out.println(e);
		}
		this.RANK = makeRank();
		
	}
	
	
	//Set the rank of this character
	private String makeRank() {
		int min = 1;
		int max = 100;
		int rankDecider = ThreadLocalRandom.current().nextInt(min, max + 1);
		String rankReturn = "Private";
		if(rankDecider <= 80)
			rankReturn= "Private";
		if(rankDecider > 80)
			rankReturn= "Private Second Class";
		if(rankDecider > 95)
			rankReturn= "Private First Class";
		if(rankDecider > 98)
			rankReturn= "Corporal";
		if(rankDecider > 99)
			rankReturn= "Sergent";
		return rankReturn;
	}
	
	
	
	private String makeName() throws IOException {
		String parsedName = "";
		// Make a URL to the web page
		URL url = new URL("https://www.fakenamegenerator.com/gen-male-us-us.php");
		
		// Get the input stream through URL Connection
		URLConnection con = url.openConnection();
		InputStream is =con.getInputStream();
		
		// Once you have the Input Stream, it's just plain old Java IO stuff.
		
		// For this case, since you are interested in getting plain-text web page
		// I'll use a reader and output the text content to System.out.
		
		// For binary content, it's better to directly read the bytes from stream and write
		// to the target file.
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		//used to stop loop when it is complete
		boolean done = false;
		
		String line = null;
		// read each line and write to System.out
		while ((line = br.readLine()) != null && !done) {
			if(line.contains("address")) {
				parsedName = br.readLine();
				if(((line = br.readLine()) != null) && line.contains("<div class=\"adr\">")){
					String[] parsingName = parsedName.split(">");
					parsingName = parsingName[1].split("<");
					parsedName = parsingName[0];
					parsedName.trim();
					done = true;
				}
			}
		}
		return parsedName;
	}
	
	public void kill() {
		int min = 0;
		int max = 4;
		int NUMBER_OF_KIDS = ThreadLocalRandom.current().nextInt(min, max + 1);
		boolean MARRIED = ((NUMBER_OF_KIDS > 0) && ThreadLocalRandom.current().nextBoolean()) || ThreadLocalRandom.current().nextBoolean();
		String deathlog = RANK+" "+NAME+" served honorably.  He was father to "+NUMBER_OF_KIDS+" children and was"+((MARRIED)?(" "):(" not "))+"married.";
		catalogDeath(deathlog);
	}
	private void catalogDeath(String deathlog) {
		System.out.println(deathlog);
	}
}