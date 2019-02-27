package content.letter;

import city.Inhabitant;
import content.Content;
import content.Money;
import content.letter.simple.ThanksLetter;

/**
 * Class BillOfExchange
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class BillOfExchange extends Letter<Money>{

	//ATTRIBUTES
	/**
	 * string to specify type of message
	 */
	private static final String MESSAGE_DE_CHANGE = " de change ";
	/**
	 * the base cost of sending bill of exchange
	 */
	private static final float COST = 1f;
	/**
	 * percentage of price taken for the amount money sent 
	 */
	private static final float PERCENT = 0.01f;
	
	//CONSTRUCTOR
	/**
	 * 
	 * @param c 		the content of the letter
	 * @param sender 	the inhabitant who sends the letter
	 * @param receiver 	the inhabitant who will receive the letter
	 */
	public BillOfExchange(Money c, Inhabitant sender, Inhabitant receiver) {
		super(c, sender, receiver);
		this.name = super.getName()+MESSAGE_DE_CHANGE;
	}
	//METHODS
	/**
	 * gets total cost of bill of exchange
	 * 
	 * @return the cost of sending the letter
	 */
	@Override
	public float getCost() {
		Float f= (Float) this.getContent().getContent();
		return COST +f*PERCENT;
	}
	
	/**
	 * Add the money in receiver account,  send a ThanksLetter to the sender.
	 */
	@Override
	public void action() {
		this.receiver.credit(this.getContent());
		ThanksLetter l = new ThanksLetter(this.receiver,this.sender);
		this.receiver.sendLetter(l);
	}
	
}
