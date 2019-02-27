package content.letter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import city.Account;
import city.City;
import city.Inhabitant;
import content.InhabitantsChain;
import content.letter.simple.SimpleLetter;

public class FoolChainTest {

	private static int cpt=0;
	
	public Inhabitant createInhabitant(float amount, City city) {
		Account account1 = new Account(amount, "FR502478");
		Inhabitant inhabitant1 = new Inhabitant(city, account1, "Maria"+cpt++);
		city.getInhabitants().add(inhabitant1);
		return inhabitant1;
	}
	
	private City createCity() {
		List<String> streets = new ArrayList<String>();
		List<Letter<?>> mailbox = new ArrayList<Letter<?>>();
		String rezDeChaussez = "Rez de Chaussez";
		String rueDeLaHette = "Rue de la Hette";
		streets.add(rezDeChaussez);
		streets.add(rueDeLaHette);
		
		List<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
		return new City(mailbox, "Lille", inhabitants, streets);
	}
	
	public InhabitantsChain createInhabitantsChain(){
		
		City city = createCity();
		Inhabitant hab1 = createInhabitant(0f, city);
		Inhabitant hab2= createInhabitant(0f, city);
		Inhabitant hab3 = createInhabitant(0f, city);
		Inhabitant hab4 = createInhabitant(0f, city);
		Inhabitant hab5 = createInhabitant(0f, city);
		Inhabitant hab6= createInhabitant(0f, city);
		Inhabitant hab7 = createInhabitant(0f, city);
		Inhabitant hab8 = createInhabitant(0f, city);
		Inhabitant hab9 = createInhabitant(0f, city);
		Inhabitant hab10 = createInhabitant(0f, city);
		
		List<Inhabitant> inhabitants= new ArrayList<Inhabitant>();
		
		inhabitants.add(hab10);
		inhabitants.add(hab9);	
		inhabitants.add(hab8);
		inhabitants.add(hab7);
		
		
		return new InhabitantsChain(inhabitants);
		
		
	}
	public FoolChain createFoolChain() {		
		
		InhabitantsChain inhabitantsChain = createInhabitantsChain();
		Inhabitant sender = createInhabitant(100f,inhabitantsChain.getContent().get(0).getCity());
		Inhabitant receiver = createInhabitant(500.5f, inhabitantsChain.getContent().get(0).getCity());
		FoolChain foolChain = new FoolChain(inhabitantsChain, sender, receiver);
		return foolChain;
	}
	
	
	@Test
	public void testGetCost() {
		FoolChain foolChain = createFoolChain();
		assertEquals(0.5f,foolChain.getCost(),0);
	}
	
	

	
}
