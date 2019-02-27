package actions.free;

import pool.ResourcesPool;
import resources.Cubicle;
import resources.ResourceUser;
import resources.Resources;
/**
 * Class FreeCubicleAction
 * 
 * @author Simona Enasoae, Marcel Fernadez de la Pena
 *
 */
public class FreeCubicleAction extends FreeResourceAction<Cubicle>{
	//CONSTRUCTORS
	/**
	 * Constructor
	 * 
	 * @param resourceUser  the user who will take the resource
	 * @param resourcePool  the pool from which we will take the resource
	 */
	public FreeCubicleAction(ResourceUser<Cubicle> resourceUser, ResourcesPool<Cubicle> resourcePool) {
		super(resourceUser, resourcePool);
	}
	
	//METHODS
	/**
	 * @return a representation for the class FreeCubicleAction
	 */
	@Override
	public String toString() {
		return "freeing resource from pool cubicle \n";
	}	
}
