package game.character;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import game.room.Direction;
import game.room.Room;


public class PlayerTest extends GameCharacterTest {
	private static PrintStream console=System.out;
	private static InputStream console1=System.in;
	/**
	 * 
	 * we need to have some date to read for the test and I redirect the output in a file 
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			
			
        File file = new File("../mess.log");
 		FileOutputStream fos = new FileOutputStream(file);
 		PrintStream ps = new PrintStream(fos);
 		System.setOut(ps);
 		
         String input = "1 \n 1 \n 1 \n 1 \n 1 \n";
 	     InputStream in = new ByteArrayInputStream(input.getBytes());
 	     System.setIn(in);
 	    
	}
	
	public GameCharacter createCharacter(){
		Monster monster=new Monster(100,20,100);
		Monster monster1=new Monster(100,20,100);
		Monster monster2=new Monster(100,20,100);
		Room room=new Room();
		Room room1=new Room();
		Room room2=new Room();
		Room room3=new Room();
		room.addMonster(monster);
		room.addMonster(monster1);
		room.addMonster(monster2);
		room.addDestination(room1, Direction.EAST);
		room.addDestination(room2, Direction.SOUTH);
		room2.addDestination(room3, Direction.SOUTH);
		Player player =new Player(100,20,100);
		player.setCurrentRoom(room);
		return player;
	}
	@Test
	public void testAct() {
		Player player= (Player) createCharacter();
		player.updateActions();
		player.act();
		assertEquals(2,player.getActions().size());
	}
	
	@Test
	public void testDie() {
	}

}
