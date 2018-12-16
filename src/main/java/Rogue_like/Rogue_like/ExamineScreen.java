package Rogue_like.Rogue_like;

import Rogue_like.Rogue_like.Creature;
import Rogue_like.Rogue_like.Item;

public class ExamineScreen extends InventoryBasedScreen {

	public ExamineScreen(Creature player) {
		super(player);
	}

	@Override
	protected String getVerb() {
		return "examine";
	}

	@Override
	protected boolean isAcceptable(Item item) {
		return true;
	}

	@Override
	protected Screen use(Item item) {
		String article = "aeiou".contains(player.nameOf(item).subSequence(0, 1)) ? "an " : "a ";
		player.notify("c'est un  " + article + player.nameOf(item) + "." + item.details());
		return null;
	}
}
