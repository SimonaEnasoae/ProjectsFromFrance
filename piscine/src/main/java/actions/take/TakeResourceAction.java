package actions.take;


import java.util.NoSuchElementException;

import actions.Action;
import pool.ResourcesPool;
import resources.ResourceUser;
import resources.Resources;
/**
 * Class TakeResourceAction
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 * @param <R> the resource type that will be used
 */
public class TakeResourceAction<R extends Resources> extends Action{
	//ATRIBUTES
	protected ResourceUser<R> resourceUser;
	protected ResourcesPool<R> resourcePool;
	
	//CONSTRUCTORS
	/**
	 *  Constructor
	 *  
	 * @param resourceUser  the user who will take the resource
	 * @param resourcePool  the pool from which we will take the resource
	 */
	public TakeResourceAction(ResourceUser<R> resourceUser, ResourcesPool<R> resourcePool){
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
	 * Make only one step ,take a resource from the pool and give it to the user
	 */
	@Override
	public void makeOneStep() {
		try{
			R resource = resourcePool.provideResource();
			resourceUser.setResource(resource);
			System.out.print( " ...succes\n");
		}catch (NoSuchElementException e){
			System.out.print(" ...failed\n");
		}
	}
	
	/**
	 * 
	 * @return true if user take the resource, false otherwise
	 */
	@Override
	public boolean StopCondition() {
		if(this.resourceUser.getResource() == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * @return a representation for the class TakeResourceAction
	 */
	public String toString() {
		return "trying to take resource from pool\n";
	}

}
