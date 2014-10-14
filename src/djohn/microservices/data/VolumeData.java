package djohn.microservices.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VolumeData implements Data {

	@Override
	public void getData(StringBuilder b) {
		
		try {
			
			File file = new File("file.txt");
			
			//create a file reader
			BufferedReader readFrom = new BufferedReader(new FileReader(file));
			
			//read the first line from the file
			String line = readFrom.readLine();
			
			//get the first line of info and parse out the drive
			b.append(line + "<br>");
			
			//read the second line
			line = readFrom.readLine();
			
			//get the second line of info and parse out the serial #
			b.append(line + "<br>");
					
			readFrom.close();
			
			file.deleteOnExit();
		
		} catch (IOException e) { System.err.print("Issue opening file"); }
	}

	@Override
	public DataName getDataName() {
		return DataName.VOLUME;
	}

}
