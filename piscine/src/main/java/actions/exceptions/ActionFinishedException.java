package actions.exceptions;
/**
 * Exception launch when we want to do a step and the action is already finished
 * 
 * @author Simona Enasoae, Fernandez de la Pena
 *
 */
public class ActionFinishedException extends RuntimeException {
	//CONSTRUCTOR
	/**
	 * Constructor without message
	 */
	public ActionFinishedException() {
		super();
	}
	/**
	 * Constructor with message
	 * @param msg the message we want to show when the error are throw
	 */
	public ActionFinishedException(String msg) {
		super(msg);
	}
}
