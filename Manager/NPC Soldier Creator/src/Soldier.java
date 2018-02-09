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
	
	//soldiers rank
	private String RANK;
	
	//default HP of 50
	private int HP = 50;
	
	//default AC of 20;
	private int AC = 20;
	
	//used to make create a newline char in Catalog of Dead
	public static String newline = System.getProperty("line.separator");
	
	//Constructor
	public Soldier(String NAME) {
		
		//Retrieve the soldier's name
		this.NAME = NAME;
		
		//Retrieve the soldier's rank
		this.RANK = makeRank();
		
	}
	
	
	//Set the rank of this character
	private String makeRank() {
		//1-100 (adds one in generation [see below]) to make % calculation easier
		int min = 0;
		int max = 100;
		
		//generates a int between 1-100, used to decide rank
		int rankDecider = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		//return String
		String rankReturn = "";
		
		//80% chance of being a Private
		//No perks
		if(rankDecider <= 80)
			rankReturn= "Private";
		
		//15% chance of being a Private Second Class
		//PSC +5 Armor perk
		if(rankDecider > 80) {
			rankReturn= "Private Second Class";
			AC+=5;
		}
		
		//3% chance of being Private First Class
		//PSC perk+ 5 HP and 5 AC
		if(rankDecider > 95) {
			rankReturn= "Private First Class";
			HP+=5;
			AC+=5;
		}
		
		//1% chance of Corporal
		//PSC+PFC+ 5 HP and 5 AC
		if(rankDecider > 98) {
			rankReturn= "Corporal";
			HP+=5;
			AC+=5;
		}
		
		//1% chance of Sergeant 
		//All previous perks + 5 hp and 5 AC
		if(rankDecider > 99) {
			rankReturn= "Sergeant";
			HP+=5;
			AC+=5;
		}
		
		//ship it
		return rankReturn;
	}

	
	//Get Methods **************************************************************
	
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
	
	
	//action methods ***********************************************************
	
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
		//anywhere between 0 and 4 kids
		int min = 0;
		int max = 4;
		int NUMBER_OF_KIDS = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		//50% chance of married if 0 kids, 75% if kids
		boolean MARRIED = (NUMBER_OF_KIDS > 0) && ThreadLocalRandom.current().nextBoolean() || ThreadLocalRandom.current().nextBoolean();
		String deathlog = getNameAndRank()+" served honorably.  He was father to "+NUMBER_OF_KIDS+" children and was"+((MARRIED)?(" "):(" not "))+"married.";
		
		//To be a pop-up window someday with a random picture of a soldier
		System.out.println(deathlog);
		
		//log it
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
            bw.write(previousDeath+newline+deathlog+newline);
            //closes the writer
            bw.close();
        }
        catch (Exception e) {
        	//in case of failure print to Console
            System.out.println("ERROR: "+e);
        }
    }
}