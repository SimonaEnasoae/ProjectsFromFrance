package content.letter;

import content.Content;
import city.*;

/**
 * Class Letter
 * 
 * @author Simona Enasaoe, Marcel Fernandez de la Pena
 *
 */
public abstract class Letter <C extends Content> implements Content{
	
	//ATTRIBUTES
	/**
	 * string with courrier description
	 */
	private static final String COURRIER_DEFAULT_NAME = "courrier";
	/**
	 * counter to differentiate letters
	 */
	private static int cpt =  0;
	/**
	 * the content of the letter
	 */
	protected C content;
	/**
	 * inhabitant who sends the letter
	 */
	protected Inhabitant sender;
	/**
	 * inhabitant who receives the letter
	 */
	protected Inhabitant receiver;
	/**
	 * string with the type of letter
	 */
	protected String name;

	//CONSTRUCTOR
	/**
	 * 
	 * @param content 		the content of the letter
	 * @param sender 	the inhabitant who sends the letter
	 * @param receiver 	the inhabitant to whom the sender sends the letter
	 */
	public Letter(C content, Inhabitant sender, Inhabitant receiver) {
		super();
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
		
		this.name = COURRIER_DEFAULT_NAME+ Integer.toString((Letter.cpt ++));
		
	}
	
	//CONSTRUCTOR
	/**
	 * Constructor
	 */
	public Letter() {
		super();
	}

	//GETTERS AND SETTERS


	/**
	 * get the content of the letter
	 * 
	 * @return content
	 */
	public C getContent() {
		return content;
	}

	/**
	 * get the inhabitant sending letter
	 * 
	 * @return the inhabitant who sends the letter
	 */
	public Inhabitant getSender() {
		return sender;
	}

	/**
	 * set the inhabitant sending letter
	 * 
	 * @param sender the inhabitant to be set
	 */
	public void setSender(Inhabitant sender) {
		this.sender = sender;
	}

	/**
	 * get the inhabitant receiving the letter
	 * 
	 * @return the inhabitant who will receive the letter
	 */
	public Inhabitant getReceiver() {
		return receiver;
	}

	/**
	 * set the inhabitant receiving the letter
	 * 
	 * @param receiver the inhabitant receiving the letter to be set
	 */
	public void setReceiver(Inhabitant receiver) {
		this.receiver = receiver;
	}
	
	//ABSTRACT METHODS
	/**
	 * get the cost of the letter
	 * 
	 * @return the cost of the letter
	 */
	public abstract float getCost();
	
	/**
	 * do the specific action for the letter
	 */
	public abstract void action();
	
	/**
	 * get description of type of letter
	 * 
	 * @return the name of the letter
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return String with content of the letter
	 */
	public String toString() {
		return  this.getContent().toString();
	}

}
