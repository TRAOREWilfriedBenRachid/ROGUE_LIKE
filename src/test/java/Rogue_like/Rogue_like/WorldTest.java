package Rogue_like.Rogue_like;

import static org.junit.Assert.*;


import org.junit.Test;

public class WorldTest {
	public World world;

	@Test
	public void test() {
		fail("Not yet implemented");
		world = new WorldBuilder(90, 32, 5)
			.makeCaves()
			.build();
		
		// test if World object created
		assertNotNull(world);
		
		// test width equality
		assertEquals(90, world.width());
		
		// test height equality
		assertEquals(30, world.height());
		
		// test depth equality
		assertEquals(5, world.depth());
		
		
	}

}
