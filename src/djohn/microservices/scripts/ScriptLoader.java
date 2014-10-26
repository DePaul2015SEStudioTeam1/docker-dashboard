package djohn.microservices.scripts;

public class ScriptLoader {
	public static void load() {
		//initial scripts
		ScriptManager.getInstance().addScript(new DosScript());
		ScriptManager.getInstance().addScript(new UnixScript());
	}
}
