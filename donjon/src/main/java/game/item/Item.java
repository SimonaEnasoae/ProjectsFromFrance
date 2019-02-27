package game.item;

import game.character.Player;

public interface Item {
	/**
	 * apply the effect of an item
	 * @param p type Player
	 */
	void effect(Player p);
}
