package Rogue_like.Rogue_like;

import static org.junit.Assert.*;

import org.junit.Test;

import asciiPanel.AsciiPanel;

public class PlayScreenTest {

	@Test
	public void test() {
		World world = null;
		Creature fungus = new Creature(world, 'c', AsciiPanel.green, "champignon", 10, 0, 0);
		Creature fungu = new Creature(world, 'd', AsciiPanel.green, "champignon", 100, 0, 0);
		PlayScreen a = new PlayScreen ();
		PlayScreen b = new PlayScreen ();
		assertNotEquals(a,b);
	}

}
