package city;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import content.Content;
import content.letter.Letter;
import mocks.MockContent;
import mocks.MockLetter;
import mocks.MockLetterSendAnotherLetter;

public class CityTest {
	
	public City createCity() {
		List<String> streets = new ArrayList<String>();
		List<Letter<?>> mailbox = new ArrayList<Letter<?>>();
		String rezDeChaussez = "Rez de Chaussez";
		String rueDeLaHette = "Rue de la Hette";
		streets.add(rezDeChaussez);
		streets.add(rueDeLaHette);
		int nbInhab = 10;
		List<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
		City city  = new City(mailbox, "Lille", inhabitants, streets);
		for (int i= 0; i<nbInhab;i++) {
			int f =(int) (Math.random() * ( 4000- 3 ));
			Account account = new Account(f);
			Inhabitant inhab = new Inhabitant(city, account);
			inhabitants.add(inhab);
		}
		return city;
		
	}
	
	public Letter createLetter(Content content,Inhabitant sender, Inhabitant receiver){
		MockContent contentMock = (MockContent) content;
		return new MockLetter(contentMock, sender, receiver);
	}
	@Test
	public void testAddLetter() {
		City  city = createCity();
		List<Inhabitant> inhabitants = city.getInhabitants();
		city.getMailbox().clear();
		MockContent text = new MockContent("Bonjour");
		Letter letter = createLetter(text,city.getInhabitants().get(0),city.getInhabitants().get(1));
		city.addLetter(letter);
		assertTrue(city.getMailbox().contains(letter));
	}

	@Test
	public void testDistributeLetters() {
		City  city = createCity();
		List<Inhabitant> inhabitants = city.getInhabitants();
		city.getMailbox().clear();
		
		MockContent text = new MockContent("Bonjour");
		Letter letter = createLetter(text,city.getInhabitants().get(0),city.getInhabitants().get(1));
		city.addLetter(letter);
		
		MockLetterSendAnotherLetter letter2 = new MockLetterSendAnotherLetter(text, city.getInhabitants().get(2),city.getInhabitants().get(1));
		city.addLetter(letter2);
		
		city.distributeLetters();
		
		assertEquals(1,city.getMailbox().size());
		
	}

}
