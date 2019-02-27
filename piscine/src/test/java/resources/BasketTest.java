package resources;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasketTest extends ResourcesTest{
	
	public Resources createResource() {
		return new Basket();
	}
	
	@Test
	public void testDescription() {
		Resources resource = createResource();
		assertEquals(resource.toString(),"basket");
	}

}
