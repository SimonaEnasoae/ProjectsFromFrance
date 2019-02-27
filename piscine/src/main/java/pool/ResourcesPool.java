package pool;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import resources.Resources;
/**
 * Abstract Class ResourcesPool 
 * 
 * @author Simona Enasoae, Marcel Fernandez de la  Pena
 * 
 *  @param <R>  the resource type for the pool
 */

public abstract class ResourcesPool <R extends Resources>{
	
	// ATRIBUTES
	protected List<R> availableResources;
	protected List<R> givenResources;
	
	// CONSTRUCTOR
	
	/**
	 * Constructor
	 * 
	 * @param length     its amount of resources
	 */
	public ResourcesPool(int length){
		availableResources = new ArrayList<R>();
		givenResources = new ArrayList<R>();
		
		for(int i = 0;i < length;i++){
			R resource = this.createResoucre();
			availableResources.add(resource);
		}
	}
	
	//METHODS
	/**
	 * 
	 * @return the list with the available resources
	 */
	public List<R> getAvailableResources() {
		return availableResources;
	}

	/**
	 * 
	 * @return the list with the given rsources
	 */
	public List<R> getGivenResources() {
		return givenResources;
	}
	/**
	 * 
	 * @return a resource from the pool
	 * @throws NoSuchElementException if there is no resource available
	 */
	public R provideResource() throws NoSuchElementException{
		if(availableResources.size() == 0){
			throw new NoSuchElementException();
		}else{
			R res= availableResources.get(0);
			givenResources.add(res);
			availableResources.remove(res);
			return res;
		}	
	}
	
	/**
	 * 
	 * @param receivedResource the resource that will be returned to the poll
	 * @throws IllegalArgumentException if the receivedResource do not belong to the pool
	 */
	public void recoverResource(R receivedResource)throws IllegalArgumentException{
		if(givenResources.contains(receivedResource)){
			availableResources.add(receivedResource);
			givenResources.remove(receivedResource);
		}else{
			throw new IllegalArgumentException("Wrong resource Pool provider");
		}
	}
	/**
	 * 
	 * @return a new resource
	 */
	public abstract R createResoucre();
	
}
