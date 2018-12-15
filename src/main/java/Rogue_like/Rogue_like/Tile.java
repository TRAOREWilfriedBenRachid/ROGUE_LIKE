package Rogue_like.Rogue_like;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public enum Tile {
	FLOOR((char)250, AsciiPanel.green),
	WALL((char)177, AsciiPanel.white),
	BOUNDS('x', AsciiPanel.brightBlack);
	//STAIRS_DOWN('>', AsciiPanel.white),
   // STAIRS_UP('<', AsciiPanel.white);
	
	private char glyph;
	public char glyph() { return glyph; }
	
	private Color color;
	public Color color() { return color; }
	
	Tile(char glyph, Color color){
		this.glyph = glyph;
		this.color = color;
	}

	public boolean isGround() {
		return this != WALL && this != BOUNDS;
	}

	public boolean isDiggable() {
		return this == Tile.WALL;
	}
	
}