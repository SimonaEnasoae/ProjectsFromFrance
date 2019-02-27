package game.item;

import java.util.Random;

import game.character.Player;

public class OneArmedBandit implements Item{
	
	protected int nbGold = 5;
	public OneArmedBandit() {	
	}
	/**
	 * @return a string which represent the name Item
	 */
	public String toString() {
		return "One-Armed Bandit";
	}
	/**
	 * 
	 * @return a random number from 1 to 4
	 */
	public int getRandom(){
		Random ran = new Random();
		return ran.nextInt(3) +1;
	}
	/**
	 * apply the effect of item
	 * @param p type Player
	 */
	public void effect(Player p) {
		int playerGold = p.getGold();
		if(playerGold > nbGold){
			int itemNb = this.getRandom();
			switch(itemNb){
			case 1:
				System.out.println("You have received a gold Purse: gold +1");
				p.setGold(p.getGold()+ 1);
				break;
			case 2:
				System.out.println("You have received a Health Potion: health +1");
				p.setLife(p.getLife()+1);
				break;
			case 3:
				System.out.println("You have received a Strength Potion: strength +1");
				p.setStrength(p.getStrength()+1);
				break;
			default:
				System.out.println("Game error");
				break;
			}
		}
	}
}
