package djohn.microservices.agent;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import djohn.microservices.data.DataManager;
import djohn.microservices.data.DataName;
import djohn.microservices.data.DiskData;
import djohn.microservices.data.IpData;
import djohn.microservices.data.SystemData;
import djohn.microservices.data.VersionData;
import djohn.microservices.data.VolumeData;

public class Agent {

	public static void main(String[] args) {
		new Agent().run();
	}
	
	public void run() {
	
		//create a batch file dynamically
		this.createBatchFile();
		
		try {
			
			//run batch file
			Desktop.getDesktop().open(batchFile);
			
			//wait for data to be loaded
			try {
				Thread.sleep(9000);
			} catch (InterruptedException e) { e.printStackTrace(); }
		
			//remove batch file from directory
			batchFile.deleteOnExit();
			
		} catch(IOException e) { 
			System.err.print("Issue occurred when attempting to open file");
		}

		DataManager.Instance().getData(DataName.VOLUME,b);
		DataManager.Instance().getData(DataName.VERSION,b);
		DataManager.Instance().getData(DataName.IP,b);
		DataManager.Instance().getData(DataName.SYSTEM,b);
		DataManager.Instance().getData(DataName.DISK,b);
		
		
		//write to log file
		writeTo.print(b + "</p></fieldset>Log details " +
				"provided by Deonte Johnson</body></html>");
		
		//close log file
		writeTo.close();
		
		//open the html log file
		try {
			Desktop.getDesktop().open(log);
		} catch (IOException e) { System.err.print("Problem occurred when opening log file"); }
		
	}
	
	public Agent() {
		
		DataManager.Instance().addData(new VolumeData());
		DataManager.Instance().addData(new VersionData());
		DataManager.Instance().addData(new IpData());
		DataManager.Instance().addData(new SystemData());
		DataManager.Instance().addData(new DiskData());
		
		batchFile = new File("systeminfo.bat");
		log = new File("log.html");
		
		b = new StringBuilder();
		
		//write initial html script
		b.append("<html><title>Log</title><body bgcolor=#F8F8F8>" +
				"<h1 align=center>System Log</h1><hr><p align=center>" +
				new java.util.Date() +
				"</p><fieldset><p>");
		
		try {
			writeTo = new PrintWriter(log);
			w = new PrintWriter(batchFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
	}
	private void createBatchFile() {
		
		//commands for batch file
		String b = "echo off\n" + "fsutil volume diskfree C:>diskFile.txt\n" + "vol>file.txt\n" + "ver>file2.txt\n" +
		 "ipconfig>ipFile.txt\n" + "systeminfo.exe | find /V /I " + "\"hotfix\"" +
				" | find /V " + "\"KB\"" + " > systemFile.txt";
		
		//write commands to batch file
		w.write(b);
		
		//ensure everything is written
		w.flush();
		
		//close file
		w.close();
	}

	private PrintWriter writeTo;
	private PrintWriter w;
	private File batchFile;
	private File log;
	private StringBuilder b;
}
