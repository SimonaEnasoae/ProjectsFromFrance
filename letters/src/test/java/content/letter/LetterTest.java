package content.letter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import city.Account;
import city.City;
import city.Inhabitant;
import content.Content;
import content.Text;
import mocks.MockContent;
import mocks.MockLetter;

public  class  LetterTest {

	public Content createContent() {
		MockContent text = new MockContent("Bonjour");
		return text;
	}
	public Letter createLetter(Content content, Inhabitant sender, Inhabitant receiver){
		return new MockLetter((MockContent) content, sender, receiver);
	}
	protected Inhabitant createInhabitant() {
		List<Letter<?>> mailbox = new ArrayList<Letter<?>>();
		List<Inhabitant> inhabitantsList = new ArrayList<Inhabitant>();
		List<String> streets = new ArrayList<String>();
		String rezDeChaussee = "rez de Chausee";
		String AnneJosepheDuBourg = "Anne Josephe Du Bourg";
		streets.add(rezDeChaussee);
		streets.add(AnneJosepheDuBourg);
		City lille = new City(mailbox, "Lille", inhabitantsList, streets);
		Account account1 = new Account(1000f, "FR502478");
		Account account2 = new Account(2000f, "FR502479" );
		Inhabitant inhabitant1 = new Inhabitant(lille, account1, "Maria");
		Inhabitant inhabitant2 = new Inhabitant(lille, account2, "Marcel");
		inhabitantsList.add(inhabitant1);
		inhabitantsList.add(inhabitant2);
		
		return inhabitant1;
	}
	@Test
	public void testGetContent() {
		Content text = createContent();
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		Letter letter = createLetter(text,sender,receiver);
		assertEquals(text, letter.getContent());
	}
	
	@Test
	public void testGetCost() {
		Content text = createContent();
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		Letter letter = createLetter(text,sender,receiver);		
		assertEquals(0.9f,letter.getCost(), 0);
	}

	@Test
	public void testAction() {
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		MockLetter letter =  (MockLetter) createLetter(new MockContent("Bonjour"),sender,receiver);
		letter.action();
		assertTrue(letter.checkAction);
	}
	

	@Test
	public void testGetSender() {
		Content text = createContent();
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		Letter letter = createLetter(text,sender,receiver);		
		assertSame(sender,letter.getSender());
	}

	

	@Test
	public void testGetReceiver() {
		Content text = createContent();
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		Letter letter = createLetter(text,sender,receiver);		
		assertSame(receiver,letter.getReceiver());
	}

	
}
