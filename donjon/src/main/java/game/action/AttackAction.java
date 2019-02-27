package game.action;

import java.util.List;

import game.character.Monster;
import game.character.Player;
import game.util.ListChoser;

public class AttackAction implements Action {
	
	public AttackAction(){	
	}
	/**
	 * @return  true if there are still some monsters to kill, false otherwise
	 */
	@Override
	public boolean isPossible(Player player) {
		return  !(player.getCurrentRoom().getMonsters().isEmpty());
	}
	/**
	 * shows list with current monsters , the player attack a monster
	 */
	@Override
	public void execute(Player player) {
		List<Monster> monsters=player.getCurrentRoom().getMonsters();
		Monster monster=ListChoser.SINGLETON.chose("which monster?", monsters);
		player.attack(monster);
		monster.attack(player);
		if(monster.getLife()<=0){
			monster.die();
		}

	}
	/**
	 * @return the string which represents the  action 
	 */
	
	public String toString() {
		return "Attack Action" ;
	}

}

