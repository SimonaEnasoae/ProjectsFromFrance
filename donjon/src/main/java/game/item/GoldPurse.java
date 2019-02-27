package game.item;

import game.character.Player;

public class GoldPurse implements Item{
	private int amount;
	
	public GoldPurse() {
		
	}
	/**
	 * @param receivedGold type Integer
	 */
	public GoldPurse(int receivedGold) {
		this.amount=receivedGold;
	}
	/**
	 * set the amount of GoldPurse
	 * @param amount1 type Integer
	 */
	public void setAmount (int amount1){
		this.amount=amount1;
	}
	/**
	 * 
	 * @return the amount - Integer
	 */
	public int getAmount(){
		return amount;
	}
	/**
	 * @return a string which represent the name Item
	 */
	public String toString() {
		return "Gold Purse";
	}
	/**
	 * apply the effect of item
	 * @param p type Player
	 */
	public void effect(Player p) {
		p.setGold(p.getGold() + this.getAmount());
	}
}
