package actions.scheduler;

import java.util.List;

import actions.Action;
/**
 * Class FairScheduler
 * 
 * @author Simona Enasoae, Marcel Fernadez de la Pena
 *
 */
public class FairScheduler extends Scheduler{
	//ATRIBUTES
	protected int index;
	
	//CONSTRUCTOR
	/**
	 * Constructor
	 * 
	 * @param actions the list of actions that need to be done
	 */
	public FairScheduler(List<Action> actions) {
		super(actions);
		index = 0;
	}
	
	/**
	 * Constructor
	 * 
	 */
	public FairScheduler() {
		index = 0;
	}
	
	/**
	 * @return the next action to be done 
	 */
	@Override
	public Action nextAction() {
		Action next = null;
		for(int i=index; i<this.getSchedulerActions().size() && next == null; i++) {
			if(schedulerActions.get(i).isFinished()) {
				schedulerActions.remove(i);
				i--;
			}else {
				index=i;
				next = schedulerActions.get(i);
			}
		}
		if(next == null) {
			for(int i=0; i<index && next == null; i++) {
				if(schedulerActions.get(i).isFinished()) {
					schedulerActions.remove(i);
					i--;
				}else {
					index=i;
					next = schedulerActions.get(i);
				}
			}
		}
		if(index == schedulerActions.size()-1) {
			index = 0;
		}
		else {
			index++;
		}
		return next;
	}
	
	/**
	 * 
	 * @return true if all the actions from the list are finished, false otherwise
	 */
	@Override
	public boolean StopCondition() {
		for(int i = 0; i< this.getSchedulerActions().size(); i ++) {
			if(schedulerActions.get(i).isFinished() == false) {
				return false;
			}
		}
		return true;
	}
	

}
