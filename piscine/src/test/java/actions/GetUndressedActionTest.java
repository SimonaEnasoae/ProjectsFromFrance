package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.foreseeable.ForeseeableAction;
import actions.foreseeable.GetUndressedAction;

public class GetUndressedActionTest extends ForeseeableActionTest {

	public ForeseeableAction createAction(int n){
		return new GetUndressedAction(n);
	}

}
