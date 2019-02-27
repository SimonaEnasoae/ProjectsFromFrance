package actions;

import static org.junit.Assert.*;

import actions.Action;
import actions.exceptions.ActionFinishedException;
import actions.exceptions.SchedulerStartedException;
import actions.scheduler.Scheduler;
import mockClass.MockAction;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public abstract class SchedulerTest {

	public Action createAction() {
		return new MockAction();
	}
	public List<Action> createActionsList(int n) {
		List<Action> actions = new ArrayList<Action>();
		for(int i = 0; i < n; i++) {
			Action action = createAction();
			actions.add(action);
		}
		return actions;
	}
	
	public abstract Scheduler createScheduler(int n);
	


	@Test
	public void testAddAction() throws ActionFinishedException, SchedulerStartedException {
		Scheduler scheduler = createScheduler(2);
		Action newAction = createAction();
		int length = scheduler.getSchedulerActions().size();
		scheduler.addAction(newAction);
		assertEquals(length+1, scheduler.getSchedulerActions().size());
	}
	
	@Test
	public void testSetSchedulerActions() {
		Scheduler scheduler = createScheduler(2);
		List<Action> actions = createActionsList(2);
		scheduler.setSchedulerActions(actions);
		assertSame(actions, scheduler.getSchedulerActions());
	}

}
