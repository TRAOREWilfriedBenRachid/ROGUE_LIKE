package Rogue_like.Rogue_like;

import Rogue_like.Rogue_like.Creature;

import Rogue_like.Rogue_like.Item;

public class MangeScreen extends InventoryBasedScreen {

	public MangeScreen(Creature player) {
		super(player);
	}

	@Override
	protected String getVerb() {
		return "manger";
	}

	@Override
	protected boolean isAcceptable(Item item) {
		return item.foodValue() != 0;
	}

	@Override
	protected Screen use(Item item) {
		player.eat(item);
		return null;
	}
}
