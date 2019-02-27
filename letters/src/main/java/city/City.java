package city;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import content.letter.*;

/**
 * Class City
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class City {

	//ATTRIBUTE 
	/**
	 * the mailbox of the city where the letters will be added
	 */
	protected List<Letter<?>> mailbox;
	/**
	 * the name of the city
	 */
	protected String name;
	/**
	 * the list of inhabitants
	 */
	protected List<Inhabitant> inhabitants;
	/**
	 * the list of the streets
	 */
	protected List<String> streets;
	
	//CONSTRUCTOR
	/**
	 * 
	 * @param mailbox		the list of letters in the city
	 * @param name			the name of the city
	 * @param inhabitants	list of inhabitants in the city
	 * @param streets		list of streets in the city 
	 */
	public City(List<Letter<?>> mailbox, String name, List<Inhabitant> inhabitants, List<String> streets) {
		super();
		this.mailbox = mailbox;
		this.name = name;
		this.inhabitants = inhabitants;
		this.streets = streets;
	}
	
	//METHODS
	/**
	 * Add a letter to the mailbox of the city
	 * 
	 * @param letter that will be added to the mailbox
	 */
	public void addLetter(Letter<?> letter){
		/*
		 * this is only to improve the tracking of the simulation, doesn't change the rest of the code
		 */
	
		mailbox.add(letter);
		System.out.println(letter.getSender()+" envoie " + letter.getName()+"(cout: "+letter.getCost()+" )" + " a "+ letter.getReceiver() );

	}
	
	/**
	 * Gives the letters in the mailbox to a new arrayList and then browses it to deliver the all letters. Also empties mailbox.
	 */
	public void distributeLetters() {
		List<Letter> bag = new ArrayList<Letter>(this.mailbox);

		this.mailbox.clear();
		for(Letter<?> l:bag) {
			System.out.println(l.getName()+ "(cout: "+l.getCost()+")"+"["+l.toString()+"] envoyé par "+l.getSender()+ " recu par "+ l.getReceiver());
			l.getReceiver().receiveLetter(l);
		}
		
	}
	
	//GETTERS and SETTERS
	/**
	 * return the mailbox of the city
	 * @return mailbox list containing the letters sent to the current city
	 */
	public List<Letter<?>> getMailbox() {
		return mailbox;
	}

	/**
	 * set the mailbox of the city
	 * 
	 * @param mailbox set the list of letters 
	 */
	public void setMailbox(List<Letter<?>> mailbox) {
		this.mailbox = mailbox;
	}

	/**
	 * return the name of the city
	 * 
	 * @return the name of the city
	 */
	public String getName() {
		return name;
	}

	/**
	 * change the name of the city
	 * 
	 * @param name set the name of the city
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * return the list of the inhabitants
	 * 
	 * @return inhabitants list with all the inhabitants who live in the city
	 */
	public List<Inhabitant> getInhabitants() {
		return inhabitants;
	}

	/**
	 * change the list of inhabitants of the city
	 * @param inhabitants set the list of inhabitants of the city
	 */
	public void setInhabitants(List<Inhabitant> inhabitants) {
		this.inhabitants = inhabitants;
	}

	/**
	 * return the list of the streets of the city
	 * 
	 * @return streets a list of String with the name of the streets in the city
	 */
	public List<String> getStreets() {
		return streets;
	}

	/**
	 * change the list of the streets
	 * 
	 * @param streets set the list of the streets of the city
	 */
	public void setStreets(List<String> streets) {
		this.streets = streets;
	}
	
	/**
	 * return a random list with k inhabitants 
	 * @param  k the number of inhabitants 
	 * @return a random inhabitant from the city's inhabitantsList
	 */
	public List<Inhabitant> getRandomInhabitants(int k) {
		Random rand = new Random();
		
		int[] index =  new Random().ints(0,this.inhabitants.size()).limit(k).toArray();
		List<Inhabitant> kInhabitants = new ArrayList<Inhabitant>();
		for(int i = 0; i<k; i++) {
			kInhabitants.add(this.inhabitants.get(index[i]));
		}
		
		return kInhabitants;

	}
	
}
