package djohn.microservices.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IpData implements Data {

	@Override
	public void getData(StringBuilder b) {
		
		try {
			
			File f = new File("ipFile.txt");
			
			BufferedReader readFrom = new BufferedReader(new FileReader(f));
			
			//find a position to start and find the ip data
			String line = null;
			
			while((line = readFrom.readLine()) != null) {
				
				//get ipv4 address
				if(line.indexOf("IPv4") != -1) {
					b.append(line.trim() + "<br>");
				}
				
				//get ipv6 address
				if(line.indexOf("IPv6") != -1) {
					b.append(line.substring(line.indexOf("IPv6")).trim() + "<br>");
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
