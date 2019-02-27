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

import game.character.Monster;
import game.character.Player;
import game.room.Direction;
import game.room.Room;

public class ActionTest {
	
	private class MockAction implements Action{
		
		public boolean checkIsPossible=false;
		public boolean checkExecute=false;
		@Override
		public boolean isPossible(Player player) {
			checkIsPossible=true;
			return false;
		}
		@Override
		public void execute(Player player) {
			checkExecute=true;		
		}
	}
	public Player createPlayer(){
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
	public Action createAction(){
		return new MockAction();
		
	}
	@Test
	public void testIsPossible() {
		MockAction mockAction=(MockAction) createAction();
		Player player =new Player(100,20,100);
		assertEquals(false,mockAction.isPossible(player));
		
		assertEquals(true,mockAction.checkIsPossible);
	}

	@Test
	public void testExecute() {
		MockAction mockAction=(MockAction) createAction();
		Player player =new Player(100,20,100);
		mockAction.execute(player);
		assertEquals(true, mockAction.checkExecute);
	}

}
