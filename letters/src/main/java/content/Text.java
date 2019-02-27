package content;
/**
 * Class Text 
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class Text implements Content<String>{
	
	//ATTRIBUTES
	/**
	 * the message to be delivered
	 */
	protected String message; 
	
	//CONSTRUCTORS
	/**
	 * Constructor
	 * 
	 * @param message    the message
	 */
	public Text(String message) {
		this.message = message;
	}
	
	//METHODS
	/**
	 * return the content
	 * @return message the text contained in the letter
	 */
	public String getContent() {
		return message;
	}

	/**
	 * retutn the representation of the text
	 * @return a string with the current message
	 */
	@Override
	public String toString() {
		return this.getContent();
	}
	
}
