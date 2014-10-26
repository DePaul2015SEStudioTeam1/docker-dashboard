package djohn.microservices.data;

import java.util.LinkedList;
import java.util.List;

import djohn.microservices.data.Data;
import djohn.microservices.data.DataManager;
import djohn.microservices.data.DataName;

/**
 * 
 * @author Jet2kus84
 *
 */
public class DataManager {

	public static DataManager getInstance() {
		if(instance == null)
			instance = new DataManager();
		return instance;
	}
	
	/**
	 * 
	 * @param _Data info type to add to system log
	 */
	void addData(Data _Data) {
		list.add(_Data);
	}
	
	/**
	 * remove all data objects
	 */
	public void dispose() {
		list.removeAll(this.list);
	}
	
	/**
	 * 
	 * @param b StringBuilder object to create and write log
	 */
	public void getAllData(StringBuilder b) {
		for(Data i : list) 
			i.getData(b);
	}
	
	/**
	 * 
	 * @param _name data type to be written to log
	 * @param b StringBuilder object to create and write data to log
	 */
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
