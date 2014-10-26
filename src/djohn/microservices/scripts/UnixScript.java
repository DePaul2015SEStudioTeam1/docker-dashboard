package djohn.microservices.scripts;

import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Jet2kus84
 *
 */
class UnixScript implements Scripts {

	@Override
	public void createScript() {
		
		file = new java.io.File("systeminfo.command");
	
		PrintWriter w;
		try {
			w = new PrintWriter(file);
			
			//create batch file and retrieve system metrics using sigar.jar
			String b = "echo off\n" + 
					"mdfind -name SampleMockAgent | xargs -I {} cp -r {} ~/Desktop\n" +
					"cd ~/Desktop/SampleMockAgent\n" +
					"touch freeMemoryFile.txt\n" +
					"touch version.txt\n" +
					"touch ipFile.txt\n" +
					"touch diskFile.txt\n" +
					"touch cpuFile.txt\n" +
					"java -jar sigar-bin/sigar.jar free > freeMemoryFile.txt\n" +
					"java -jar sigar-bin/sigar.jar version > versionFile.txt\n" +
					"java -jar sigar-bin/sigar.jar netinfo > ipFile.txt\n" + 
					"java -jar sigar-bin/sigar.jar df > diskFile.txt\n" + 
					"java -jar sigar-bin/sigar.jar cpuinfo > cpuFile.txt";
			
			//write commands to batch file
			w.write(b);
			
			//ensure everything is written
			w.flush();
			
			//close file
			w.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void writeToLogFile(StringBuilder str) {
		
		logFile = new java.io.File(USER_DESKTOP + LOG_FILE);
		
		try {
			
			PrintWriter w = new PrintWriter(logFile);
			w.println(str);
			w.flush();
			w.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void runScript() {
		try {
			//run .command for Unix
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void openLog() {
		try {
			Desktop.getDesktop().open(logFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean canExcute() {
		return file.canExecute();
	}
	
	@Override
	public ScriptType getScriptType() {
		return ScriptType.UNIX;
	}

	private java.io.File file, logFile;
}
