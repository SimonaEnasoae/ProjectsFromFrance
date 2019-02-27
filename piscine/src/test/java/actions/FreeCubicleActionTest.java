package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.free.FreeCubicleAction;
import actions.free.FreeResourceAction;
import mockClass.MockResourceUser;
import mockClass.MockResourcesPool;
import pool.CubiclePool;
import pool.ResourcesPool;
import resources.Cubicle;
import resources.ResourceUser;
import resources.Resources;

public class FreeCubicleActionTest extends FreeResourceActionTest {

	public ResourcesPool createResourcePool(int n){
		return new CubiclePool(n);		
	}
	public ResourceUser createResourceUser(){
		return new ResourceUser<Cubicle>();		
	}
	public FreeResourceAction createFreeResourceAction(int n){
		ResourcesPool<Cubicle> resourcePool = createResourcePool(n);
		ResourceUser <Cubicle> resourceUser = createResourceUser();
		return new FreeCubicleAction(resourceUser, resourcePool);			
	}

}
