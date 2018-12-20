package Rogue_like.Rogue_like;

import static org.junit.Assert.*;

import org.junit.Test;

import asciiPanel.AsciiPanel;

public class LookScreenTest {

	@Test
	public void test() {
		World world = null;
		Creature fungus = new Creature(world, 'c', AsciiPanel.green, "champignon", 10, 0, 0);
		Creature fungu = new Creature(world, 'd', AsciiPanel.green, "champignon", 100, 0, 0);
		
		LookScreen a = new LookScreen (fungus, "aaaa", 2,5);
		LookScreen b = new LookScreen (fungu, "eerr", 5,6);
		assertNotEquals(a,b);
	}

}
