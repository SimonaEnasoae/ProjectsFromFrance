package project;

import java.util.ArrayList;
import java.lang.Object;
import java.util.List;

import city.Account;
import city.City;
import city.Inhabitant;
import content.InhabitantsChain;
import content.Money;
import content.Text;
import content.letter.BillOfExchange;
import content.letter.FoolChain;
import content.letter.Letter;
import content.letter.decorator.RegisteredLetter;
import content.letter.decorator.UrgentLetter;
import content.letter.simple.ReceiptLetter;
import content.letter.simple.SimpleLetter;
import content.letter.simple.ThanksLetter;
/**
 * Class Simulation
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class Simulation
{	
	//ATTRIBUTE
	/**
	 * Counter which helps to differentiate the text of simple letter
	 */
	private static int cpt=0;

	//METHODS
	/**
	 * 
	 * @param sender		the inhabitant who sends the letter
	 * @param receiver		the inhabitant who will receive the letter
	 * @return				new Simple Letter
	 */
	 public static SimpleLetter createSimpleLetter(Inhabitant sender, Inhabitant receiver) {
		 Text text = new Text("bla bla "+cpt++);
		 return new SimpleLetter(text, sender, receiver);	 
	 }
	 
	/**
	 * 
	 * @param sender		the inhabitant who sends the letter
	 * @param receiver		the inhabitant who will receive the letter
	 * @return				new BillOfExchange
	 */
	public static BillOfExchange createBillOfExchange(Inhabitant sender, Inhabitant receiver) {
		float f =(float) (Math.random() * ( 400- 3 ));
		Money amount = new Money(f);
		 return new BillOfExchange(amount, sender, receiver);
	}
	
	/**
	 * 
	 * @param sender		the inhabitant who sends the letter
	 * @param receiver		the inhabitant who will receive the letter
	 * @return				new RegisteredLetter from SimpleLetter sent
	 */
	 public static RegisteredLetter createRegisteredSimpleLetter(Inhabitant sender, Inhabitant receiver) {
		 return new RegisteredLetter(createSimpleLetter( sender, receiver)); 
	 }
	 
	/**
	 * 
	 * @param sender		the inhabitant who sends the letter
	 * @param receiver		the inhabitant who will receive the letter
	 * @return				new RegisteredLetter from BillOfExchange sent
	 */
	public static RegisteredLetter createRegisteredBillOfExchange(Inhabitant sender, Inhabitant receiver) {
			 return new RegisteredLetter(createBillOfExchange(sender, receiver));
	}
	 
	/**
	 * 
	 * @param sender		the inhabitant who sends the letter
	 * @param receiver		the inhabitant who will receive the letter
	 * @return				new Urgent Simple letter
	 */
	 public static UrgentLetter createUrgentSimpleLetter(Inhabitant sender, Inhabitant receiver) {
		 return new UrgentLetter(createSimpleLetter( sender, receiver)); 
	 }
	 
	 /**
	 * 
	 * @param sender		the inhabitant who sends the letter
	 * @param receiver		the inhabitant who will receive the letter
	 * @return				new Urgent BillOfExchange
	 */
	 public static UrgentLetter createUrgentBillOfExchange(Inhabitant sender, Inhabitant receiver) {
		 return new UrgentLetter(createBillOfExchange( sender, receiver)); 
	 }
	 
	 /**
	 * 
	 * @param sender		the inhabitant who sends the letter
	 * @param receiver		the inhabitant who will receive the letter
	 * @return				new Urgent Registered SimpleLetter
	 */
	 public static UrgentLetter createUrgentRegisteredSimpleLetter(Inhabitant sender, Inhabitant receiver) {
		 return new UrgentLetter(createRegisteredSimpleLetter( sender, receiver)); 
	 }
	 
	 /**
	 * 
	 * @param sender		the inhabitant who sends the letter
	 * @param receiver		the inhabitant who will receive the letter
	 * @return				new Urgent Registered BillOfExchange
	 */
	 static UrgentLetter createUrgenRegisteredtBillOfExchange(Inhabitant sender, Inhabitant receiver) {
		 return new UrgentLetter(createRegisteredBillOfExchange( sender, receiver)); 
	 }
	 
	 /**
	  * 
	  * @param k the number of days that will be simulated 
	  */
	public static void simulationDistributeLetters(int k) {
		List<String> streets = new ArrayList<String>();
		List<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
		List<Letter<?>> mailbox = new ArrayList<Letter<?>>();
		String street1 = "Street 1";
		streets.add(street1);
		City city = new City(mailbox, "Lille", inhabitants, streets);
		Text text = new Text("bla bla");
		int nbInhab = 10;
		for (int i= 0; i<nbInhab;i++) {
			int f =(int) (Math.random() * ( 4000- 3 ));
			Account account = new Account(f);
			Inhabitant inhab = new Inhabitant(city, account);
			inhabitants.add(inhab);
		}
		System.out.println();
		for (int i= 0; i<nbInhab;i++) {
			System.out.println(inhabitants.get(i).getName()+ " has "+ inhabitants.get(i).getAccount().getAmount());
		}
		for (int i= 0; i<k;i++) {
			int nbLetters = (int) (Math.random() * (5-1));
			Letter l;

			System.out.println("==== ADD "+nbLetters+" letters ====");
			for (int j= 0; j< nbLetters;j++) {
				
				int nrSender = (int) (Math.random() * nbInhab); 
				Inhabitant sender = inhabitants.get(nrSender);
				
				int nrReceiver = (int) (Math.random() * nbInhab); 
				if(nrSender == nrReceiver ) {
					nrReceiver++;
				}
				if(nrReceiver == inhabitants.size()) {
					nrReceiver =nrReceiver-2;
				}
				Inhabitant receiver = inhabitants.get(nrReceiver);
				
				int type = (int) (Math.random() * 7); 
				switch (type) {
				case 0: 
					l = createSimpleLetter(sender,receiver);
					sender.sendLetter(l);
					break;
				case 1: 
					l = createBillOfExchange(sender,receiver);
					sender.sendLetter(l);
					break;
				case 2: 
					l = createRegisteredSimpleLetter(sender,receiver);
					sender.sendLetter(l);
					break;
				case 3: 
					l = createRegisteredBillOfExchange(sender,receiver);
					sender.sendLetter(l);
					break;
				case 4: 
					l = createUrgentSimpleLetter(sender,receiver);
					sender.sendLetter(l);
					break;
				case 5: 
					l = createUrgentBillOfExchange(sender,receiver);
					sender.sendLetter(l);
					break;
				case 6: 
					l = createUrgentRegisteredSimpleLetter(sender,receiver);
					sender.sendLetter(l);
					break;
				case 7: 
					l = createUrgenRegisteredtBillOfExchange(sender,receiver);
					sender.sendLetter(l);
					break;
					
				default:
					break;
				}		
			}
			System.out.println();
			for (int k1= 0; k1<nbInhab;k1++) {
				System.out.println(inhabitants.get(k1).getName()+ " has "+ inhabitants.get(k1).getAccount().getAmount());
			}
			System.out.println();
			System.out.println("==== Jour "+i+"====");
			System.out.println();
			
			city.distributeLetters();
			
		}
		System.out.println();
		for (int k1= 0; k1<nbInhab;k1++) {
			System.out.println(inhabitants.get(k1).getName()+ " has "+ inhabitants.get(k1).getAccount().getAmount());
		}
	}
	
	/**
	 * Creates a FoolLetter simulation
	 */
	public static void simulationFoolLetter() {
		List<String> streets = new ArrayList<String>();
		List<Letter<?>> mailbox = new ArrayList<Letter<?>>();
		String rezDeChaussez = "Rez de Chaussez";
		String rueDeLaHette = "Rue de la Hette";
		streets.add(rezDeChaussez);
		streets.add(rueDeLaHette);
		
		List<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
		City city = new City(mailbox, "Lille", inhabitants, streets);
		int nbInhab = 20;
		
		//Creates n number of inhabitants and their respective account
		for (int i= 0; i<nbInhab;i++) {
			Account account = new Account(300);
			Inhabitant inhab = new Inhabitant(city, account);
			inhabitants.add(inhab);
		}
		List<Inhabitant> inhabitants2= new ArrayList<Inhabitant>();
		
		for (int i= 0; i<4;i++) {
			Account account = new Account(300);
			Inhabitant inhab = new Inhabitant(city, account);
			inhabitants.add(inhab);
			inhabitants2.add(inhab);
		}
		
		InhabitantsChain inhabitantsChain = new InhabitantsChain(inhabitants2);
		
		Inhabitant sender = new Inhabitant(city, new Account(300));
		Inhabitant receiver  = new Inhabitant(city, new Account(300));
		FoolChain foolChain = new FoolChain(inhabitantsChain, sender, receiver);
		inhabitants.add(sender);
		inhabitants.add(receiver);
		int i=0;
		sender.sendLetter(foolChain);
		while (! city.getMailbox().isEmpty()) {
			System.out.println();
			System.out.println("==== Jour "+i++ +"====");
			System.out.println();
			System.out.println();
			//Outputs the amount of money from each inhabitant
			for (int k1= 0; k1<nbInhab+6;k1++) {
				System.out.println(inhabitants.get(k1).getName()+ " has "+ inhabitants.get(k1).getAccount().getAmount());
			}
			System.out.println();
			city.distributeLetters();
		}

	}
	
}
