/**
 * 
 */

/**
 * @author Aaron
 * 
 * Last edit: 2-8-18 by Aaron
 *
 */

//Imports
//for getting name
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
//for random generation
import java.util.concurrent.ThreadLocalRandom;
//for writing bio upon death
import java.io.*;
public class Soldier {
	//soldiers name
	private String NAME;
	private String RANK;
	private int HP = 50;
	//default AC of 20;
	private int AC = 20;
	public static String newline = System.getProperty("line.separator");
	
	//Constructor
	public Soldier(String NAME) {
		//retrive the soldier's name
		
		this.NAME = NAME;
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
		if(rankDecider > 80) {
			rankReturn= "Private Second Class";
			AC+=5;
		}
		if(rankDecider > 95) {
			rankReturn= "Private First Class";
			HP+=5;
			AC+=5;
		}
		if(rankDecider > 98) {
			rankReturn= "Corporal";
			HP+=5;
			AC+=5;
		}
		if(rankDecider > 99) {
			rankReturn= "Sergent";
			HP+=5;
			AC+=5;
		}
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
	}		String line = null;

	
	//gets
	
	//get name and rank
	public String getNameAndRank() {
		return (RANK+" "+NAME);
	}
	
	//get HP
	public int getHP() {
		return HP;
	}
	//get AC
	public int getAC() {
		return AC;
	}
	
	
	//actions
	
	//Take damage
	public int takeDamage(int DAMAGE_DEALT) {
		int damageTaken = 0;
		//removes damage absorbed by Armor Class
		damageTaken = DAMAGE_DEALT - AC;
		//checks if the AC absorbed all damage
		if(damageTaken > 0) {
			//if more damage than armmor class that damage hits HP
			HP -= damageTaken;
		}
		//return HP
		return HP;
	}
	
	//kill
	public void kill() {
		int min = 0;
		int max = 4;
		int NUMBER_OF_KIDS = ThreadLocalRandom.current().nextInt(min, max + 1);
		boolean MARRIED = ((NUMBER_OF_KIDS > 0) && ThreadLocalRandom.current().nextBoolean()) || ThreadLocalRandom.current().nextBoolean();
		String deathlog = getNameAndRank()+" served honorably.  He was father to "+NUMBER_OF_KIDS+" children and was"+((MARRIED)?(" "):(" not "))+"married.";
		System.out.println(deathlog);
		catalogDeath(deathlog);
	}
	
	//add to catalog of death
	private void catalogDeath(String deathlog) {
		String fileLoc = "catalogOfDeath.txt";
        try {
        	//loads file into RAM
        	File catalogOfDeath = new File(fileLoc);
        	
        	//reads whole file, converts to a byte array, then makes it into a String
        	String previousDeath = new String(Files.readAllBytes(Paths.get(fileLoc)), StandardCharsets.US_ASCII);
        	
        	
    		//Loads the file into a FileWriter
    		FileWriter bw = new FileWriter(catalogOfDeath);
    		//overrides the current Catalog Of Death file with it's previous content +new content
            bw.write(previousDeath+newline+deathlog);
            //closes the writer
            bw.close();
        }
        catch (Exception e) {
            System.out.println("ERROR: "+e);
        }
    }
}