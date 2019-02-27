package filters;

import java.io.File;

import java.io.FilenameFilter;
/**
 * Class FileStartsWithCFilter
 * 
 * @author Enasoae Simona, Marcel Fernandez de la Pena
 *
 */
public class FileStartsWithCFilter  implements FilenameFilter {
	
	//ATTRIBUTES
	/**
	 * String with C prefix
	 */
	private static final String PREFFIX = "C";

	//METHODS
	/**
	 * method which defines the filter's condition
	 * 
	 * @return true if parameter name starts with specified prefix, false otherwise 
	 */
	public boolean accept(File dir, String name) {
		return name.startsWith(PREFFIX);
	}

}
