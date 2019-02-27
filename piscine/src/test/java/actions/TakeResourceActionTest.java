package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.free.FreeResourceAction;
import actions.take.TakeResourceAction;
import mockClass.MockResource;
import mockClass.MockResourceUser;
import mockClass.MockResourcesPool;
import pool.ResourcesPool;
import resources.ResourceUser;
import resources.Resources;

public class TakeResourceActionTest{
	public ResourcesPool createResourcePool(int n){
		return new MockResourcesPool(n);		
	}
	public ResourceUser createResourceUser(){
		return new MockResourceUser();		
	}
	public TakeResourceAction createTakeResourceAction(ResourcesPool<Resources> resourcePool,ResourceUser <Resources> resourceUser){
		return new TakeResourceAction(resourceUser, resourcePool);		
	}
	
	@Test
	public void testMakeOneStepSuccess() {
		ResourcesPool<Resources> resourcePool = createResourcePool(2);
		ResourceUser resourceUser = createResourceUser();
		TakeResourceAction<Resources> takeResourceAction = createTakeResourceAction(resourcePool, resourceUser);
		takeResourceAction.makeOneStep();
		assertNotNull(resourceUser.getResource());
	}
	@Test
	public void testMakeOneStepFailed() {
		ResourcesPool<Resources> resourcePool = createResourcePool(0);
		ResourceUser resourceUser = createResourceUser();
		TakeResourceAction<Resources> takeResourceAction = createTakeResourceAction(resourcePool, resourceUser);
		takeResourceAction.makeOneStep();
		assertNull(resourceUser.getResource());
	}

	@Test
	public void testStopConditionSuccess() {
		ResourcesPool<Resources> resourcePool = createResourcePool(2);
		ResourceUser resourceUser = createResourceUser();
		TakeResourceAction<Resources> takeResourceAction = createTakeResourceAction(resourcePool, resourceUser);
		takeResourceAction.makeOneStep();
		assertTrue(takeResourceAction.StopCondition());
	}
	@Test
	public void testStopConditionFailed() {
		ResourcesPool<Resources> resourcePool = createResourcePool(0);
		ResourceUser resourceUser = createResourceUser();
		TakeResourceAction<Resources> takeResourceAction = createTakeResourceAction(resourcePool, resourceUser);
		takeResourceAction.makeOneStep();
		assertFalse(takeResourceAction.StopCondition());	
		}
}
