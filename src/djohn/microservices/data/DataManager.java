package djohn.microservices.data;

import java.util.LinkedList;
import java.util.List;

public class DataManager {

	public static DataManager Instance() {
		if(instance == null)
			instance = new DataManager();
		return instance;
	}
	
	public void addData(Data _Data) {
		list.add(_Data);
	}
	
	public void dispose() {
		list.removeAll(this.list);
	}
	
	public void getAllData(StringBuilder b) {
		for(Data i : list) 
			i.getData(b);
	}
	
	public void getData(DataName _name, StringBuilder b) {
		
		for(Data i : list)
			if(i.getDataName() == _name) {
				i.getData(b);
				break;
			}
	}
	
	private DataManager() {
		list = new LinkedList<Data>();
		instance = null;
	}
	
	private List<Data> list;
	private static DataManager instance;
}
