package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.take.TakeBasketAction;
import actions.take.TakeCubicleAction;
import actions.take.TakeResourceAction;
import pool.BasketPool;
import pool.CubiclePool;
import pool.ResourcesPool;
import resources.Basket;
import resources.Cubicle;
import resources.ResourceUser;

public class TakeCubicleActionTest extends TakeResourceActionTest{

	public ResourcesPool createResourcePool(int n){
		return new CubiclePool(n);		
	}
	public ResourceUser createResourceUser(){
		return new ResourceUser<Cubicle>();		
	}
	public TakeResourceAction createTakeResourceAction(int n){
		ResourcesPool<Cubicle> resourcePool = createResourcePool(n);
		ResourceUser<Cubicle> resourceUser = createResourceUser();
		return new TakeCubicleAction(resourceUser, resourcePool);		
	}

}
