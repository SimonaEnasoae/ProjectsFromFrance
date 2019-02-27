package game.action;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import game.character.Player;
import game.room.Direction;
import game.room.Room;

public class MoveActionTest extends ActionTest{
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

         String input = "1 \n 1 \n";
 	     InputStream in = new ByteArrayInputStream(input.getBytes());
 	     System.setIn(in);
 	    
	}
	
	public Action createAction(){
		return new MoveAction();		
	}
	public Player createPlayer(){
		Room room=new Room();
		Room room1=new Room();
		Room room2=new Room();
		room.addDestination(room1, Direction.EAST);
		room.addDestination(room2, Direction.SOUTH);
		Player player =new Player(100,20,100);
		player.setCurrentRoom(room);
		return player;
	}
	@Test
	public void testIsPossible() {
		Action moveAction= createAction();
		Player player= createPlayer();
		assertEquals(moveAction.isPossible(player),true);

	}

	@Test
	public void testExecute() {
		
		Action moveAction= createAction();
		Player player= createPlayer();
		assertEquals(2,player.getCurrentRoom().getNeighbors().size());
		moveAction.execute(player);
		assertEquals(0,player.getCurrentRoom().getNeighbors().size());
	}
	
	@Test
	public void testToString() {
		Action moveAction=createAction();
		assertEquals("Move Action",moveAction.toString());
	}
}
