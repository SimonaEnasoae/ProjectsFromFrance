package game.item;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

import game.character.Player;

public class OneArmedBanditTest extends ItemTest{
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
        File file = new File("../mess.log");
 		FileOutputStream fos = new FileOutputStream(file);
 		PrintStream ps = new PrintStream(fos);
 		System.setOut(ps);
	}
	public Item createItem(){
		return new OneArmedBandit();
	}
	@Test
	public void testToString() {
		OneArmedBandit armedBandit = (OneArmedBandit) createItem();
		assertEquals("One-Armed Bandit", armedBandit.toString());
	}
	@Test
	public void testGetRandom(){
		OneArmedBandit armedBandit = (OneArmedBandit) createItem();
		assertTrue(armedBandit.getRandom() < 4);
		assertTrue(armedBandit.getRandom() > 0);
	}
	@Test
	public void testEffect() {
		OneArmedBandit armedBandit = (OneArmedBandit) createItem();
		Player player = new Player(10,20,30);
		armedBandit.effect(player);
		assertTrue(player.getGold()==31 || player.getLife() ==11 || player.getStrength()== 21);
	
	}

}
