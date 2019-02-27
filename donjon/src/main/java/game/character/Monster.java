package game.character;

import game.item.GoldPurse;
import game.room.Room;

public class Monster extends GameCharacter{
	public Monster() {}
	/**
	 * 
	 * @param life Integer
	 * @param strenght  Integer
	 * @param gold   Integer
	 */
	public Monster(int life, int strenght, int gold){
		super(life, strenght,gold);
	}
	/**
	 * 
	 * @param life  Integer
	 * @param strenght  Integer
	 * @param gold   Integer
	 * @param currentRoom  Integer
	 */
	public Monster(int life, int strenght, int gold,Room currentRoom){
		super(life, strenght,gold,currentRoom);
	}
	/**
	 * remove the monster fron the list, add a GoldPurseItem in the room
	 */
	@Override
	public void die() {
		Room updateRoom= this.getCurrentRoom();
		GoldPurse item=new GoldPurse(this.getGold());
		updateRoom.addItem(item);
		updateRoom.removeMonster(this);
		
	}
	/**
	 * @return a string which represent the Monster
	 */
	public String toString(){
		return "Monster has "+this.getLife()+" life, "+this.getStrength()+" strength, "+ this.getGold()+" gold.";
		
	}

}
