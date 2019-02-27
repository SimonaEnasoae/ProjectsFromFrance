package game.item;
import static org.junit.Assert.*;

import org.junit.Test;

import game.character.Player;

public class ItemTest {

	private class MockItem implements Item{
		public boolean checkEffect=false;
		
		public MockItem( ){
		}
		
	
		@Override
		public void effect(Player player1) {
			checkEffect=true;
		}
	}
	public Item createItem() {
		return new MockItem();
	}
	
	@Test
	public void testEffect() {
		MockItem mockItem = (MockItem) createItem();
		Player player = new Player(100,20,100);
		mockItem.effect(player);
		assertEquals(true,mockItem.checkEffect);
	}
	

}
