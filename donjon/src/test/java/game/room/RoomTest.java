package game.room;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import java.util.Objects;

import game.character.Monster;
import game.item.GoldPurse;
import game.item.HPotion;
import game.item.Item;
import game.item.OneArmedBandit;

public class RoomTest {

	public Room createRoom() {
		return new Room();
	}
	@Test
	public void testGetItems() {
		List<Item> items = new ArrayList<Item>();
		HPotion hPotion = new HPotion();
		GoldPurse goldPurse = new GoldPurse();
		items.add(hPotion);
		items.add(goldPurse);
		assertEquals(true, items.contains(goldPurse));
		assertEquals(true, items.contains(hPotion));
	}

	@Test
	public void testGetMonsters() {
		List<Monster> monsters = new ArrayList<Monster>();
		Monster monster = new Monster(10,20,30);
		monsters.add(monster);
		assertEquals(true, monsters.contains(monster));
	}

	@Test
	public void testSetListItems() {
		Room room = createRoom();
		List<Item> items = new ArrayList<Item>();
		HPotion healthPotion = new HPotion();
		OneArmedBandit oneArmedBandit = new OneArmedBandit();
		items.add(healthPotion);
		items.add(oneArmedBandit);
		room.setListItems(items);
		assertEquals(true, items.contains(healthPotion) && items.contains(oneArmedBandit) );
	}

	@Test
	public void testSetListMonsters() {
		Room room = (Room) createRoom();
		List<Monster> monsters = new ArrayList<Monster>();
		Monster monster = new Monster();
		monsters.add(monster);
		room.setListMonsters(monsters);
		assertEquals(true, monsters.contains(monster));
	}

	@Test
	public void testAddDestination() {
		Room room = (Room) createRoom();
		Room room2 = (Room) createRoom();
		room.addDestination(room2,Direction.EAST);
		assertEquals(room2,room.getDestination(Direction.EAST));
	}

	@Test
	public void testGetDestination() {
		Room room =  createRoom();
		Room roomDest =  createRoom();
		room.addDestination(roomDest, Direction.NORTH);
		assertEquals(roomDest,room.getDestination(Direction.NORTH));
	}

	@Test
	public void testAddItem() {
		Room room = createRoom();
		GoldPurse goldPurse = new GoldPurse();
		List<Item> items = new ArrayList<Item>();
		items.add(goldPurse);
		room.setListItems(items);
		assertSame(room.getItems(),items);
		
	}

	@Test
	public void testAddMonster() {
		Room room = createRoom();
		Monster monster = new Monster();
		List<Monster> monsters = new ArrayList<Monster>();
		monsters.add(monster);
		room.setListMonsters(monsters);
		room.addMonster(monster);
		assertSame(room.getMonsters(),monsters);
		}

	@Test
	public void testRemoveMonster() {
		Room room = createRoom();
		Monster monster = new Monster();
		List<Monster> monsters = new ArrayList<Monster>();
		monsters.add(monster);
		room.setListMonsters(monsters);
		assertSame(room.getMonsters(),monsters);
		room.removeMonster(monster);
		assertEquals(0,room.getMonsters().size());
		
	}

	@Test
	public void testRemoveItem() {
		Room room = createRoom();
		List<Item> items = new ArrayList<Item>();
		GoldPurse goldPurse = new GoldPurse();
		items.add(goldPurse);
		room.setListItems(items);
		assertSame(items,room.getItems());
		room.removeItem(goldPurse);
		assertEquals(0,room.getItems().size());
	}

	@Test
	public void testIsExit() {
		Room room = createRoom();
		assertFalse(room.isExit());
		
	}

	@Test
	public void testGetNeighbors() {
		Room room = createRoom();
		Room room2 = createRoom();
		Room room3 = createRoom();
		Map<Direction,Room> dest = new HashMap<Direction,Room>();
		dest.put(Direction.NORTH,room);
		dest.put(Direction.NORTH, room2);
		dest.put(Direction.SOUTH, room3);
		room.addDestination(room2, Direction.NORTH);
		room.addDestination(room3, Direction.SOUTH);
		assertEquals(dest,room.getNeighbors());
		
	}

}
