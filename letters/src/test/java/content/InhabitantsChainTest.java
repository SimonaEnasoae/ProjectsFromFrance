package content;

import city.Account;
import city.City;
import city.Inhabitant;
import content.letter.BillOfExchange;
import content.letter.Letter;
import content.letter.simple.SimpleLetter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class InhabitantsChainTest {

	public List<Inhabitant> createInhabitantsList(int nbInhabitants){
		City city = createCity();
		List<Inhabitant> inhabitants = new ArrayList<Inhabitant>();

		for(int i=0; i<nbInhabitants; i++) {
			Account accounthab = new Account(12,"iban1");
			Inhabitant hab1 = new Inhabitant(city, accounthab);
			inhabitants.add(hab1);

		}
		return inhabitants;

	}
	
	private City createCity() {
		List<String> streets = new ArrayList<String>();
		List<Letter<?>> mailbox = new ArrayList<Letter<?>>();
		Letter letter1 = new SimpleLetter();
		mailbox.add(letter1);
		String rezDeChaussez = "Rez de Chaussez";
		String rueDeLaHette = "Rue de la Hette";
		streets.add(rezDeChaussez);
		streets.add(rueDeLaHette);
		return new City(mailbox, "Lille", null, streets);
	}
	
	@Test
	public void testSetInhabitantsList() {
		List<Inhabitant> inhabitants = createInhabitantsList(2);
		InhabitantsChain inhabitantsChain = new InhabitantsChain();
		inhabitantsChain.setInhabitantsList(inhabitants);
		assertSame(inhabitants,inhabitantsChain.getContent());
	}

	@Test
	public void testGetContent() {
		int nbInhabitants = 3;
		List<Inhabitant> inhabitants = createInhabitantsList(nbInhabitants);
		InhabitantsChain inhabitantsChain = new InhabitantsChain();
		inhabitantsChain.setInhabitantsList(inhabitants);
		assertEquals(nbInhabitants ,inhabitantsChain.getContent().size());
	}

}
