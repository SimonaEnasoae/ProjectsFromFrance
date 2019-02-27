package game.character;

import static org.junit.Assert.*;

import org.junit.Test;

import game.room.Room;


public class GameCharacterTest {
	
	private class MockCharacter extends GameCharacter{
		public boolean checkDie=false;
		public MockCharacter(int life,int strength,int gold) {
			super(life,strength,gold);
		}
		public MockCharacter(int life,int strength,int gold,Room currentRoom) {
			super(life,strength,gold,currentRoom);
		}
		@Override
		public void die() {
			checkDie=true;
		}	
	}
	public GameCharacter createCharacter(){
		return new MockCharacter(100,20,100);
	}
	@Test
	public void testGetLife() {
		GameCharacter character=createCharacter();
		assertEquals(100,character.getLife());
	}
	@Test
	public void testSetLife() {
		GameCharacter character=createCharacter();
		character.setLife(200);
		assertEquals(200,character.getLife());
	}
	@Test
	public void testGetStrenght() {
		GameCharacter character=createCharacter();
		assertEquals(20,character.getStrength());
	}
	@Test
	public void testSetStrenght() {
		GameCharacter character=createCharacter();
		character.setStrength(100);
		assertEquals(100,character.getStrength());
	}
	@Test
	public void testGetGold() {
		GameCharacter character=createCharacter();
		assertEquals(100,character.getGold());
	}
	@Test
	public void testSetGold() {
		GameCharacter character=createCharacter();
		character.setGold(200);
		assertEquals(200,character.getGold());
	}
	@Test
	public void testSetCurrentRoom() {
		GameCharacter character=createCharacter();
		Room r1=new Room();
		character.setCurrentRoom(r1);
		assertEquals(r1, character.getCurrentRoom());
	}
	@Test
	public void testAliveTrue(){
		GameCharacter character=createCharacter();
		assertEquals(true,character.isAlive());
	}
	
	@Test
	public void testAliveFalse(){
		GameCharacter character=createCharacter();
		character.setLife(0);
		assertEquals(false,character.isAlive());
	}
	
	@Test
	public void testAttack(){
		GameCharacter character1=createCharacter();
		GameCharacter character2=createCharacter();
		int life=character2.getLife();
		int strength=character1.getStrength();
		character1.attack(character2);
		assertEquals(life-strength,character2.getLife());
		
	}
	@Test
	public void testDie() {
		MockCharacter character=(MockCharacter) createCharacter();
		character.die();
		assertEquals(true,character.checkDie);
	}
}
