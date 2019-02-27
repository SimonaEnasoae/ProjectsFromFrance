package game.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import game.character.Monster;
import game.character.Player;
import game.item.GoldPurse;
import game.item.HPotion;
import game.item.Item;
import game.item.OneArmedBandit;
import game.item.StrengthPotion;
import game.room.Direction;
import game.room.Exit;
import game.room.Room;

public class AdventureGame {
	private Room currentRoom ;
	private Player player;
	public AdventureGame(){
		
	}
	public AdventureGame(Player player) {
		super();
		this.player = player;
	}
	public AdventureGame(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	/**
	 * create a simple  Donjon with monsters, items and rooms; 
	 */
	public void createDonjon() {
		List<Room> rooms= new ArrayList<Room>();
		for(int x=0; x < 7; x++) {
			Room r = new Room();
			rooms.add(r);
		}
		List<Exit> exits = new ArrayList<Exit>();
		for(int x=0 ; x < 3; x++) {
			Exit e = new Exit();
			exits.add(e);
		}
		List< Monster> monsters=new ArrayList<Monster>();
		for(int x = 0; x < 13; x++) {
			Monster m = new Monster(3,4,5);
			monsters.add(m);
		}
		for(int x = 0; x < 7; x++)	{
			Room r=rooms.get(x);
			Monster m=monsters.get(x);
			m.setCurrentRoom(r);
			monsters.set(x, m);
			r.addMonster(monsters.get(x));
			rooms.set(x,r);
		}
		for(int x = 0; x < 3; x++)	{
			Exit e=exits.get(x);
			Monster m=monsters.get(x+7);
			m.setCurrentRoom(e);
			monsters.set(x+7, m);
			Monster m1=monsters.get(x+10);
			m1.setCurrentRoom(e);
			monsters.set(x+10, m1);
			e.addMonster(monsters.get(x+7));
			e.addMonster(monsters.get(x+10));
			exits.set(x, e);
		}
		
		List<GoldPurse> goldPurses = new ArrayList<GoldPurse>();
		List<HPotion> healthPotions = new ArrayList<HPotion>();
		List<OneArmedBandit> oneArmedBandits= new ArrayList<OneArmedBandit>();
		List<StrengthPotion> strengthPotions = new ArrayList<StrengthPotion>();
		for(int x = 0; x < 10; x++)	{
			GoldPurse goldPurse = new GoldPurse();
			goldPurses.add(goldPurse);
			HPotion healthPotion = new HPotion();
			healthPotions.add(healthPotion);
			OneArmedBandit oneArmedBandit =new OneArmedBandit();
			oneArmedBandits.add(oneArmedBandit);
			StrengthPotion strengthPotion = new StrengthPotion();
			strengthPotions.add(strengthPotion);
		}
		for(int x = 0; x < 7; x++) {
			Room r=rooms.get(x);
			r.addItem(healthPotions.get(x));
			rooms.set(x, r);
		}
		for(int x = 0; x < 3; x++) {
			Exit e=exits.get(x);
			e.addItem(healthPotions.get(x));
			exits.set(x, e);
		}
		for(int x = 0; x < 7; x+=2) {
			Room r=rooms.get(x);
			r.addItem(strengthPotions.get(x/2));
			rooms.set(x, r);
			
		}
		for(int x = 0; x < 3; x++) {
			Exit e=exits.get(x);
			e.addItem(oneArmedBandits.get(x));
			exits.set(x, e);
		}
		for(int x = 1; x < 7; x+=2) {
			Room r=rooms.get(x);
			r.addItem(goldPurses.get(x/2));
			rooms.set(x, r);
		}
		
		Room r=rooms.get(2);
		r.addDestination(rooms.get(5), Direction.NORTH);
		rooms.set(2,r);
		Room r1=rooms.get(3);
		r1.addDestination(rooms.get(6), Direction.NORTH);
		rooms.set(3,r1);
		Room r3=rooms.get(4);
		r3.addDestination(exits.get(1), Direction.NORTH);
		rooms.set(4,r3);		
		Room r4=rooms.get(5);
		r4.addDestination(exits.get(2), Direction.NORTH);
		rooms.set(5,r4);
		
		Room r5=rooms.get(0);
		r5.addDestination(rooms.get(3), Direction.EAST);
		rooms.set(0,r5);
		Room r6=rooms.get(2);
		r6.addDestination(rooms.get(3), Direction.EAST);
		rooms.set(2,r6);
		Room r7=rooms.get(3);
		r7.addDestination(rooms.get(4), Direction.EAST);
		rooms.set(3,r7);
		Room r8=rooms.get(5);
		r8.addDestination(rooms.get(6), Direction.EAST);
		rooms.set(5,r8);
		Room r9=rooms.get(6);
		r9.addDestination(exits.get(2), Direction.EAST);
		rooms.set(6,r9);
		
		Room r10=rooms.get(2);
		r10.addDestination(rooms.get(0), Direction.SOUTH);
		rooms.set(2,r10);
		Room r11=rooms.get(1);
		r11.addDestination(exits.get(0), Direction.SOUTH);
		rooms.set(1,r11);
		
		Room r12=rooms.get(2);
		r12.addDestination(rooms.get(1), Direction.WEST);
		rooms.set(2,r12);
		
		this.currentRoom = rooms.get(2);
	}
	/**
	 * 
	 * @return true if the game is over, false otherwise
	 */
	public boolean isFinished() {
		return player.isAlive() && player.getCurrentRoom().isExit()&&player.getCurrentRoom().getMonsters().size()==0 ;
	}
	/**
	 * start the game
	 * @param player type Player
	 */
	public void play(Player player) {
		this.createDonjon();
		this.player=player;
		player.setCurrentRoom(this.currentRoom);
		player.updateActions();
		do {
			player.act();
			player.updateActions();
			System.out.println(player);

		}while(!this.isFinished() );
		
		if(player.isAlive()) {
			System.out.println("WINNER!");
		}else {
			System.out.println("LOOSER");
		}
	}
	
	
	public static void main(String[] args) {
		
		AdventureGame adventureGame= new AdventureGame();
		Player player = new Player(30,5,10);
		
		adventureGame.play(player);
	}
	/**
	 * 
	 * @return the currentRoom
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
	/**
	 * set the current Room
	 * @param currentRoom  type Room
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	/**
	 * 
	 * @return player type Player
	 */
	public Player getPlayer() {
		return player;
	}
	/**
	 * set the player
	 * @param player type Player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

}
