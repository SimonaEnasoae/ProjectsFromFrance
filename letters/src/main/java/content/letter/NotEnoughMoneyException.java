package content.letter;
/**
 * Exception launched when the sender doesn't have enough money in the account
 * 
 * @author Simona Enasoae, Fernandez de la Pena
 *
 */
public class NotEnoughMoneyException extends RuntimeException{
	//CONSTRUCTOR
	/**
	 * Constructor without message
	 */
	public NotEnoughMoneyException() {
		super();
	}
	/**
	 * Constructor with message
	 * @param msg the message we want to show when the error are throw
	 */
	public NotEnoughMoneyException(String msg) {
		super(msg);
	}
}
