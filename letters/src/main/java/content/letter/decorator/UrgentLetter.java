package content.letter.decorator;

import content.Content;
import content.letter.Letter;
/**
 * Class Urgent Letter
 * 
 * @author Simona Enasaoe, Marcel Fernandez de la Pena
 *
 */
public class UrgentLetter extends DecoratorLetter{
	/**
	 * string used for the name of the letter
	 */
	protected static final String URGENT_MESSAGE = " URGENT ";
	/**
	 * attribute used for the cost of the letter
	 */
	public static final int DOUBLE_PRICE = 2;

	//CONSTRUCTOR
	/**
	 * Constructs an urgent letter where the content is an other letter  
	 * @param letter is the letter that will have double price and will be urgent
	 */
	public UrgentLetter(Letter<?> letter) {
		super(letter);
		this.name = letter.getName()+URGENT_MESSAGE;

	}
	
	//METHODS
	/**
	 * return the cost of the letter
	 * @return the double cost of the letter whether Simple or BillOfExchange
	 */
	@Override
	public float getCost() {	
		
		return this.content.getCost()*DOUBLE_PRICE;
	}

	/**
	 * do the action of the contained letter
	 */
	@Override
	public void action() {
		
		this.content.action();
	}
	
}
