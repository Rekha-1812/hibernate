import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

	public void mainInvocation(Logger logger) {
		FileHandler fh;
		
		try {
		
		fh = new FileHandler("C:\\Users\\665952\\Desktop\\xmlupdate.txt",true);
		logger.addHandler(fh);
		logger.setLevel(Level.ALL);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
	
		} catch (SecurityException | IOException e) {
		e.printStackTrace();
	} 
		}
		public  void tagUpdation(Logger logger,String oldno,String newno) {
			
			logger.info(oldno+" is replaced by "+newno);
			
			}
		public void countUpdation(Logger logger,String s,int count) {
			logger.info("Total number of "+s+" tags updated: "+count);
			}
		public void tagHighlight(Logger logger,String str) {
			
			logger.info(str+" tags are highlighted");
		}
		
}