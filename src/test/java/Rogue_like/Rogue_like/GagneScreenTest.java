package Rogue_like.Rogue_like;

import static org.junit.Assert.*;

import org.junit.Test;


public class GagneScreenTest {

	@Test
	public void test() {

		
		GagneScreen a = new GagneScreen ();
		GagneScreen b = new GagneScreen ();
		assertNotEquals(a,b);
	}

}
