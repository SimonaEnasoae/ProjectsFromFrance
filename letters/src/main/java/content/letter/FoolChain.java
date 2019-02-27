package content.letter;

import content.InhabitantsChain;
import content.Money;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import city.Inhabitant;

/**
 * Class Inhabitant
 * 
 * @author Simona Enasaoe, Marcel Fernandez de la Pena
 *
 */
public class FoolChain extends Letter<InhabitantsChain>{

	//ATTRIBUTE
	/**
	 * Cost of sending a fool chain
	 */
	private static final float COST = 0.5f;
	/**
	 * string with fool description
	 */
	private static final String FOOL_MESSAGE = " FOOL ";

	//CONSTRUCTOR
	/**
	 * 
	 * @param inhabitantsChain	the content of the letter
	 * @param sender			the inhabitant who sends the letter
	 * @param receiver			the inhabitant who will receive the letter
	 */
	public FoolChain(InhabitantsChain inhabitantsChain, Inhabitant sender, Inhabitant receiver) {
		super(inhabitantsChain, sender, receiver);
		this.name = super.getName()+FOOL_MESSAGE;

	}
	
	/**
	 * get the cost of FoolChain
	 * 
	 * @return the cost of sending the letter
	 */
	@Override
	public float getCost() {
		return COST;
	}

	/**
	 * Sends 5 euros to each foolChain inhabitant, deletes the first name of the list 
	 * and then sends the new foolChain to 10 
	 */
	@Override
	public void action() {
		Random random = new Random();
		if(random.nextInt(9)==0) {
			for(Inhabitant inhab:this.getContent().getContent()) {
				BillOfExchange billOfExchange = new BillOfExchange(new Money(5f),this.getReceiver(), inhab);
				try {
					this.receiver.sendLetter(billOfExchange);
				}
				catch (NotEnoughMoneyException e){
					System.out.println(e.getMessage());
				}
			}
			InhabitantsChain foolChain =  this.getContent();
			
			foolChain.getContent().remove(0);
			foolChain.getContent().add(receiver);
			
			List<Inhabitant> randomInhabitants = this.receiver.getCity().getRandomInhabitants(10);
			for(int i = 0; i<randomInhabitants.size(); i++) {
				
				FoolChain newFoolChain = new FoolChain (foolChain, receiver, randomInhabitants.get(i) );
	
				try {
					this.receiver.sendLetter(newFoolChain);
				}
				catch (NotEnoughMoneyException e){
					System.out.println(e.getMessage());
				}	
			}
		}
	}
}
