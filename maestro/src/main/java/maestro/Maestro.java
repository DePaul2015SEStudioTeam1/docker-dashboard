package maestro;

public class Maestro {

	private final long id;
	private final String uid;
	private final String pid;
	private final String ppid;
	private final String csTime;
	private final String tty;
	private final String time;
	private final String cmd;
	private final String theEnd;
	
	public Maestro(long id, 
		String uid,
		String pid,
		String ppid,
		String csTime,
		String tty,
		String time,
		String cmd,
		String theEnd){
			this.id = id;
			this.uid = uid;
			this.pid = pid;
			this.ppid = ppid;
			this.csTime = csTime;
			this.tty = tty;
			this.time = time;
			this.cmd = cmd;
			this.theEnd = theEnd;
		}
		
		public long getId() {
			return id;
		}
		
		public String getUid(){
			return uid;
		}
		
		public String getPid(){
			return pid;
		}
		
		public String getPpid(){
			return ppid;
		}
		
		public String getCsTime(){
			return csTime;
		}
		
		public String getTty(){
			return tty;
		}
		
		public String getTime(){
			return time;
		}
		
		public String getCmd(){
			return cmd;
		}
		
		public String getTheEnd(){
			return theEnd;
		}
}