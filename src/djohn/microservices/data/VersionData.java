package djohn.microservices.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VersionData implements Data {

	@Override
	public void getData(StringBuilder b) {
		try {
			
			//open file
			File f = new File("file2.txt");
		
			//create a file reader
			BufferedReader readFrom = new BufferedReader(new FileReader(f));
		
			//read the first line from the file
			String line = readFrom.readLine();
		
			//if the line is blank read the next line
			if(line.equals("")) line = readFrom.readLine();
		
			b.append(line + "<br>");
		
			//close reader
			readFrom.close();
			
			//delete dynamic file
			f.deleteOnExit();
		
			} catch (IOException e) { System.err.print("Issue opening file"); }
	}
	
	@Override
	public DataName getDataName() {
		return DataName.VERSION;
	}
}
