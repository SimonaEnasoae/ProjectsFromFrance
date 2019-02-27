package game.item;

import static org.junit.Assert.*;

import org.junit.Test;

import game.character.Player;

public class StrengthPotionTest extends ItemTest {

	public Item createItem() {
		return new StrengthPotion();
	}
	@Test
	public void testToString() {
		StrengthPotion strengthPotion = (StrengthPotion) createItem();
		assertEquals("Strength Potion",strengthPotion.toString());
	}
	@Test
	public void testEffect() {
		Player player1 = new Player(100,20,100);
		StrengthPotion strengthPotion = (StrengthPotion) createItem();
		strengthPotion.effect(player1);
		assertEquals(21,player1.getStrength());
	}

}
