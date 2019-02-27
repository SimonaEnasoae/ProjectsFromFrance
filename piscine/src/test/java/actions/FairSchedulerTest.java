package actions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import actions.Action;
import actions.scheduler.FairScheduler;
import actions.scheduler.Scheduler;
import mockClass.MockActionTwoSteps;

public class FairSchedulerTest extends SchedulerTest{

	@Override
	public Scheduler createScheduler(int n) {
		List<Action> actions = createActionsList(n);
		MockActionTwoSteps mockAction2Steps = new MockActionTwoSteps(2);
		MockActionTwoSteps mockAction2Steps2 = new MockActionTwoSteps(2);
		actions.add(0, mockAction2Steps);
		actions.add(0, mockAction2Steps2);
		return new FairScheduler(actions);
	}
	
	@Test
	public void testStopCondition() {
		FairScheduler fairScheduler = (FairScheduler) createScheduler(2);
		fairScheduler.makeOneStep();
		assertFalse(fairScheduler.StopCondition());
		fairScheduler.makeOneStep();
		fairScheduler.makeOneStep();
		fairScheduler.makeOneStep();
		fairScheduler.makeOneStep();
		fairScheduler.makeOneStep();
		assertTrue(fairScheduler.StopCondition());
	}

	@Test
	public void testNextAction() {
		FairScheduler fairScheduler = (FairScheduler) createScheduler(2);
		fairScheduler.doStep();
		fairScheduler.doStep();
		assertSame(fairScheduler.nextAction(),fairScheduler.getSchedulerActions().get(2));
	}
	
}
