package city;

import content.Content;
import content.Money;
import content.letter.Letter;
import content.letter.NotEnoughMoneyException;

/**
 * Class Inhabitant
 * 
 * @author Simona Enasaoe, Marcel Fernandez de la Pena
 *
 */
public class Inhabitant {
	//ATTRIBUTES
	/**
	 * constant used for the inhabitant name 
	 */
	private static final String COURRIER_DEFAULT_NAME = "hab";
	 /**
     * counter for the name which is incremented each time we create an object of type Inhabitant
     */
	private static int cpt;
	/**
	 * the city where the inhabitant lives
	 */
	protected City city;
	/**
	 * the account
	 */
	protected Account account;
	/**
	 *  the name of the inhabitant
	 */
	protected String name;
	
	//CONSTRUCTOR
	/**
	 * Constructor 
	 * 
	 * @param city     the city 
	 * @param account  the account of the inhabitant
	 * @param name     the name of the inhabitant
	 */
	public Inhabitant(City city, Account account, String name) {
		this.city = city;
		this.account = account;
		this.name = name;
	} 
	/**
	 * Constructor 
	 * 
	 * @param city     the city 
	 * @param account  the account of the inhabitant
	 */
	public Inhabitant(City city, Account account) {
		this.city = city;
		this.account = account;
		this.name = COURRIER_DEFAULT_NAME+ Integer.toString((Inhabitant.cpt ++));

	} 
	/**
	 * return the city
	 * @return the city of inhabitant
	 */
	public City getCity() {
		return city;
	}

	/**
	 * change the city
	 * @param city the new city of the inhabitant
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * return the account
	 * @return account of the inhabitant
	 */
	public Account getAccount() {
		return account;
	}
	/**
	 * change the account of the inhabitant
	 * @param account  the new account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	/**
	 * return the name of Inhabitant
	 * @return tha name
	 */
	public String getName() {
		return name;
	}
	/**
	 * change the name with a new one
	 * @param name the new name of the inhabitant
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * send the letter in the mailbo of the city
	 * @param l the letter that is about to be sent.
	 * @throws NotEnoughMoneyException the inhabitant doesn't have enough money
	 */
	public void sendLetter(Letter<?> l) {
		if(l.getCost()< this.account.getAmount()) {
			this.debit(l.getCost());
			l.getReceiver().getCity().addLetter(l);
		}
		else {
			throw new NotEnoughMoneyException("you are too poor :( ");
		}
	}
	
	/**
	 * receive a letter and call its action
	 * 
	 * @param l the letter that is received.
	 */
	public void receiveLetter(Letter<?> l) {
		l.action();
	}
	/**
	 * withdrawn an amount of money from the account 
	 * @param amount the amount to take from the account
	 */
	public void debit(float amount) {
		this.account.debit(amount);;
	}

	/**
	 * add an amount of money in the account
	 * @param content  the amount to add to the account
	 */
	public void credit(float content) {
		this.account.credit(content);;
	}
	/**
	 * withdrawn an amount of money from the account 
	 * @param amount the amount to take from the account
	 */
	public void debit(Money amount) {
		this.account.debit(amount.getContent());
	}
	
	/**
	 * add an amount of money in the account
	 * @param amount  the amount to add to the account
	 */
	public void credit(Money amount) {
		this.account.credit(amount.getContent());;
	}
	
	/**
	 * return the name of the inhabitant
	 * @return the inhabitant's name
	 */
	public String toString() {
		return this.name;
	}
}
