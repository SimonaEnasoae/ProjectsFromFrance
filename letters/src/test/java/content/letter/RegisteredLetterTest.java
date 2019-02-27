package content.letter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import city.City;
import city.Inhabitant;
import content.Content;
import content.Money;
import content.Text;
import content.letter.decorator.RegisteredLetter;
import mocks.MockContent;
import mocks.MockLetter;
import city.Account;

public class RegisteredLetterTest extends LetterTest{

	
	public Letter createLetter(Content content,Inhabitant sender,Inhabitant receiver) {
		MockLetter mockLetter = (MockLetter) content;
		RegisteredLetter registeredLetter = new RegisteredLetter(mockLetter);
		registeredLetter.setSender(sender);
		registeredLetter.setReceiver(receiver);
		return registeredLetter;
	}
	public Content createContent() {
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		MockContent text = new MockContent("Bonjour, RegisteredLetterTest");
		MockLetter mockLetter = new MockLetter(text, sender, receiver);
		return mockLetter;
	}
	@Test
	public void testGetCost() {
		MockLetter mockLetter = (MockLetter) createContent();
		RegisteredLetter registeredLetter =  (RegisteredLetter) createLetter(mockLetter,mockLetter.getSender(),mockLetter.getReceiver());
		float sendingMockLetterCost = mockLetter.getCost();
		assertEquals(registeredLetter.PERCENT*sendingMockLetterCost,registeredLetter.getCost(),0);
	}

	@Test
	public void testAction() {
		MockLetter mockLetter = (MockLetter) createContent();
		RegisteredLetter registeredLetter =  (RegisteredLetter) createLetter(mockLetter,mockLetter.getSender(),mockLetter.getReceiver());
		Inhabitant receiver = registeredLetter.getSender();
		int nbLetters = receiver.getCity().getMailbox().size();
		registeredLetter.action();
		assertEquals(nbLetters+1, receiver.getCity().getMailbox().size());
	
	}

}
