package Rogue_like.Rogue_like;

import Rogue_like.Rogue_like.Creature;

import Rogue_like.Rogue_like.Spell;

public class CastSpellScreen extends TargetBasedScreen {
	private Spell spell;
	
	public CastSpellScreen(Creature joueur, String caption, int sx, int sy, Spell spell) {
		super(joueur, caption, sx, sy);
		this.spell = spell;
	}
	
	public void selectWorldCoordinate(int x, int y, int screenX, int screenY){
		player.castSpell(spell, x, y);
	}
}
