package Rogue_like.Rogue_like;

import Rogue_like.Rogue_like.Creature;
import Rogue_like.Rogue_like.Item;

public class DropScreen extends InventoryBasedScreen {

	public DropScreen(Creature player) {
		super(player);
	}

	@Override
	protected String getVerb() { 
		return "supprimer"; 
	}

	@Override
	protected boolean isAcceptable(Item item) { 
		return true; 
	}
	
	@Override
	protected Screen use(Item item) { 
		player.drop(item); 
		return null;
	}
}
