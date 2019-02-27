package actions.free;

import pool.ResourcesPool;
import resources.Basket;
import resources.ResourceUser;
/**
 * Class FreeBasketAction
 * 
 * @author Simona Enasoae, Marcel Fernadez de la Pena
 *
 */
public class FreeBasketAction extends FreeResourceAction<Basket>{
	//CONSTRUCTORS
	/**
	 * Constructor
	 * 
	 * @param resourceUser  the user who will take the resource
	 * @param resourcePool  the pool from which we will take the resource
	 */
	public FreeBasketAction(ResourceUser<Basket> resourceUser, ResourcesPool<Basket> resourcePool) {
		super(resourceUser, resourcePool);
	}
	
	//METHODS
	/**
	 * @return a representation for the class FreeCubicleAction
	 */
	@Override
	public String toString() {
		return "freeing resource from pool basket \n ";
	}

}
