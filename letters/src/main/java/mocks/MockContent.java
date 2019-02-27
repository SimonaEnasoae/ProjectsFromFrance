package mocks;

import content.Content;

/**
 * Class MockContent 
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class MockContent implements Content<String>{
	
	//ATTRIBUTES
	protected String message; 
	
	//CONSTRUCTORS
	/**
	 * Constructor
	 * 
	 * @param message    the message
	 */
	public MockContent(String message) {
		this.message = message;
	}
	
	//METHODS
	/**
	 * @return the message
	 */
	public String getContent() {
		return message;
	}

	@Override
	public String toString() {
		return "Text [message=" + message + "]";
	}
	
}
