package Rogue_like.Rogue_like;

import java.awt.Color;

public class Creature {
	private World world;
	
	public int x;
	public int y;
	
	private char glyph;
	public char glyph() { return glyph; }
	
	private Color color;
	public Color color() { return color; }

	private CreatureAi ai;
	public void setCreatureAi(CreatureAi ai) { this.ai = ai; }
	
	public Creature(World world, char glyph, Color color){
		this.world = world;
		this.glyph = glyph;
		this.color = color;
	}
	
	public void moveBy(int mx, int my){
		ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
	}

	public void dig(int wx, int wy) {
		world.dig(wx, wy);
	}
}