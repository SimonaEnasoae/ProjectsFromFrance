package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.foreseeable.ForeseeableAction;
import mockClass.MockAction;

public class ForeseeableActionTest extends ActionTest{

	public ForeseeableAction createForeseeableAction(int n){
		return new ForeseeableAction(n);
	}
	public Action createAction(){
		return new ForeseeableAction(1);
	}

	@Test
	public void testMakeOneStep() {
		ForeseeableAction foreseeableAction = createForeseeableAction(2);
		foreseeableAction.doStep();
		assertEquals(foreseeableAction.getRemainingTime()+1, foreseeableAction.getTotalTime());
}

	@Test
	public void testStopConditionFalse() {
		ForeseeableAction foreseeableAction = createForeseeableAction(2);
		foreseeableAction.makeOneStep();
		assertFalse(foreseeableAction.StopCondition());
	}
	
	@Test
	public void testStopCondition() {
		ForeseeableAction foreseeableAction = createForeseeableAction(2);
		foreseeableAction.makeOneStep();
		foreseeableAction.makeOneStep();
		foreseeableAction.StopCondition();
	}

}
