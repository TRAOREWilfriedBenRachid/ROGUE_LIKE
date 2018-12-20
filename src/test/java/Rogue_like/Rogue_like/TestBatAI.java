package Rogue_like.Rogue_like;

import static org.junit.Assert.*;

import asciiPanel.AsciiPanel;

import org.junit.Test;

public class TestBatAI {
	
	@Test
	public void test() {
		World world = null;
		Creature fungus = new Creature(world, 'c', AsciiPanel.green, "champignon", 10, 0, 0);
		Creature fungu = new Creature(world, 'd', AsciiPanel.green, "champignon", 100, 0, 0);
		 BatAi a = new BatAi(fungus);
		 BatAi  b = new BatAi(fungu);
		// a.onUpdate();
		// b.onUpdate();
		 assertNotEquals(a,b);
		
		
	}

}
