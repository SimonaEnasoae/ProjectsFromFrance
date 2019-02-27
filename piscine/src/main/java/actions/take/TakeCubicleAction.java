package actions.take;

import pool.ResourcesPool;
import resources.Cubicle;
import resources.ResourceUser;
/**
 * Class TakeCubicleAction
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class TakeCubicleAction extends TakeResourceAction<Cubicle>{
	//CONSTRUCTORS
	/**
	 *  Constructor
	 *  
	 * @param resourceUser  the user who will take the resource
	 * @param resourcePool  the pool from which we will take the resource
	 */
	public TakeCubicleAction(ResourceUser<Cubicle> resourceUser, ResourcesPool<Cubicle> resourcePool) {
		super(resourceUser, resourcePool);
		
	}
	
	/**
	 * @return a representation for the class TakeCubicleAction
	 */
	@Override
	public String toString() {
		return "trying to take resource from pool cubicle ";
	}

}
