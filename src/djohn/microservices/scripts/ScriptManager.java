package djohn.microservices.scripts;

import java.util.LinkedList;

/**
 * 
 * @author Jet2kus84
 *
 */
public class ScriptManager {

	/**
	 * 
	 * @param _script item to be loaded into the list
	 */
	void addScript(Scripts _script) {
		list.add(_script);
	}
	
	/**
	 * 
	 * @param type script type to retrieve
	 * @return the script requested
	 */
	public Scripts getScript(ScriptType type) {
		for(Scripts s : list)
			if(s.getScriptType() == type)
				return s;
		return null;
	}
	
	/**
	 * 
	 * @return the an instance of this class
	 */
	public static ScriptManager getInstance() {
		if(instance == null)
			instance = new ScriptManager();
		return instance;
	}
	
	/**
	 * 
	 * create all scripts loaded into the list
	 */
	public void createScripts() {
		for(Scripts s : list)
			s.createScript();
	}
	
	/**
	 * 
	 * @param str string builder object to be written to log file
	 * @param type operating system type
	 */
	public void writeToLogFile(StringBuilder str, ScriptType type) {
		for(Scripts s : list)
			if(s.getScriptType() == type)
				s.writeToLogFile(str);
	}
	
	/**
	 * 
	 * @param type script type to script in question
	 * @return whether or not this script can be executed
	 */
	public boolean canExecuteScript(ScriptType type) {
		for(Scripts s : list) 
			if(s.getScriptType() == type)  
				return s.canExcute();
		return false;
	}
	
	/**
	 * 
	 * @param type script type to be ran
	 */
	public void runScript(ScriptType type) {
		for(Scripts s : list) 
			if(s.getScriptType() == type) {
				s.runScript();
				break;
			}
	}
	
	public void openLog(ScriptType type) {
		for(Scripts s : list) 
			if(s.getScriptType() == type)
				s.openLog();
	}
	
	private ScriptManager() {
		instance = null;
		list = new LinkedList<Scripts>();
	}
	
	private static ScriptManager instance;
	private LinkedList<Scripts> list;
}
