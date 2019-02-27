package game.action;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import game.character.Player;
import game.item.GoldPurse;
import game.item.HPotion;
import game.item.Item;
import game.room.Direction;
import game.room.Room;

public class ActionUseItemTest extends ActionTest{

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

         String input = "1 \n 1 \n";
 	     InputStream in = new ByteArrayInputStream(input.getBytes());
 	     System.setIn(in);
 	    
	}
	public Action createAction() {
		return new ActionUseItem();
	}
	public Player createPlayer() {
		Room room=new Room();
		Room room1=new Room();
		Room room2=new Room();
		room.addDestination(room1, Direction.EAST);
		room.addDestination(room2, Direction.SOUTH);
		List<Item> items = new ArrayList<Item>();
		HPotion healthPotion = new HPotion();
		GoldPurse goldPurse = new GoldPurse();
		items.add(healthPotion);
		items.add(goldPurse);
		room.setListItems(items);
		Player player =new Player(100,20,100);
		player.setCurrentRoom(room);
		return player;
	}
	
	@Test
	public void testIsPossible() {
		Action useItemAction = createAction();
		Player player = createPlayer();
		assertTrue(useItemAction.isPossible(player));
	}

	@Test
	public void testExecute() {
		Action useItem = (ActionUseItem) createAction();
		Player player = createPlayer();
		assertEquals("Health Potion",player.getCurrentRoom().getItems().get(0).toString());
		assertEquals("Gold Purse",player.getCurrentRoom().getItems().get(1).toString());
		useItem.execute(player);
		assertEquals(1,player.getCurrentRoom().getItems().size());
		useItem.execute(player);
		assertEquals(0,player.getCurrentRoom().getItems().size());
		
	}

	@Test
	public void testToString() {
		Action useItem = (ActionUseItem) createAction();
		assertEquals("Use Item Action", useItem.toString());
	}

}
