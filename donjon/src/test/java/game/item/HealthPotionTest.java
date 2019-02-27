package game.item;

import static org.junit.Assert.*;

import org.junit.Test;

import game.character.Player;

public class HealthPotionTest {

	public Item createItem(){
		return new HPotion();
	}
	@Test
	public void testToString(){
		HPotion healthPotion = (HPotion) createItem();
		assertEquals("Health Potion", healthPotion.toString());
	}
	@Test
	public void testHealthPotionEffect() {
		Player player1 = new Player(10,20,30);
		HPotion hPotion = new HPotion();
		
		hPotion.effect(player1);
		assertEquals(11,player1.getLife());
	}

}
