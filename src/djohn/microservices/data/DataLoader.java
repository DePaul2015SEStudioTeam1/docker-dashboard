package djohn.microservices.data;

import djohn.microservices.data.DataManager;
import djohn.microservices.data.DiskData;
import djohn.microservices.data.IpData;
import djohn.microservices.data.VersionData;

public class DataLoader {
	public static void load() {
		DataManager.getInstance().addData(new FreeMemoryData());
		DataManager.getInstance().addData(new VersionData());
		DataManager.getInstance().addData(new IpData());
		DataManager.getInstance().addData(new CpuData());
		DataManager.getInstance().addData(new DiskData());
	}
}
