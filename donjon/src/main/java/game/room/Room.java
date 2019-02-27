package game.room;

import java.util.*;

import game.character.Monster;
import game.item.Item;

public class Room {

	protected List<Item> items = new ArrayList<Item>();
	protected List<Monster> monsters = new ArrayList<Monster>();
	protected Map<Direction,Room> dest = new HashMap<Direction,Room>();
	
	public Room() {
		
	}
	/**
	 * set the list of items 
	 * @param items list of Items
	 */
	public Room( List<Item> items) {
		this.items=items;
	}
	/**
	 * 
	 * @return List with items in the room
	 */
	public List<Item> getItems(){
		return items;
	}
	/**
	 * 
	 * @return a list with monsters in the room
	 */
	public List<Monster> getMonsters(){
		return monsters;
	}	
	/**
	 * set attribute items in the room
	 * @param items List
	 */
	public void setListItems(List<Item> items){
		this.items=items;
	}
	/**
	 * set list of  monsters
	 * @param monsters List
	 */
	public void setListMonsters(List<Monster> monsters){
		this.monsters=monsters;
	}
	/**
	 * create a link between two different rooms, specifying the direction
	 * @param r Room
	 * @param d Direction
	 */
	public void addDestination(Room r, Direction d) {		
		dest.put(d, r);
	}
	/**
	 * give the room in direction d
	 * @param d Direction
	 * @return a room 
	 */
	public Room getDestination(Direction d) {			
		
		return dest.get(d);
	}
	/**
	 * add an item to the Items List
	 * @param item List
	 */
	public void addItem(Item item){
		items.add(item);
	}
	/**
	 * add a monster to Monsters List
	 * @param monster Monster
	 */
	public void addMonster(Monster monster){
		monsters.add(monster);
	}
	/**
	 * remove a monster from the list
	 * @param monster type Monster
	 */
	public void removeMonster(Monster monster){
			monsters.remove(monster);
	}
	/**
	 * remove an item  from the Item list
	 * @param item type Item
	 */
	public void removeItem(Item item){
		items.remove(item);
	}
	/**
	 * indicate that is not an exit
	 * @return false always
	 */
	public boolean isExit(){
		return false;
	}
	/**
	 * returns rooms next to the current room
	 * @return dest type Map (Direction,Room)
	 */
	public Map<Direction,Room> getNeighbors(){
		return dest;	
	}
	/**
	 * @return a string which represents the details of room
	 */
	public String toString(){
		return "In this room there are "+this.getItems().size()+" items and "+this.getMonsters().size()+" monsters.";
		
	}
}
