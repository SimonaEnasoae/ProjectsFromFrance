package plugin;

/**
 * Plugin's Interface
 * 
 * @author Enasoae Simona, Marcel Fernandez de la Pena
 *
 */
public interface Plugin {
	
	//METHODS
	/**
	 * Transforms some String type text 
	 * 
	 * @param s is the String that will be transformed
	 * @return the transformed String
	 */
	public String transform(String s);
	/**
	 * Gets the label of the plugin
	 * 
	 * @return String label of plugin
	 */
	public String getLabel();
	/**
	 * 
	 * @return String a help message
	 */
	public String helpMessage();
	
}
