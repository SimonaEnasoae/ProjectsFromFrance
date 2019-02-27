package content.letter.decorator;

import content.Content;
import content.Text;
import content.letter.Letter;
import content.letter.simple.ReceiptLetter;
/**
 * Class RegisteredLetter
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class RegisteredLetter extends DecoratorLetter{
	//ATTRIBUTES
	/**
	 * string used for the name of the letter
	 */
	protected static final String RECOMMANDÉ_MESSAGE = " recommandé";
	/**
	 * attribute used for the cost of the letter
	 */
	public static final float PERCENT = 1.15f;
	
	//CONSTRUCTOR
	/**
	 * Constructs an registered letter where the content is an other letter
	 * @param letter is the letter that will be registered
	 */
	public RegisteredLetter(Letter <?> letter){
		super(letter);
		this.name = letter.getName()+RECOMMANDÉ_MESSAGE;
	}
	
	/**
	 * return the cost of the letter
	 * @return the cost 
	 */
	@Override
	public float getCost() {
		return this.content.getCost()*PERCENT;
	}

	/**
	 * do the action of the contained letter, and then the receiver sends an acknowledgement of receipt
	 */
	@Override
	public void action() {
		this.content.action();
		ReceiptLetter receipt = new ReceiptLetter(this.content.getName(),this.content.getReceiver(),this.content.getSender());
		receipt.getReceiver().getCity().addLetter(receipt);
	}
	
}
