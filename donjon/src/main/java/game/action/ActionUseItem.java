package game.action;

import java.util.List;

import game.character.Player;
import game.item.Item;
import game.room.Room;
import game.util.ListChoser;

public class ActionUseItem implements Action {

	public ActionUseItem() {
	}
	/**
	 * @return true if there are still some items left in the room, false otherwise
	 */
	@Override
	public boolean isPossible(Player player) {
		return !(player.getCurrentRoom().getItems().isEmpty());
	}
	/**
	 * choose an item from the room and applied its effect
	 */
	@Override
	public void execute(Player player) {
		List<Item> items=player.getCurrentRoom().getItems();
		Item item=ListChoser.SINGLETON.chose("which item?",items);
		item.effect(player);
		items.remove(item);
		Room room=player.getCurrentRoom();
		room.setListItems(items);
		player.setCurrentRoom(room);
	}
	/**
	 * @return the string which represents the  action 
	 */
	public String toString() {
		return "Use Item Action" ;
	}
	
}
