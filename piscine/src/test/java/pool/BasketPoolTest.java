package pool;

import static org.junit.Assert.*;

import org.junit.Test;

import mockClass.MockResourcesPool;

public class BasketPoolTest extends ResourcesPoolTest{
	public ResourcesPool createResourcePool(int n) {
		return new BasketPool(n);
	}
}
