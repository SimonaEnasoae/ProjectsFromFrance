package actions.foreseeable;

/**
 * Class SwimmingAction
 * 
 * @author Simona Enasoae, Marcel Fernadez de la Pena
 *
 */
public class SwimmingAction extends ForeseeableAction{
	//CONSTRUCTORS
	/**
	 * Constructor
	 * 
	 * @param nbSteps the time to swimm 
	 */
	public SwimmingAction(int nbSteps) {
		super(nbSteps);
	}
	
	//METHODS
	/**
	 * @return a representation for the class SwimmingAction
	 */
	@Override
	public String toString() {
		return "SwimmingAction "+super.toString();
	}

}
