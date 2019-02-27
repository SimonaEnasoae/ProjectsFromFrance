package mockClass;

import actions.Action;
import actions.ActionState;
import actions.exceptions.ActionFinishedException;

public class MockAction extends Action{
	public boolean checkStep = false;
	@Override
	public void makeOneStep() throws ActionFinishedException {
		checkStep = true;
	}

	@Override
	public boolean StopCondition() {
		return true;
	}
	
}
