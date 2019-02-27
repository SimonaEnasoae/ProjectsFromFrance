package actions;

import actions.exceptions.ActionFinishedException;
/**
 * Abstract class Action
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena
 *
 */
public abstract class Action {
	//ATRIBUTES
	protected ActionState state;
	
	//CONSTRUCTOR
	/**
	 * The constructor which initialize the action state as ready
	 */
	public Action() {
		this.state = ActionState.READY;
	}
	
	//METHODS
	/**
	 * 
	 * @return the action state
	 */
	public ActionState getState() {
		return state;
	}
	
	/**
	 * 
	 * @return true if the state is FINISHED, false otherwise
	 */
	public boolean isFinished() {
		if (this.getState() == ActionState.FINISHED)
			return true;
		return false;
	}
	
	/**
	 * Do a step and update the action state.
	 * @throws ActionFinishedException if the action is already finished
	 */
	public void doStep() throws ActionFinishedException{
		if(this.state  == ActionState.FINISHED){
			throw new ActionFinishedException("Cannot doStep when finished");
		}
		if(this.state == ActionState.READY){
			this.state = ActionState.IN_PROGRESS;
		}
		this.makeOneStep();
		boolean stop = this.StopCondition();
		if(stop){
			this.state = ActionState.FINISHED;
		}
	}
	
	/**
	 * Make only one step
	 * @throws ActionFinishedException if the action is already finished
	 */
	public abstract void makeOneStep() throws ActionFinishedException;
	
	/**
	 * 
	 * @return true if there is no more step to do for the action, false otherwise
	 */
	public abstract boolean StopCondition();
	
}
