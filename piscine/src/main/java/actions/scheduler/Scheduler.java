package actions.scheduler;

import java.util.ArrayList;
import java.util.List;

import actions.Action;
import actions.ActionState;
import actions.exceptions.ActionFinishedException;
import actions.exceptions.SchedulerStartedException;
/**
 * Class Scheduler
 * 
 * @author Simona Enasoae, MarcelFernandez de la Pena
 *
 */
public abstract class Scheduler extends Action{
	//ATRIBUTE
	protected  List<Action> schedulerActions;
	
	//CONSTRUCTORS
	/**
	 * 
	 * @param schedulerActions list of actions to be done
	 */
	public Scheduler(List<Action> schedulerActions) {
		this.schedulerActions = schedulerActions;
	}
	/**
	 * 
	 */
	public Scheduler() {
		schedulerActions = new ArrayList<Action>();		
	}
	
	/**
	 * 
	 * @return list of scheduler Actions 
	 */
	public List<Action> getSchedulerActions(){
		return this.schedulerActions;
	}
	
	/**
	 * 
	 * @param subAction						subAction that is about to be added to the list of actions
	 * @throws ActionFinishedException		if the action is already finished
	 * @throws SchedulerStartedException	when the scheduler is already in progress 
	 */
	public void addAction(Action subAction) throws ActionFinishedException, SchedulerStartedException{
		if(this.state != ActionState.READY)
			throw new SchedulerStartedException("Cannot add when scheduler is in progress or has finished");
		if(subAction.isFinished())
			throw new ActionFinishedException("Cannot add when scheduler is in progress or has finished");
		else {
			this.schedulerActions.add(subAction);
		}
	}
	
	/**
	 * 
	 * @param schedulerActions list of actions about to be set
	 */
	public void setSchedulerActions(List<Action> schedulerActions) {
		this.schedulerActions = schedulerActions;
	}
	
	/**
	 * make only one step
	 */
	@Override
	public void makeOneStep() {
		Action nextActions = nextAction();
		System.out.print(nextActions);
		nextActions.doStep();

	}
	/**
	 * 
	 * @return the next action to be done
	 */
	public abstract Action nextAction();

}
