package actions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import actions.scheduler.Scheduler;
import actions.scheduler.SequentialScheduler;


public class SequentialSchedulerTest extends SchedulerTest {

	
	@Override
	public Scheduler createScheduler(int n) {
		List<Action> actions = createActionsList(n);
		return new SequentialScheduler(actions);
	}
	
	@Test
	public void testNextAction() {
		Scheduler scheduler = createScheduler(2);
		scheduler.doStep();
		assertSame(scheduler.getSchedulerActions().get(1),scheduler.nextAction());
	}

	@Test
	public void testMakeOneStep() {
		Scheduler scheduler = createScheduler(2);
		int length = scheduler.getSchedulerActions().size();
		scheduler.makeOneStep();
		scheduler.makeOneStep();
		assertEquals(length-1,scheduler.getSchedulerActions().size());
	}
	@Test
	public void testStopCondition() {
		Scheduler scheduler = createScheduler(2);
		scheduler.doStep();
		assertFalse(scheduler.StopCondition());
		scheduler.makeOneStep();
		assertTrue(scheduler.StopCondition());

	}

}
