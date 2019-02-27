package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.free.FreeBasketAction;
import actions.free.FreeResourceAction;
import pool.BasketPool;
import pool.CubiclePool;
import pool.ResourcesPool;
import resources.Basket;
import resources.Cubicle;
import resources.ResourceUser;

public class FreeBasketActionTest extends FreeResourceActionTest{

	public ResourcesPool createResourcePool(int n){
		return new BasketPool(n);		
	}
	public ResourceUser createResourceUser(){
		return new ResourceUser<Basket>();		
	}
	public FreeResourceAction createFreeResourceAction(int n){
		ResourcesPool<Basket> resourcePool = createResourcePool(n);
		ResourceUser <Basket> resourceUser = createResourceUser();
		return new FreeBasketAction(resourceUser, resourcePool);			
	}

}
