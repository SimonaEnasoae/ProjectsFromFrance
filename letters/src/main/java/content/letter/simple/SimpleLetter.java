package content.letter.simple;

import city.Inhabitant;
import content.Content;
import content.Text;
import content.letter.Letter;

/**
 * Class SimpleLetter
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class SimpleLetter extends Letter<Text>{

	//ATTRIBUTE
	/**
	 * cost of simple letter
	 */
	private static final float COST = 0.5f;
	
	//CONSTRUCTOR
	/**
	 * 
	 * @param c 		the content of the letter
	 * @param sender 	the inhabitant who sends the letter
	 * @param receiver 	the inhabitant who will receive the letter
	 */
	public SimpleLetter(Text c, Inhabitant sender, Inhabitant receiver) {
		super(c, sender, receiver);
	}
	
	/**
	 * Constructor 
	 */
	public SimpleLetter() {
	}

	/**
	 * get the cost of the simple letter
	 * 
	 * @return the cost of sending the letter
	 */
	@Override
	public float getCost() {
		return COST;
	}
	/**
	 * no action implemented within the simple letter
	 */
	@Override
	public void action() {
	
	}
	
	
}
