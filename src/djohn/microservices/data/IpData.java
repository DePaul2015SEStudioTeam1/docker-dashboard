package djohn.microservices.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import djohn.microservices.data.Data;
import djohn.microservices.data.DataName;

/**
 * 
 * @author Jet2kus84
 *
 */
final class IpData implements Data {

	@Override
	public void getData(StringBuilder b) {
		
		try {
			
			File f = new File("ipFile.txt");
			
			BufferedReader readFrom = new BufferedReader(new FileReader(f));
			
			//find a position to start and find the ip data
			String line = null;
			
			while((line = readFrom.readLine()) != null) {
		
				//get address info
				if((line.indexOf("ip address") != -1) || 
						(line.indexOf("mac address") != -1) ||
						(line.indexOf("host name") != -1)) {
					b.append(line.trim() + "<br>");
				}
			}
			
			readFrom.close();
			
			f.deleteOnExit();
		} catch(IOException e) { System.err.print("Issue opening file"); }
		
	}
	
	@Override
	public DataName getDataName() {
		return DataName.IP;
	}
}