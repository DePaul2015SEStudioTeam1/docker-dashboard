package djohn.microservices.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import djohn.microservices.data.Data;
import djohn.microservices.data.DataName;

final class FreeMemoryData implements Data {

	@Override
	public void getData(StringBuilder b) {
		
		try {
			
			File file = new File("FreeMemoryFile.txt");
			
			//create a file reader
			BufferedReader readFrom = new BufferedReader(new FileReader(file));
			
			String line = null;
			java.util.StringTokenizer token;
			
			while((line = readFrom.readLine()) != null) {
		
				//Windows OS
				if(line.indexOf("Mem:") != -1) {
					token = new java.util.StringTokenizer(line.trim().substring(WINDOWS_OS_START));
					buildString(token, b);
				}
				
				//OS X
				if(line.indexOf("disk") != -1) {
					token = new java.util.StringTokenizer(line.trim().substring(OS_X_START));
					buildString(token, b);
				}
			}
					
			readFrom.close();
			
			file.deleteOnExit();
		
		} catch (IOException e) { System.err.print("Issue opening file"); }
	}

	private void buildString(java.util.StringTokenizer token, StringBuilder b) {
		b.append("Total Memory: " + token.nextToken() + "<br>");
		b.append("Used Memory: " + token.nextToken() + "<br>");
		b.append("Free Memory: " + token.nextToken() + "<br>");
	}
	
	@Override
	public DataName getDataName() {
		return DataName.VOLUME;
	}

	private final int WINDOWS_OS_START = 8;
	private final int OS_X_START = 13;
	
}
