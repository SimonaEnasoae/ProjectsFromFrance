package resources;

import static org.junit.Assert.*;

import org.junit.Test;

import mockClass.MockResource;

public class ResourcesTest {
	
	public Resources createResource() {
		return new MockResource();
	}
	@Test
	public void testDescription() {
		Resources resource = createResource();
		assertEquals(resource.toString(),"MockResource");
	}
}

