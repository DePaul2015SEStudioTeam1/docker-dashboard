package djohn.microservices.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DiskData implements Data {

	@Override
	public void getData(StringBuilder b) {
		try {
			
			File f = new File("diskFile.txt");
			
			BufferedReader readFrom = new BufferedReader(new FileReader(f));
			
			String line = null;
			
			while((line = readFrom.readLine()) != null) {
				
				//get host name
				if(line.indexOf("bytes") != -1) {
					b.append(line.trim() + "<br>");
				}
			}
			
			//close reader
			readFrom.close();
			
			//delete file from directory
			f.deleteOnExit();
		} catch(IOException e) { e.printStackTrace(); }
	}

	@Override
	public DataName getDataName() {
		return DataName.DISK;
	}

}
