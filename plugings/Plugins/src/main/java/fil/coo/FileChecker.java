package fil.coo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Timer;

/**
 * Class FileChecker
 * 
 * @author Enasoae Simona, Marcel Fernandez de la Pena
 *
 */
public class FileChecker implements ActionListener {
	
	//ATTRIBUTES
	/**
	 * the directory to be checked
	 */
	protected File directory;
	/**
	 * list with fileListeners
	 */
	protected List<FileListener> fileListeners;
	/**
	 * list with strings of file names
	 */
	protected List<String> files;
	/**
	 * file filter
	 */
	protected FilenameFilter fileFilter;
	/**
	 * the delay for the timer
	 */
	protected int delay;
	/**
	 * the timer
	 */
	protected Timer timer;
	
	//CONSTRUCTOR
	/**
	 * 
	 * @param directory from which the files to be analyzed will be taken
	 * @param fileFilter is the filter that will be applied to the file
	 * @param delay the timer delayer 
	 */
	public FileChecker(File directory, FilenameFilter fileFilter,int delay) {
		fileListeners= new ArrayList<FileListener>();
		files= new ArrayList<String>();
		this.directory = directory;
		this.fileFilter = fileFilter;
    	this.delay = delay;
		timer = new Timer (delay,this);
	}
	
	//METHODS
	/**
	 * adds a fileListener to the list of file listeners
	 * 
	 * @param fileListener is the Event related with some file
	 */
	public void addListener(FileListener fileListener){
		fileListeners.add(fileListener);
	}
	
	/**
	 * removes a fileListener from the list of file listeners
	 * 
	 * @param fileListener is the Event related with some file
	 */
	public void removeListener(FileListener fileListener){
		fileListeners.remove(fileListener);
	}
	
	/**
	 * notifies every fileListener about the new event that has just been added
	 * 
	 * @param file could be any file contained in specified directory  
	 */
	public void fireFileAdded(File file){
		FileEvent fileEvent= new FileEvent(file);
		for(FileListener fileListener : fileListeners){
			fileListener.fileAdded(fileEvent);
		}
	}
	
	/**
	 *  notifies every fileListener about the new event that has just been added
	 * 
	 * @param file could be any file contained in specified directory  
	 */
	public void fireFileRemoved(File file) {
		FileEvent fileEvent = new FileEvent(file);
		for(FileListener fileListener : fileListeners){
			fileListener.fileRemoved(fileEvent);
		}
	}
	/**
	 * gets the files who meets the filter and updates the list of files
	 * 
	 * Invoked when an action occurs, adds or removes a detected file.
	 */
	public void actionPerformed(ActionEvent e){
    	String listFiles[] = this.directory.list(this.fileFilter);
		List<String> updatedFiles =new ArrayList<String>(Arrays.asList(listFiles));
		for(String file: updatedFiles){
			if(!this.files.contains(file)){
				this.files.add(file);
				File f = new File(file);
				fireFileAdded(f);
			}
		}
		List<String> aux = new ArrayList<String>(this.files);
		for(String file: aux) {
			if(!updatedFiles.contains(file)) {
				this.files.remove(file);
				File f = new File(file);
				fireFileRemoved(f);
			}
		}
	}
	
	/**
	 * Initializes timer
	 */
	public void start() {
		timer.start();
	}
	
	/**
	 * Stops timer
	 */
	public void stop() {
		timer.stop();
	}
}
