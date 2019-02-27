package fil.coo;

import java.io.File;
import java.util.EventObject;

/**
 * Class FileEvent
 * 
 * @author Enasoae Simona, Marcel Fernandez de la Pena
 *
 */
public class FileEvent extends EventObject {
	
	//METHODS	
	/**
	 * 
	 * @param file object file
	 */
	public FileEvent(Object file) {
		super(file);
	}


	
	
}
