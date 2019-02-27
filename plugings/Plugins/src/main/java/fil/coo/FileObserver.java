package fil.coo;

import java.io.File;

/**
 * Class FileObserver
 * 
 * @author Enasoae Simona, Marcel Fernandez de la Pena
 *
 */
public class FileObserver implements FileListener {

	//METHODS
	/**
	 * Method detects if new file has been added
	 * 
	 * @param fileEvent listener on filesystem changes
	 */
	public void fileAdded(FileEvent fileEvent) {
		File file = (File) fileEvent.getSource();
		System.out.println(file.getName()+" détecté");
	}
	
	/**
	 * Method detects if new file has been removed
	 * 
	 * @param fileEvent listener on filesystem changes
	 */
	public void fileRemoved(FileEvent fileEvent) {
		File file = (File) fileEvent.getSource();
		System.out.println(file.getName()+" suprimé");
	}

}
