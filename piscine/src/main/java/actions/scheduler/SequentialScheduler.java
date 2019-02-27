package actions.scheduler;

import java.util.List;

import actions.Action;
import actions.ActionState;
import actions.exceptions.ActionFinishedException;
/**
 * Class SequentialScheduler
 * 
 * @author Simona Enasoae, Marcel Fernadez de la Pena
 *
 */
public class SequentialScheduler extends Scheduler{
	//CONSTRUCTORS
	/**
	 * Constructor
	 * 
	 * @param actions the list of actions that need to be done
	 */
	public SequentialScheduler(List<Action> actions) {
		super(actions);
	}
	/**
	 * Constructor
	 */
	public SequentialScheduler() {
		
	}
	
	/**
	 * @return the next action to be done 
	 */
	@Override
	public Action nextAction() {
		if(schedulerActions.get(0).isFinished()) {
			schedulerActions.remove(0);
		}
		return schedulerActions.get(0);
		
	}
	
	/**
	 * 
	 * @return true if there is only one action in list of actions and it is finished, false otherwise
	 */
	@Override
	public boolean StopCondition() {
		boolean stop = (this.state == ActionState.IN_PROGRESS && this.schedulerActions.get(0).isFinished()&& this.schedulerActions.size() == 1);
		return stop;
	}

}
