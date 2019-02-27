package game.action;

import game.character.Player;
/**
 * 
 *Actions for the  player
 *
 */
public interface Action {
	boolean isPossible(Player player);
	void execute(Player player);
}

