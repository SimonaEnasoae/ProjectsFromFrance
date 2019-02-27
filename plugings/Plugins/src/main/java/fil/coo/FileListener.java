package fil.coo;

import java.util.EventListener;

/**
 * Class FileListener
 * 
 * @author Enasoae Simona, Marcel Fernandez de la Pena
 *
 */
public interface FileListener extends EventListener{
	
	//METHODS
	/**
	 * 
	 * @param fileEvent listener on filesystem changes
	 */
	void fileAdded(FileEvent fileEvent);
	/**
	 * 
	 * @param fileEvent listener on filesystem changes
	 */
	void fileRemoved(FileEvent fileEvent);
}
