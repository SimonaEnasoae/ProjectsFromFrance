package filters;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Class FileTypeClassFilter
 * 
 * @author Enasoae Simona, Marcel Fernandez de la Pena
 *
 */
public class FileTypeClassFilter implements FilenameFilter{
	//ATTRIBUTE
	/**
	 * String with suffix to verify .class files
	 */
	private static final String SUFFIX = ".class";

	//METHODS
	/**
	 * method which defines the filter's condition
	 * 
	 * @return true if the name parameter ends with specified suffix, false otherwise
	 */
	public boolean accept(File dir, String name) {
		return name.endsWith(SUFFIX);
	}

}
