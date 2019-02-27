package actions.foreseeable;

import actions.Action;

public class ForeseeableAction extends Action{
	//ATRIBUTES
	protected int totalTime;
	protected int remainingTime;
	
	//CONSTRUCTOR
	/**
	 * The constructor initializes totalTime and remainigTime with the number of steps.
	 * 
	 * @param nbSteps to complete the action
	 */
	public ForeseeableAction(int nbSteps) {
		this.totalTime = nbSteps;
		this.remainingTime = nbSteps;
	}
	
	/**
	 * Every time makeOneStep is called remaining time decreases.
	 */
	@Override
	public void makeOneStep() {
		this.remainingTime--;
	}
	
	/**
	 * 
	 * @return true if remaining time is 0, which means action has been completed, false otherwise
	 */
	public boolean StopCondition() {	
		return (remainingTime == 0);		
	}
	
	/**
	 * 
	 * @return totalTime of the action
	 */
	public int getTotalTime() {
		return totalTime;
	}
	
	//GETTERS AND SETTERS
	/**
	 * 
	 * @param totalTime received is set as totalTime
	 */
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
	/**
	 * 
	 * @return remaining time to complete the action 
	 */
	public int getRemainingTime() {
		return remainingTime;
	}
	
	/**
	 * 
	 * @param remainingTime received is set as remainingTime
	 */
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}

	/**
	 * @return String with remaining and total time for the action
	 */
	public String toString() {
		return "("+(totalTime-remainingTime+1)+"/"+totalTime+")\n";
	}

}
