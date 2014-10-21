package maestro;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaestroController {
	
	private static final String template = "UID: %s/n" +
		"PID: %s/n" +
		"PPID: %s/n" +
		"CSTIME: %s/n" +
		"TTY: %s/n" +
		"TIME: %s/n" +
		"CMD: %s/n" +
		"Anything else that came through: %s";
		
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/maestro")
	public Maestro maestro(@RequestParam(value="uid", required=false, defaultValue="did not receive") String uid,
		@RequestParam(value="pid", required=false, defaultValue="did not receive") String pid,
		@RequestParam(value="ppid", required=false, defaultValue="did not receive") String ppid,
		@RequestParam(value="csTime", required=false, defaultValue="did not receive") String csTime,
		@RequestParam(value="tty", required=false, defaultValue="did not receive") String tty,
		@RequestParam(value="time", required=false, defaultValue="did not receive") String time,
		@RequestParam(value="cmd", required=false, defaultValue="did not receive") String cmd,
		@RequestParam(value="theEnd", required=false, defaultValue="no additional values came through") String theEnd) {
			return new Maestro(counter.incrementAndGet(), 
			String.format(uid), String.format(pid), String.format(ppid), String.format(csTime),
			String.format(tty), String.format(time), String.format(cmd), String.format(theEnd));
			//String.format(template, uid, pid, ppid, csTime, tty, time, cmd, theEnd));
		}
}