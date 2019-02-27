package game.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import game.character.Monster;
import game.character.Player;
import game.room.Direction;
import game.room.Room;
import game.util.ListChoser;

public class MoveAction implements Action{

	/**
	 * @return true once map is not empty and all monsters have been killed
	 */
	@Override
	public boolean isPossible(Player player) {
		Room room=player.getCurrentRoom();
		Map<Direction,Room> dest=room.getNeighbors();
		List<Monster> monsters =player.getCurrentRoom().getMonsters();
		return !(dest.isEmpty())&& monsters.isEmpty();
	}
	/**
	 * change the current Room
	 */
	@Override
	public void execute(Player player) {
		Room room=player.getCurrentRoom();
		Map<Direction,Room> dest=room.getNeighbors();
		Set<Direction> setDirection=dest.keySet();
		List<Direction> listDirection=new ArrayList();
		listDirection.addAll(setDirection);
		Direction direction=ListChoser.SINGLETON.chose("Chose a direction", listDirection);
		Room roomUpdate=room.getDestination(direction);
		player.setCurrentRoom(roomUpdate);
		player.updateActions();
	}
	/**
	 * @return the string which represents the  action 
	 */
	public String toString() {
		return "Move Action";
	}
	
}
