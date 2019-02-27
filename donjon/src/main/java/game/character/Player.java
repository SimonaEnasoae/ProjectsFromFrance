package game.character;

import java.util.ArrayList;
import java.util.List;

import game.action.Action;
import game.action.ActionUseItem;
import game.action.AttackAction;
import game.action.LookAction;
import game.action.MoveAction;
import game.room.Room;
import game.util.ListChoser;


public class Player extends GameCharacter{
	protected List<Action> actions = new ArrayList<Action>();
	
	public Player() {
		
	}
	/**
	 * 
	 * @param life Integer
	 * @param strength  Integer
	 * @param gold   Integer
	 */
	public Player(int life,int strength,int gold) {
		super(life,strength,gold);
	}
	/**
	 * 
	 * @param life  Integer
	 * @param strength  Integer
	 * @param gold   Integer
	 * @param currentRoom  Integer
	 */
	public Player(int life,int strength,int gold,Room currentRoom) {
		super(life,strength,gold,currentRoom);
	}
	/**
	 * 
	 * @return a list with possible actions for the player
	 */
	public List<Action> getActions() {
		return actions;
	}
	/**
	 * set the actions of a player
	 * @param actions List of actions
	 */
	public void setActions(List<Action> actions) {
		this.actions=actions;
	}
	/**
	 * set the list of actions in the currebt room
	 */
	public void updateActions() {
		List<Action> updateActions=new ArrayList();
		Action attackAction=new AttackAction();
		Action moveAction= new MoveAction();
		Action useItem= new ActionUseItem();
		Action lookAction= new LookAction();
		updateActions.add(lookAction);
		if(attackAction.isPossible(this)){
			updateActions.add(attackAction);
		}
		if(moveAction.isPossible(this)) {
			updateActions.add(moveAction);
		}
		if(useItem.isPossible(this)) {
			updateActions.add(useItem);
		}
		this.setActions(updateActions);
	}
	/**
	 * the player chose an action  and execute it
	 */
	public void act() {
		List<Action> actions=this.getActions();
		Action action=ListChoser.SINGLETON.chose("What actions?", actions);
		action.execute(this);
	}
	/**
	 * 
	 */
	@Override
	public void die() {
		
	}
	/**
	 * @return a string which represents the player
	 */
	@Override
	public String toString() {
		return "Player  life=" + life + ", strength=" + strength + ", gold=" + gold + " .";
	}
}