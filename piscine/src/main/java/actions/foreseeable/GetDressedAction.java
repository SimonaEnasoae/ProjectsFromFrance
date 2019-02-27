package actions.foreseeable;

/**
 * Class GetDressedAction
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena 
 *
 */
public class GetDressedAction extends ForeseeableAction{
	//CONSTRUCTORS
	/**
	 * Constructor
	 * 
	 * @param nbSteps the time to get undressed
	 */
	public GetDressedAction(int nbSteps) {
		super(nbSteps);
	}
	
	//METHODS
		/**
		 * @return a representation for the class GetUndressedAction
		 */
	@Override
	public String toString() {
		return " dressing "+ super.toString();
	}

}
