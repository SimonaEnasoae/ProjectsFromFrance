package pool;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import mockClass.MockResource;
import mockClass.MockResourcesPool;
import resources.Resources;

public class ResourcesPoolTest {
	
	public ResourcesPool createResourcePool(int n) {
		return new MockResourcesPool(n);
	}
	@Test
	public void testProvideResourceSucced() {
		ResourcesPool resourcePool =  createResourcePool(3);
		Resources resource = resourcePool.provideResource();
		assertFalse(resourcePool.getAvailableResources().contains(resource));
		assertTrue(resourcePool.getGivenResources().contains(resource));
		
	}
	@Test (expected = NoSuchElementException.class)
	public void testProvideResrouceThrowNoSuchElementException(){
		ResourcesPool resourcePool =  createResourcePool(0);
		resourcePool.provideResource();
	}
	
	@Test 
	public void testRecoverResourceSucced(){
		ResourcesPool resourcePool =  createResourcePool(3);
		Resources resource = resourcePool.provideResource();
		resourcePool.recoverResource(resource);
		assertTrue(resourcePool.getAvailableResources().contains(resource));
		assertFalse(resourcePool.getGivenResources().contains(resource));	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRecouverResourceThrowIllegalArgumentException(){
		ResourcesPool resourcePool =  createResourcePool(2);
		ResourcesPool resourcePool2 =  createResourcePool(2);
		Resources resource1 = resourcePool.provideResource();
		resourcePool2.recoverResource(resource1);

	}
}
