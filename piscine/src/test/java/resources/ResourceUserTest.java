package resources;

import static org.junit.Assert.*;

import org.junit.Test;

import mockClass.MockResource;
import mockClass.MockResourceUser;

public class ResourceUserTest {
	
	@Test
	public void testGetResource() {
		MockResource resource = new MockResource();
		MockResourceUser resourceUser = new MockResourceUser(resource);
		assertSame(resource, resourceUser.getResource());
	}

	@Test
	public void testSetResource() {
		MockResource resource = new MockResource();
		MockResource resource2 = new MockResource();
		MockResourceUser resourceUser = new MockResourceUser(resource);
		resourceUser.setResource(resource2);
		assertSame(resource2, resourceUser.getResource());
		}

	@Test
	public void testResetResource() {
		MockResource resource = new MockResource();
		MockResourceUser resourceUser = new MockResourceUser(resource);
		assertSame(resource, resourceUser.getResource());
		resourceUser.resetResource();
		assertNull(resourceUser.getResource());
		
	}

}
