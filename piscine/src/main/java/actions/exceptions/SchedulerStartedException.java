package actions.exceptions;
/**
 * Exception launch when we want to add an action in Scheduler and it is already in progress
 * 
 * @author Simona Enasoae, Fernandez de la Pena
 *
 */
public class SchedulerStartedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5301931640652817629L;
	//CONSTRUCTOR
	/**
	 * Constructor without message
	 */
	public SchedulerStartedException() {
		super();
	}
	/**
	 * Constructor with message
	 * @param msg the message we want to show when the error are throw
	 */
	public SchedulerStartedException(String msg) {
		System.out.println(msg);
	}
}
