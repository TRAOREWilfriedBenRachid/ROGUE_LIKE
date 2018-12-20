package Rogue_like.Rogue_like;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class ItemTest {

		Color red = new Color(128, 0, 0);
		Item myitem = new Item('@',red,"Monster", null);

		@Test
		public void testGlyph() {
			assertEquals('@',myitem.glyph());
		}

		@Test
		public void testColor() {
			assertEquals(red,myitem.color());
		}

		@Test
		public void testName() {
			assertEquals("Monster",myitem.name());
		}

		@Test
		public void testFoodValue() {
			assertNotNull("Food value ne doit pas etre null",myitem.foodValue());
		}

		@Test
		public void testModifyFoodValue() {
			myitem.modifyFoodValue(100);
			//assertTrue(myitem.foodValue());
		}

		/*@Test
		public void testAttackValue() {
			fail("Not yet implemented");
		}

		@Test
		public void testModifyAttackValue() {
			fail("Not yet implemented");
		}

		@Test
		public void testDefenseValue() {
			fail("Not yet implemented");
		}

		@Test
		public void testModifyDefenseValue() {
			fail("Not yet implemented");
		}

		@Test
		public void testItem() {
			fail("Not yet implemented");
		}

		@Test
		public void testDetails() {
			fail("Not yet implemented");
		}*/

}