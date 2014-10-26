/**
 * 
 */
package edu.depaul.studio.team1.service;

import edu.depaul.studio.team1.model.Container;

/**
 * Provides a way for log collector to interact with the operations database
 * 
 * @author ptrzyna
 */
public interface OperationService {

	/**
	 * Stores container information in the db
	 * 
	 * @param container	info about a container
	 */
	void store(Container container);
	
}
