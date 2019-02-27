package actions.free;

import actions.Action;
import actions.exceptions.ActionFinishedException;
import pool.ResourcesPool;
import resources.ResourceUser;
import resources.Resources;
/**
 * Class FreeResourceAction
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 * @param <R> the resource type that will be used
 */
public class FreeResourceAction<R extends Resources> extends Action{
	//ATRIBUTES
	protected ResourceUser<R> resourceUser;
	protected ResourcesPool<R> resourcePool;
	
	//CONSTRUCTORS
	/**
	 *  Constructor
	 *  
	 * @param resourceUser  the user who will free the resource
	 * @param resourcePool  the pool from which we will take the resource
	 */
	public FreeResourceAction(ResourceUser<R> resourceUser, ResourcesPool<R> resourcePool){
		this.resourcePool = resourcePool;
		this.resourceUser = resourceUser;
	}
	
	//METHODS
	/**
	 * 
	 * @return the resource user which is used by this action
	 */
	public ResourceUser<R> getResourceUser() {
		return resourceUser;
	}
	
	/**
	 * Set the new  resource user to the new resource user in parameters
	 * 
	 * @param resourceUser the new resourceUser
	 */
	public void setResourceUser(ResourceUser<R> resourceUser) {
		this.resourceUser = resourceUser;
	}
	
	/**
	 * 
	 * @return the resource pool which is used by this action
	 */
	public ResourcesPool<R> getResourcePool() {
		return resourcePool;
	}
	
	/**
	 * Set the new  resource pool to the new resource pool in parameters
	 * 
	 * @param resourcePool the new resourcePool
	 */
	public void setResourcePool(ResourcesPool<R> resourcePool) {
		this.resourcePool = resourcePool;
	}
	
	/**
	 * Make only one step ,recover the resource from the user
	 */
	@Override
	public void makeOneStep() {
		try{
			resourcePool.recoverResource(resourceUser.getResource());
			resourceUser.resetResource();	
		}catch(IllegalArgumentException e){	
		}		
	}
	
	/**
	 * 
	 * @return true if user release the resource, false otherwise
	 */
	@Override
	public boolean StopCondition() {
		if(this.resourceUser.getResource() == null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @return a representation for the class FreeResourceAction
	 */
	public String toString() {
		return "trying to release resource from pool";
	}


}
