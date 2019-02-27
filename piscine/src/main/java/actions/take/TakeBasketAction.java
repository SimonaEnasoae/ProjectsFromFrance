package actions.take;

import pool.ResourcesPool;
import resources.Basket;
import resources.ResourceUser;
import resources.Resources;
/**
 * Class TakeBasketAction
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class TakeBasketAction extends TakeResourceAction<Basket>{
	//CONSTRUCTORS
	/**
	 *  Constructor
	 *  
	 * @param resourceUser  the user who will take the resource
	 * @param resourcePool  the pool from which we will take the resource
	 */
	public TakeBasketAction(ResourceUser<Basket> resourceUser, ResourcesPool<Basket> resourcePool) {
		super(resourceUser, resourcePool);
		
	}
	/**
	 * @return a representation for the class TakeBasketAction
	 */
	@Override
	public String toString() {
		return "trying to take resource from pool basket ";
	}

	
}
