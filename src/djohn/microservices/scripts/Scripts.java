package djohn.microservices.scripts;

/**
 * 
 * @author Jet2kus84
 *
 */
interface Scripts {

	public void createScript();
	public void runScript();
	public void writeToLogFile(StringBuilder str);
	public void openLog();
	public boolean canExcute();
	public ScriptType getScriptType();
	
	final String USER_DESKTOP = "~/Desktop/SampleMockAgent/";
	final String LOG_FILE = "log.html";
	
}
