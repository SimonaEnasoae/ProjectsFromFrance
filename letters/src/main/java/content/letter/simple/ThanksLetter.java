package content.letter.simple;

import city.Inhabitant;
import content.Text;
/**
 * Class ThanksLetter
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class ThanksLetter extends SimpleLetter {
	//ATTRIBUTES
	/**
	 * string with type of letter description
	 */
	private static final String THANK_YOU_NAME = " de remerciement";
	/**
	 * string with type of letter description
	 */
	private static final String THANK_YOU_MESSAGE = "Thank you! ";
	//CONSTRUCTOR
	/**
	 * Constructor
	 * 
	 * @param c 		the content of the letter
	 * @param sender 	the inhabitant who sends the letter
	 * @param receiver 	the inhabitant who will receive the letter
	 */
	public ThanksLetter(Text c, Inhabitant sender, Inhabitant receiver) {
		
		super(c, sender, receiver);
		this.name = super.getName()+THANK_YOU_NAME;
	}
	/**
	 * Constructor
	 * 
	 * @param sender 	the inhabitant who sends the letter
	 * @param receiver 	the inhabitant who will receive the letter
	 */
	public ThanksLetter(Inhabitant sender, Inhabitant receiver) {
		super( new Text(THANK_YOU_MESSAGE), sender, receiver);
		this.name = super.getName()+THANK_YOU_NAME;

		
	}
}
