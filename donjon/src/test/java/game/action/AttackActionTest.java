package game.action;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import game.character.Monster;
import game.character.Player;
import game.room.Room;
import game.util.ScannerInt;

public class AttackActionTest extends ActionTest{
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
 		
         String input = "1 \n 1 \n 1\n 1\n 1\n";
 	     InputStream in = new ByteArrayInputStream(input.getBytes());
 	     System.setIn(in);
 	    
	}
	
	public Action createAction(){
		return new AttackAction();		
	}
	@Test
	public void testIsPossible() {
		Action attackAction=createAction();
		Player player= createPlayer();
		assertEquals(attackAction.isPossible(player),true);
	}

	@Test
	public void testExecute() {

	    Action attackAction=(AttackAction) createAction();
		Player player= createPlayer();
		attackAction.execute(player);
	    List<Monster> monsters=player.getCurrentRoom().getMonsters();
	    Monster monster= monsters.get(0);
	    assertEquals(80,monster.getLife());
	}

	@Test
	public void testToString() {
		Action attackAction=(AttackAction) createAction();
		assertEquals("Attack Action",attackAction.toString());
	}

}
