package djohn.microservices.agent;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import djohn.microservices.agent.Agent;
import djohn.microservices.data.DataLoader;
import djohn.microservices.data.DataManager;
import djohn.microservices.scripts.ScriptLoader;
import djohn.microservices.scripts.ScriptManager;
import djohn.microservices.scripts.ScriptType;

/**
 * 
 * @author Jet2kus84
 *
 */
public class Agent {

	public static void main(String[] args) {
		new Agent().run();
	}
	
	public void run() {
	
		//retrieve current OS type
		ScriptType currentOS = null;
		
		//create file object for scripts
		ScriptManager.getInstance().createScripts();
		
		//run appropriate script
		if(ScriptManager.getInstance().canExecuteScript(ScriptType.DOS)) {
			ScriptManager.getInstance().runScript(ScriptType.DOS);
			currentOS = ScriptType.DOS;
		} 
		else if(ScriptManager.getInstance().canExecuteScript(ScriptType.UNIX)) {
			ScriptManager.getInstance().runScript(ScriptType.UNIX);
			currentOS = ScriptType.UNIX;
		}
		else {
			
			File f = new File("log.html");
			try {
				
				PrintWriter w = new PrintWriter(f);
				w.write("<html><title>404</title><body>" +
						"<h1>Can not run on this OS</h1></body></html>");
				w.flush();
				w.close();
				
			} catch (FileNotFoundException e1) { e1.printStackTrace(); }
			
			try {
				Desktop.getDesktop().open(f);
			} catch (IOException e) { System.err.print("Problem occurred when opening log file"); }
			
			//exit program if script doesn't work for OS
			System.exit(0);
		}
		
		//wait for data to be retrieved
		try {
			Thread.sleep(WAIT_TIME_IN_MILLIS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		//get data loaded into program
		DataManager.getInstance().getAllData(b);
				
		//write end of html log file
		b.append("</p></fieldset>Log details " +
				"provided by Deonte Johnson</body></html>");
		
		ScriptManager.getInstance().writeToLogFile(b, currentOS);
		ScriptManager.getInstance().openLog(currentOS);
		
	}
	
	public Agent() {
					
		//load in data objects
		DataLoader.load();
		
		//load in script objects
		ScriptLoader.load();
		
		//gather data
		b = new StringBuilder();
		
		//write initial html script
		b.append("<html><title>Log</title><body bgcolor=#F8F8F8>" +
				"<h1 align=center>System Log</h1><hr><p align=center>" +
				new java.util.Date() +
				"</p><fieldset><p>");			
	}
	
	private final int WAIT_TIME_IN_MILLIS = 5000;
	private StringBuilder b;
	
}
