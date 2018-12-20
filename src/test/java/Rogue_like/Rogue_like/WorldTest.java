package Rogue_like.Rogue_like;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTest {
	
	Tile[][][] tile = new Tile[2][3][5];
	World monde = new World(tile);
	
	@Test
	public void testWidth() {
		assertEquals(tile.length,monde.width());
	}

	@Test
	public void testHeight() {
		assertEquals(tile[0].length,monde.height());
	}

	@Test
	public void testDepth() {
		assertEquals(tile[0][0].length,monde.depth());
	}

	@Test
	public void testCreature() {
		Creature exist = monde.creature(0, 0, 0);
		assertNull(exist);
	}
	
	/*@Test
	public void testTile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGlyph() {
		fail("Not yet implemented");
	}

	@Test
	public void testDig() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveCreature() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveIntIntInt() {
		fail("Not yet implemented");
	}*/


}