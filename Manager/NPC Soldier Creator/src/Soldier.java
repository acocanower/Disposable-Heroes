/**
 * 
 */

/**
 * @author Aaron
 * 
 * Last edit: 2-7-18 by Aaron
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class Soldier {
	//soldiers name
	String name;
	String rank;
	
	public Soldier() {
		//retrive the soldier's name
		
		try {
			this.name = makeName();
		} catch (IOException e) {
			this.name = "Unknown Soldier";
			System.out.println(e);
		}
		switch((int)(Math.ceil(Math.random()*100))){
			case 1-80:
				this.rank= "Private";
				break;
			case 80-94:
				this.rank = "Private Second Class";
				break;
			case 95-97:
				this.rank = "Private First Class";
				break;
			case 98-99:
				this.rank = "Corporal";
				break;
			case 100:
				this.rank = "Sergent";
				break;
			default:
				this.rank = "Private";
		}
		System.out.println("His name is: "+rank+" "+name);
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
}