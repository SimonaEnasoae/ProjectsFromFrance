package actions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import actions.scheduler.Scheduler;
import actions.scheduler.SequentialScheduler;
import pool.BasketPool;
import pool.CubiclePool;

public class SwimmerTest extends SequentialSchedulerTest {

	@Override
	public Scheduler createScheduler(int n) {
		BasketPool baskets = new BasketPool(n);
		CubiclePool cubicles = new CubiclePool(n);
		return new Swimmer("Marcel", baskets, cubicles, 1, 2, 1);
	}
	@Test
	public void testStopCondition() {
		Swimmer scheduler = (Swimmer) createScheduler(2);
		scheduler.doStep();
		int nbSteps = 0;
		while(!scheduler.isFinished()) {
			nbSteps++;
			scheduler.doStep();
		}
		
		assertEquals(9,nbSteps);
	}

}
