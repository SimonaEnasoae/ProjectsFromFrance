package game.item;

import static org.junit.Assert.*;

import org.junit.Test;

import game.character.Player;

public class GoldPurseTest extends ItemTest{

	public GoldPurse createItem(){
		return new GoldPurse(5);
	}
	@Test
	public void testSetAmount() {
		GoldPurse goldPurse = (GoldPurse) createItem();
		goldPurse.setAmount(5);
		assertEquals(5, goldPurse.getAmount());
	}

	@Test
	public void testGetAmount() {
		GoldPurse goldPurse = (GoldPurse) createItem();
		goldPurse.setAmount(3);
		assertEquals(3, goldPurse.getAmount());
		
	}

	@Test
	public void testToString() {
		GoldPurse goldPurse = (GoldPurse) createItem();
		assertEquals("Gold Purse", goldPurse.toString());
	}

	@Test
	public void testEffect() {
		GoldPurse goldPurse = (GoldPurse) createItem();
		Player player = new Player(20,40,60);
		goldPurse.setAmount(15);
		goldPurse.effect(player);
		assertEquals(75,player.getGold());
		
	}

}
