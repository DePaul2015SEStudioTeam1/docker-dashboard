package djohn.microservices.data;

import djohn.microservices.data.DataName;

/**
 * 
 * @author Jet2kus84
 *
 */
public interface Data {
	public void getData(StringBuilder b);
	public DataName getDataName();
}
