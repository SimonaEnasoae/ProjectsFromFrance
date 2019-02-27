package game.item;

import game.character.Player;

public class HPotion implements Item{
		
	public HPotion() {
		
	}
	/**
	 * @return a string which represent the name  Item
	 */
	public String toString() {
		return "Health Potion";
	}
	/**
	 * apply the effect of item
	 * @param p type Player
	 */
	public void effect(Player p) {
		p.setLife(p.getLife() + 1);
	}

}
