package Rogue_like.Rogue_like;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class CreatureTest {

	
	Tile[][][] tile = new Tile[2][3][5];
	World monde = new World(tile);
	/*Creature 1*/
	char glyph = '@';
	String name = "Rex";
	Color red = new Color(128, 0, 0);
	int maxHp = 1000;
	int attack = 200;
	int defense = 260;
	Creature monstre = new Creature(monde,glyph,red,name,maxHp,attack,defense);
	
	/*Creature 2*/
	char glyph2 = '%';
	String name2 = "Tyranausaur";
	Color green2 = new Color(0, 128, 0);
	int maxHp2 = 900;
	int attack2 = 150;
	int defense2 = 190;
	Creature monstre2 = new Creature(monde,glyph2,green2,name2,maxHp2,attack2,defense2);
	
	@Test
	public void testColor() {
		assertEquals(red,monstre.color());
	}
	
	@Test
	public void testMaxHp() {
		assertEquals(maxHp,monstre.maxHp());
	}
	
	@Test
	public void testAttack() {
		monstre.meleeAttack(monstre2);
		assertTrue(monstre2.hp() > 0);
	}
	
	@Test
	public void testHp() {
		assertTrue(monstre.hp() > 0);
	}

	/*@Test
	public void testAttackValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testDefenseValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisionRadius() {
		fail("Not yet implemented");
	}

	@Test
	public void testInventory() {
		fail("Not yet implemented");
	}

	@Test
	public void testMaxFood() {
		fail("Not yet implemented");
	}

	@Test
	public void testFood() {
		fail("Not yet implemented");
	}

	@Test
	public void testWeapon() {
		fail("Not yet implemented");
	}

	@Test
	public void testXp() {
		fail("Not yet implemented");
	}

	@Test
	public void testLevel() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreature() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyHp() {
		fail("Not yet implemented");
	}

	@Test
	public void testDig() {
		fail("Not yet implemented");
	}*/

}