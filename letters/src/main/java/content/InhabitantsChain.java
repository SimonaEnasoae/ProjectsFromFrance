package content;
import java.util.List;

import city.Inhabitant;
/**
 * Class NaiveChain
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class InhabitantsChain implements Content{

	//ATTRIBUTES
	/**
	 * the list of the inhabitants for the foolLetter
	 */
	protected List<Inhabitant> inhabitantsList;

	//CONSTRUCTOR
	/**
	 * 
	 * @param inhabitantsList list with inhabitants
	 */
	public InhabitantsChain(List<Inhabitant> inhabitantsList) {
		this.inhabitantsList = inhabitantsList;
	}
	
	public InhabitantsChain() {}
	
	/**
	 * set the new list of the inhabitants
	 * @param inhabitantsList list with inhabitants to be set
	 */
	public void setInhabitantsList(List<Inhabitant> inhabitantsList) {
		this.inhabitantsList = inhabitantsList;
	}

	/**
	 * return the content
	 * @return the content of the NaiveChain, inhabitantsList
	 */
	public List<Inhabitant> getContent() {
		
		return this.inhabitantsList;
	}

}
