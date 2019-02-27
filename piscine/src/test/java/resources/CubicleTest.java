package resources;

import static org.junit.Assert.*;

import org.junit.Test;

public class CubicleTest extends ResourcesTest{
	
	public Resources createResource() {
		return new Cubicle();
	}
	
	@Test
	public void testDescription() {
		Resources resource = createResource();
		assertEquals(resource.toString(),"cubicle");
	}

}