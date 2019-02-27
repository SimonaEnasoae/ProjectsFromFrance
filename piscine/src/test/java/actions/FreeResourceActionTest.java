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

public class FreeResourceActionTest {
	
	public ResourcesPool createResourcePool(int n){
		return new MockResourcesPool(n);		
	}
	public ResourceUser createResourceUser(){
		return new MockResourceUser();		
	}
	public FreeResourceAction createFreeResourceAction(int n){
		ResourcesPool<Resources> resourcePool = createResourcePool(n);
		ResourceUser <Resources> resourceUser = createResourceUser();
		return new FreeResourceAction(resourceUser, resourcePool);		
	}
	public TakeResourceAction createTakeResourceAction(ResourcesPool<Resources> resourcePool, ResourceUser <Resources> resourceUser){
		return new TakeResourceAction(resourceUser, resourcePool);		
	}
	
	@Test
	public void testMakeOneStepSuccess() {
		FreeResourceAction<Resources> freeResourceAction = createFreeResourceAction(2);
		ResourcesPool<Resources> resourcePool = freeResourceAction.getResourcePool();
		ResourceUser <Resources> resourceUser = freeResourceAction.getResourceUser();
		TakeResourceAction<Resources> takeResourceAction = createTakeResourceAction(resourcePool, resourceUser);
		takeResourceAction.makeOneStep();
		freeResourceAction.makeOneStep();
		assertNull(resourceUser.getResource());
		
	}
	
	@Test
	public void testMakeOneStepFailed() {
		ResourcesPool<Resources> resourcePool = createResourcePool(2);		
		FreeResourceAction<Resources> freeResourceAction = createFreeResourceAction(2);
		ResourceUser <Resources> resourceUser = freeResourceAction.getResourceUser();
		TakeResourceAction<Resources> takeResourceAction = createTakeResourceAction(resourcePool, resourceUser);

		takeResourceAction.makeOneStep();
		freeResourceAction.makeOneStep();
		assertNotNull(resourceUser.getResource());
	}
	@Test
	public void testStopConditionSuccess() {
		FreeResourceAction<Resources> freeResourceAction = createFreeResourceAction(2);
		ResourcesPool<Resources> resourcePool = freeResourceAction.getResourcePool();
		ResourceUser <Resources> resourceUser = freeResourceAction.getResourceUser();
		TakeResourceAction<Resources> takeResourceAction = createTakeResourceAction(resourcePool, resourceUser);
		takeResourceAction.makeOneStep();
		freeResourceAction.makeOneStep();
		assertTrue(freeResourceAction.StopCondition());
	}
	@Test
	public void testStopConditionFailed() {
		ResourcesPool<Resources> resourcePool = createResourcePool(2);		
		FreeResourceAction<Resources> freeResourceAction = createFreeResourceAction(2);
		ResourceUser <Resources> resourceUser = freeResourceAction.getResourceUser();
		TakeResourceAction<Resources> takeResourceAction = createTakeResourceAction(resourcePool, resourceUser);
		
		takeResourceAction.makeOneStep();
		freeResourceAction.makeOneStep();
		assertFalse(freeResourceAction.StopCondition());	
		}
	

}
