package pool;

import resources.Basket;
/**
 * Class BasketPool
 * 
 * @author Simona Enasoae, Fernandez de la Pena
 *
 */
public class BasketPool extends ResourcesPool<Basket> {
	//CONSTRUCTOR
	/**
	 * 
	 * @param length    length its amount of resources
	 */
	public BasketPool(int length) {
		super(length);
	}
	
	//METHODS
	/**
	 * @return a new Basket
	 */
	@Override
	public Basket createResoucre() {
		return new Basket();
	}

}
