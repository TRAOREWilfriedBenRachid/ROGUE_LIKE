package Rogue_like.Rogue_like;

import static org.junit.Assert.*;


import org.junit.Test;
public class StartScreenTest {

	@Test
	public void test() {
		StartScreen a = new StartScreen ();
		StartScreen b = new StartScreen ();
		assertNotEquals(a,b);
	}

}
