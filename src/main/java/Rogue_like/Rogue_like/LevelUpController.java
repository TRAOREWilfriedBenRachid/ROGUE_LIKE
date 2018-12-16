package Rogue_like.Rogue_like;

import java.util.ArrayList;
import java.util.List;

public class LevelUpController {

	
	private static LevelUpOption[] options = new LevelUpOption[] {
			new LevelUpOption("Augmentation des points de vie ") {
				public void invoke(Creature creature) {
					creature.modifyMaxHp(10);
					creature.modifyHp(10, "tué par exces  du bonus de niveau de vie?");
					creature.doAction("en forme");
				}
			}, new LevelUpOption("Augmentation de magie") {
				public void invoke(Creature creature) {
					creature.modifyMaxMana(5);
					creature.modifyMana(5);
					creature.doAction("plus de magie");
				}
			}, new LevelUpOption("augmentation du niveau dattaque") {
				public void invoke(Creature creature) {
					creature.modifyAttackValue(2);
					creature.doAction("plus fort");
				}
			}, new LevelUpOption("augmentation de la defense") {
				public void invoke(Creature creature) {
					creature.modifyDefenseValue(1);
					creature.doAction("plus securisé");
				}
			},// new LevelUpOption("Increased vision") {
				//public void invoke(Creature creature) {
					//creature.modifyVisionRadius(1);
					//creature.doAction("look a little more aware");
				//}
			 new LevelUpOption("Augmentation de la regeneration de Poins de Vie") {
				public void invoke(Creature creature) {
					creature.modifyRegenHpPer1000(10);
					creature.doAction("moins meurtri");
				}
			}, new LevelUpOption("Augmentation de la regeneration de mana") {
				public void invoke(Creature creature) {
					creature.modifyRegenManaPer1000(10);
					creature.doAction("plus cool");
				}
			} };

	public void autoLevelUp(Creature creature) {
		options[(int) (Math.random() * options.length)].invoke(creature);
	}

	public List<String> getLevelUpOptions() {
		List<String> names = new ArrayList<String>();
		for (LevelUpOption option : options) {
			names.add(option.name());
		}
		return names;
	}

	public LevelUpOption getLevelUpOption(String name) {
		for (LevelUpOption option : options) {
			if (option.name().equals(name))
				return option;
		}
		return null;
	}
}
