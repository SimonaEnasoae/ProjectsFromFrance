package content.letter.decorator;

import content.Content;
import content.letter.Letter;

/**
 * Abstract Class DecoratorLetter
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public abstract class DecoratorLetter extends Letter<Letter<? extends Content>> {
	
	//CONSTRUCTOR
	/**
	 * Constructs a letter where the content is an other letter  
	 * @param letter is the letter that will be registered
	 */
	public DecoratorLetter(Letter <?> letter){
		this.content = letter;
		this.sender = letter.getSender();
		this.receiver = letter.getReceiver();
	}
}
