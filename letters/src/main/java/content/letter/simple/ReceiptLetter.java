package content.letter.simple;

import city.Inhabitant;
import content.Text;
/**
 * Class ReceiptLetter
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class ReceiptLetter extends SimpleLetter {
	//ATTRIBUTE
	/**
	 * string with type of letter description
	 */
	private static final String ACCUSE_DE_RECEPTION_NAME = " accuse de reception ";
	//CONSTRUCTOR
	/**
	 * Constructor
	 * 
	 * @param c 		the content of the letter
	 * @param sender 	the inhabitant who sends the letter
	 * @param receiver 	the inhabitant who will receive the letter
	 */
	public ReceiptLetter(Text c, Inhabitant sender, Inhabitant receiver) {
		super(c, sender, receiver);
		
	}
	//CONSTRUCTOR
	/**
	 * Constructor
	 * @param nameLetter the name of the letter
	 * @param sender 	the inhabitant who sends the letter
	 * @param receiver 	the inhabitant who will receive the letter
	 */
	public ReceiptLetter(String nameLetter, Inhabitant sender, Inhabitant receiver) {
		super( new Text("accuse du "+nameLetter+" recommande"), sender, receiver);
		this.name = super.getName()+ACCUSE_DE_RECEPTION_NAME;

		
	}
}
