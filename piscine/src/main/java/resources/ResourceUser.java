package resources;
/**
 * 
 * @author Enasoae Simona, Fernandez Marcel
 *
 * @param <R> the resource type for the user
 */
public class ResourceUser <R extends Resources>{
	
	//ATRIBUTES
	protected R resource = null;
	
	//CONSTRUCTORS
	public ResourceUser() {}
	
	/**
	 * 
	 * @param resource used to set resource
	 */
	public ResourceUser(R resource) {
		this.resource = resource;
	}
	
	/**
	 * 
	 * @return the user's resource, whether basket or cubicle
	 */
	public R getResource() {
		return resource;
	}
	
	/**
	 * 
	 * @param resource set resource
	 */
	public void setResource(R resource) {
		this.resource = resource;
	}
	
	/**
	 * Resets the resource.
	 */
	public void resetResource() {
		this.resource = null;
	}
}
