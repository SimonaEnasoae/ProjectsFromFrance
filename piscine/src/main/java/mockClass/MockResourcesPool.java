package mockClass;

import pool.ResourcesPool;

public class MockResourcesPool extends ResourcesPool<MockResource>{

	public MockResourcesPool(int length) {
		super(length);
		
	}

	@Override
	public MockResource createResoucre() {
		return new MockResource();
	}
	
}
