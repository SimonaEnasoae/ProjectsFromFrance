package game.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import game.character.Player;
import game.room.Direction;
import game.room.Room;
import game.util.ListChoser;

public class LookAction implements Action{
	/**
	 * @return true always 
	 */
	@Override
	public boolean isPossible(Player player) {
		return true;
	}
	/**
	 * show the details of the current Room : list of monsters, list of items and the number of exits.
	 */
	@Override
	public void execute(Player player) {
		Room r=player.getCurrentRoom();
		System.out.println("Monstres: ");
		ListChoser.showMeniu(r.getMonsters());
		System.out.println("Items: ");
		ListChoser.showMeniu(r.getItems());
		
		Map<Direction,Room> rooms = player.getCurrentRoom().getNeighbors();
		Set<Direction> dir = rooms.keySet();
		List<Direction> directions = new ArrayList<Direction>();
		directions.addAll(dir);
		int nbExit = 0;
		for(int x=0; x< dir.size(); x++) {
				Direction d = directions.get(x);
				if(rooms.get(d).isExit()) {
					nbExit++;
				}
		}
		System.out.println("There are "+nbExit+" exits next to this room.");
	}
	/**
	 * @return  the string which represents the  action  
	 */
	public String toString() {
		return "Look Action" ;
	}

}
