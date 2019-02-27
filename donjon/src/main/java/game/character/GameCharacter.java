package game.character;


import game.item.GoldPurse;
import game.room.Room;

public abstract class GameCharacter {
	/**
	 * 
	 */
	protected int life;
	protected int strength;
	protected int gold;
	protected Room currentRoom;
	protected String name;
	
	public GameCharacter() {}
	/**
	 * 
	 * @param life Integer
	 * @param strenght  Integer
	 * @param gold   Integer
	 */
	public GameCharacter(int life, int strenght, int gold) {
		this.life=life;
		this.strength=strenght;
		this.gold=gold;
	}
	/**
	 * 
	 * @param life  Integer
	 * @param strenght  Integer
	 * @param gold   Integer
	 * @param currentRoom  Integer
	 */
	public GameCharacter(int life, int strenght, int gold, Room currentRoom) {
		this.life=life;
		this.strength=strenght;
		this.gold=gold;
		this.currentRoom=currentRoom;
	}
	/**
	 * 
	 * @param name  String
	 * @param life  Integer
	 * @param strenght  Integer
	 * @param gold   Integer
	 * @param currentRoom  Integer
	 */
	public GameCharacter(String name, int life, int strenght, int gold, Room currentRoom) {
		this.life=life;
		this.strength=strenght;
		this.gold=gold;
		this.currentRoom=currentRoom;
		this.name=name;
	}
	/**
	 * 	
	 * @return  strength type-Integer
	 */
	public int getStrength() {
		return strength;	
	}
	/**
	 * set the strenght
	 * @param strenght Integer
	 */
	public void setStrength(int strenght){
		this.strength=strenght;
	}
	/**
	 * 
	 * @return life  type -Integer
	 */
	public int getLife() {
		return life;	
	}
	/**
	 * set the life
	 * @param life type -Integer
	 */
	public void setLife(int life){
		this.life=life;
	}
	/**
	 * 
	 * @return gold type -Integer
	 */
	public int getGold() {
		return gold;	
	}
	/**
	 * set the gold 
	 * @param gold type Integer
	 */
	public void setGold(int gold){
		this.gold=gold;
	}
	/**
	 * 
	 * @return the currentRoom type- Room
	 */
	public Room getCurrentRoom(){
		return this.currentRoom;
	}
	/**
	 *  set the currentRoom with UpdateRoom
	 * @param updateRoom type Room
	 */
	public void setCurrentRoom(Room updateRoom){
		this.currentRoom=updateRoom;
	}
	/**
	 * check if the player is alive
	 * @return true is character is alive , false otherwise
	 */
	public boolean isAlive() {
		return (life > 0);
	}
	/**
	 *change the game setting, it has different actions for player/monster etc..
	 */
	abstract public void die();
	/**
	 * change the life of gameCharact
	 * @param gameCharact type GameCharacter
	 */
	public void attack(GameCharacter gameCharact){	
		gameCharact.setLife(gameCharact.getLife()-this.getStrength());
	}
	
	/**
	 * @return true if is the same character, false otherwise
	 */
	public boolean equals(Object o) {
		if (o instanceof GameCharacter) {
			GameCharacter other = (GameCharacter) o;
			return other.getGold() == (this.getGold()) && other.getLife() == (this.getLife()) && other.getGold() == this.getGold() && other.getCurrentRoom() == this.currentRoom;
		}
		else
			return false;
	}

	
}
