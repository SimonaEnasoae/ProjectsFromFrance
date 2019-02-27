package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.Action;
import actions.ActionState;
import actions.exceptions.ActionFinishedException;
import mockClass.MockAction;

public class ActionTest{

	public Action createAction(){
		return new MockAction();
	}

	@Test
	public void testGetState() {
		Action action = createAction();
		assertEquals(ActionState.READY,action.getState());
	}

	@Test
	public void testIsFinished() {
		Action action = createAction();
		assertEquals(false,action.isFinished());
	}

	@Test (expected = ActionFinishedException.class)
	public void testDoStepThrowActionFinishedException()  {
		Action action = createAction();
		action.doStep();
		action.doStep();
		
	}
	@Test
	public void testDoStepSuccess() {
		Action action = createAction();
		action.doStep();
		assertEquals(ActionState.FINISHED,action.getState());
	}

	@Test
	public void testMakeOneStep() {
		MockAction action = (MockAction) createAction();
		action.makeOneStep();
		assertTrue(action.checkStep);
	}

	@Test
	public void testStopCondition() {
		MockAction action = (MockAction) createAction();
		assertTrue(action.StopCondition());
	}

}
