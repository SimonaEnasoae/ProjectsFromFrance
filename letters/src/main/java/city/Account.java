package city;
/**
 * Class Account
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class Account {
		//ATTRIBUTE 
	
		/**
		 * constant used for the account name 
		 */
	    protected static final String ACCOUNT_DEFAULT_NAME = "account";
	    /**
	     * counter for the name which is incremented each time we create an object of type Account
	     */
	    protected static int cpt=0;
		/**
		 * the amount of money
		 */
	    protected float amount;
		/**
		 * the IABN of the account
		 */
	    protected String IBAN;
		
		//CONSTRUCTOR
		/**
		 * Constructor
		 * 
		 * @param amount  the amount of money 
		 */
		public Account(float amount) {
			super();
			this.amount = amount;
			IBAN = ACCOUNT_DEFAULT_NAME+ Integer.toString((Account.cpt ++));

		}
		/**
		 * Constructor
		 * 
		 * @param amount  the amount of money 
		 * @param iBAN    the international banking account number
		 */
		public Account(float amount, String iBAN) {
			super();
			this.amount = amount;
			IBAN = iBAN;
		}
		/**
		 * return the amount in the account
		 * @return the amount of the account
		 */
		public float getAmount() {
			return amount;
		}
		
		/**
		 * set the new amount of the account
		 * @param amount     the new amount in the account
		 */
		public void setAmount(float amount) {
			this.amount = amount;
		}
		
		/**
		 * withdrawn an amount of money from the account 
		 * 
		 * @param amount     the amount to be withdrawn from the account
		 */
		public void debit(float amount) {
			this.amount -= amount;
		}
		/**
		 * add an amount of money in the account
		 * 
		 * @param amount    the amount to added  in the account
		 */
		public void credit(float amount) {
			this.amount += amount;
		}
		
}
