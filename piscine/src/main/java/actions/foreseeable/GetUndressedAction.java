package actions.foreseeable;

/**
 * Class GetUndressedAction
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena 
 *
 */
public class GetUndressedAction extends ForeseeableAction {
	//CONSTRUCTORS
	/**
	 * Constructor
	 * 
	 * @param nbSteps the time to get undressed
	 */
	public GetUndressedAction(int nbSteps) {
		super(nbSteps);
	}
	
	//METHODS
	/**
	 * @return a representation for the class GetUndressedAction
	 */
	@Override
	public String toString() {
		return " undressing "+super.toString();
	}

}
