package content;
/**
 * Class Money 
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class Money implements Content<Float>{
	
	//ATTRIBUTES
	/**
	 * the amount of money
	 */
	protected Float amount;
	
	//CONSTRUCTORS
	/**
	 * Constructor
	 * 
	 * @param amount    the amount of money
	 */
	public Money(Float amount) {
		super();
		this.amount = amount;
	}
	
	//METHODS
	/**
	 * return the amount
	 * 
	 * @return the amount of money
	 */
	public Float getContent() {
		return amount;
	}
	
	/**
	 * return a representation of the money
	 * 
	 * @return the money as a string
	 */
	public String toString() {
		return "value= "+this.getContent();
	}

}
