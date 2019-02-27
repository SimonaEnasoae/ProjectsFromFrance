package pool;

import static org.junit.Assert.*;

import org.junit.Test;

import mockClass.MockResourcesPool;

public class CubiclePoolTest extends ResourcesPoolTest {

	public ResourcesPool createResourcePool(int n) {
		return new CubiclePool(n);
	}

}
