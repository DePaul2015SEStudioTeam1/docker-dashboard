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
final class CpuData implements Data {

	@Override
	public void getData(StringBuilder b) {
		
		try {
			
			File f = new File("cpuFile.txt");
			
			BufferedReader readFrom = new BufferedReader(new FileReader(f));
			
			String line = null;
			
			while((line = readFrom.readLine()) != null) {
				
				//get host name
				if((line.indexOf("CPUs") != -1) || 
					(line.indexOf("Model") != -1) || 
					(line.indexOf("Cores") != -1) ||
					(line.indexOf("Vendor") != -1) ||
					(line.indexOf("Physical Memory") != -1))
				
				{
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
		return DataName.SYSTEM;
	}
}
