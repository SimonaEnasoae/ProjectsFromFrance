package content.letter;

import static org.junit.Assert.*;

import org.junit.Test;

import city.Inhabitant;
import content.Content;
import content.Text;
import content.letter.simple.SimpleLetter;
import mocks.MockContent;
import mocks.MockLetter;

public class SimpleLetterTest extends LetterTest {
	
	public Content createContent() {
		Text text = new Text("Bonjour");
		return text;
	}
	
	public Letter createLetter(Content content, Inhabitant sender, Inhabitant receiver){
		return new SimpleLetter( (Text) content, sender, receiver);
	}
	
	@Test
	public void testGetCost() {
		Content text = createContent();
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		Letter letter = createLetter(text,sender,receiver);		
		assertEquals(0.5f,letter.getCost(), 0);
	}

	@Test
	public void testAction() {
	
		
	}

}
