import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SettingTextpane {

	@SuppressWarnings("resource")
	public String setTextPane(String filepath) {
		BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(filepath));
				StringBuilder sb = new StringBuilder();
	    	    String line = br.readLine();
	    	    
	    	    while (line != null) {
	    	        sb.append(line);
	    	        sb.append("\n");
	    	        line = br.readLine();
	    	    }
	    	    String sbnew= sb.toString();
	    	    return sbnew;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
 	    
	}
}
