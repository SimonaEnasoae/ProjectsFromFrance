package pool;

import resources.Cubicle;
/**
 * Class CubiclePool
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public class CubiclePool extends ResourcesPool<Cubicle> {
	//CONSTRUCTOR
	/**
	 * 
	 * @param length its amount of resources
	 */
	public CubiclePool(int length) {
		super(length);
	}
	
	//METHODS
	/**
	 * @return a new Cubicle
	 */
	@Override
	public Cubicle createResoucre() {
		return new Cubicle();
	}

}
