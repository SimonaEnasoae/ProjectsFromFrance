package content.letter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import city.Inhabitant;
import content.Content;
import content.letter.decorator.RegisteredLetter;
import content.letter.decorator.UrgentLetter;
import mocks.MockContent;
import mocks.MockLetter;

public class UrgentLetterTest extends LetterTest{
	public Content createContent() {
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		MockContent text = new MockContent("Bonjour, RegisteredLetterTest");
		MockLetter mockLetter = new MockLetter(text, sender, receiver);
		return mockLetter;
	}
	public Letter createLetter(Content content, Inhabitant sender, Inhabitant receiver){
		MockLetter mockLetter = (MockLetter) content;
		UrgentLetter urgentLetter = new UrgentLetter(mockLetter);
		urgentLetter.setSender(sender);
		urgentLetter.setReceiver(receiver);
		return urgentLetter;
	}
	
	@Test
	public void testGetCost() {
		MockLetter content = (MockLetter) createContent();
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		UrgentLetter letter = (UrgentLetter) createLetter(content,sender,receiver);		
		assertEquals(content.getCost()* UrgentLetter.DOUBLE_PRICE ,letter.getCost(), 0);
	}
	
	@Test
	public void testAction() {
	
		
	}
}
