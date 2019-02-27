package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.foreseeable.ForeseeableAction;
import actions.foreseeable.SwimmingAction;

public class SwimmingActionTest extends ForeseeableActionTest{

	public ForeseeableAction createAction(int n){
		return new SwimmingAction(n);
	}

}
