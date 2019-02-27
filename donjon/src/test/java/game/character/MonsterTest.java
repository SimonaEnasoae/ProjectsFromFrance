package game.character;

import static org.junit.Assert.*;

import org.junit.Test;

import game.room.Room;

public class MonsterTest extends GameCharacterTest {
	
	public GameCharacter createCharacter(){
		return new Monster(100,20,100);
	}
	
	@Test
	public void testDie() {
		Monster monster=(Monster) createCharacter();
		Room room=new Room();
		monster.setCurrentRoom(room);
		room.addMonster(monster);
		monster.die();
		assertEquals(0,room.getMonsters().size());
		assertEquals(1,room.getItems().size());
		
	}

}
