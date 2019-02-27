package meniu;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.Swimmer;
import actions.exceptions.ActionFinishedException;
import actions.exceptions.SchedulerStartedException;
import actions.scheduler.FairScheduler;
import menu.SwimmingPool;
import pool.BasketPool;
import pool.CubiclePool;

public class SwimmingPoolTest {

	@Test
	public void testExecute() {
		BasketPool baskets = new BasketPool(6);
	    CubiclePool cubicles = new CubiclePool(3);
		FairScheduler s = new FairScheduler();
		try {
			s.addAction(new Swimmer("Camille", baskets, cubicles, 6,4,8));
			s.addAction(new Swimmer("Lois", baskets, cubicles, 2,10,4));
			s.addAction(new Swimmer("Mae", baskets, cubicles, 10,18,10));
			s.addAction(new Swimmer("Ange", baskets, cubicles, 3,7,5));
			s.addAction(new Swimmer("Louison", baskets, cubicles, 18,3,3));
			s.addAction(new Swimmer("Charlie", baskets, cubicles, 3,6,10));
			s.addAction(new Swimmer("Alexis", baskets, cubicles, 6,5,7));
			SwimmingPool swimmingPool = new SwimmingPool(baskets, cubicles, s);
			assertEquals(242, swimmingPool.execute());
			
		} catch (ActionFinishedException | SchedulerStartedException e) {
		}
  
		
	}

}
