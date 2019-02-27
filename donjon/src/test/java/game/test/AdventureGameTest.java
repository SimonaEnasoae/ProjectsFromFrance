package game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.character.Player;
import game.room.Room;

public class AdventureGameTest {

	@Test
	public void testIsFinished() {
		Player player =new Player(-5,20,100);
		AdventureGame adG= new AdventureGame();
		adG.setPlayer(player);
		assertFalse(adG.isFinished());
	}

	@Test
	public void testGetCurrentRoom() {
		Room room = new Room();
		AdventureGame adG= new AdventureGame(room);
		assertEquals(room, adG.getCurrentRoom());
	}

	@Test
	public void testSetCurrentRoom() {
		Room room = new Room();
		AdventureGame adG= new AdventureGame();	
		adG.setCurrentRoom(room);
		assertEquals(room, adG.getCurrentRoom());
	}
		
	@Test
	public void testGetPlayer() {
		Player player =new Player(5,20,100);
		AdventureGame adG= new AdventureGame(player);
		assertEquals(player, adG.getPlayer());
		}

	@Test
	public void testSetPlayer() {
		Player player =new Player(5,20,100);
		AdventureGame adG= new AdventureGame();
		adG.setPlayer(player);
		assertEquals(player, adG.getPlayer());	}

}
