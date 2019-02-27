package game.item;

import game.character.Player;

public class StrengthPotion implements Item{
	
	public StrengthPotion() {
	}
	/**
	 * @return a string which represent the name Item
	 */
	public String toString() {
		return "Strength Potion";
	}
	/**
	 * apply the effect of item
	 * @param p type Player
	 */
	public void effect(Player p) {
		p.setStrength(p.getStrength() + 1);
	}


}
