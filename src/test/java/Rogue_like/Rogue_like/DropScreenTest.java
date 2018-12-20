package Rogue_like.Rogue_like;

import static org.junit.Assert.*;


import org.junit.Test;

import asciiPanel.AsciiPanel;


public class DropScreenTest {

	@Test
	public void test() {
		World world = null;
		Creature fungus = new Creature(world, 'c', AsciiPanel.green, "champignon", 10, 0, 0);
		Creature fungu = new Creature(world, 'd', AsciiPanel.green, "champignon", 100, 0, 0);
		
		DropScreen a = new DropScreen (fungus);
		DropScreen b = new DropScreen (fungu);
		assertNotEquals(a,b);
	}

}
