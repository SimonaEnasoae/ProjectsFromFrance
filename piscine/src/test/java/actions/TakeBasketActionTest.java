package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.take.TakeBasketAction;
import actions.take.TakeResourceAction;
import mockClass.MockResourceUser;
import mockClass.MockResourcesPool;
import pool.BasketPool;
import pool.ResourcesPool;
import resources.Basket;
import resources.ResourceUser;
import resources.Resources;

public class TakeBasketActionTest extends TakeResourceActionTest{

	public ResourcesPool createResourcePool(int n){
		return new BasketPool(n);		
	}
	public ResourceUser createResourceUser(){
		return new ResourceUser<Basket>();		
	}
	public TakeResourceAction createTakeResourceAction(int n){
		ResourcesPool<Basket> resourcePool = createResourcePool(n);
		ResourceUser<Basket> resourceUser = createResourceUser();
		return new TakeBasketAction(resourceUser, resourcePool);		
	}

}
