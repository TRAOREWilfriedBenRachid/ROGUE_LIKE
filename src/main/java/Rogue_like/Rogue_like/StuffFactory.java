package Rogue_like.Rogue_like;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import asciiPanel.AsciiPanel;

public class StuffFactory {
	private World world;
	private Map<String, Color> potionColors;
	private List<String> potionAppearances;
	
	public StuffFactory(World world){
		this.world = world;
		
		setUpPotionAppearances();
	}
	
	private void setUpPotionAppearances(){
		potionColors = new HashMap<String, Color>();
		potionColors.put("red potion", AsciiPanel.brightRed);
		potionColors.put("yellow potion", AsciiPanel.brightYellow);
		potionColors.put("green potion", AsciiPanel.brightGreen);
		potionColors.put("cyan potion", AsciiPanel.brightCyan);
		potionColors.put("blue potion", AsciiPanel.brightBlue);
		potionColors.put("magenta potion", AsciiPanel.brightMagenta);
		potionColors.put("dark potion", AsciiPanel.brightBlack);
		potionColors.put("grey potion", AsciiPanel.white);
		potionColors.put("light potion", AsciiPanel.brightWhite);

		potionAppearances = new ArrayList<String>(potionColors.keySet());
		Collections.shuffle(potionAppearances);
	}
	
	public Creature newPlayer(List<String> messages, FieldOfView fov){
		Creature player = new Creature(world, '@', AsciiPanel.brightWhite, "joueur", 100, 20, 5);
		world.addAtEmptyLocation(player, 0);
		new PlayerAi(player, messages, fov);
		return player;
	}
	
	public Creature newFungus(int depth){
		Creature fungus = new Creature(world, 'c', AsciiPanel.green, "champignon", 10, 0, 0);
		world.addAtEmptyLocation(fungus, depth);
		new FungusAi(fungus, this);
		return fungus;
	}
	
	public Creature newBat(int depth){
		Creature bat = new Creature(world, 's', AsciiPanel.brightYellow, "chauve souris", 15, 5, 0);
		world.addAtEmptyLocation(bat, depth);
		new BatAi(bat);
		return bat;
	}
	

	
	public Item newRock(int depth){
		Item rock = new Item(',', AsciiPanel.yellow, "roche", null);
		rock.modifyThrownAttackValue(5);
		world.addAtEmptyLocation(rock, depth);
		return rock;
	}
	
	public Item newVictoryItem(int depth){
		Item item = new Item('*', AsciiPanel.brightWhite, "ours en peluche", null);
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	
	public Item newBread(int depth){
		Item item = new Item('%', AsciiPanel.yellow, "Pain", null);
		item.modifyFoodValue(400);
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	
	public Item newFruit(int depth){
		Item item = new Item('%', AsciiPanel.green, "pomme", null);
		item.modifyFoodValue(100);
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	
	public Item newDagger(int depth){
		Item item = new Item(')', AsciiPanel.white, "daggue", null);
		item.modifyAttackValue(5);
		item.modifyThrownAttackValue(5);
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	
	public Item newSword(int depth){
		Item item = new Item(')', AsciiPanel.brightWhite, "épée", null);
		item.modifyAttackValue(10);
		item.modifyThrownAttackValue(3);
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	
	
	//////a supprimerrrr
	//public Item newStaff(int depth){
	//	Item item = new Item(')', AsciiPanel.yellow, "staff", null);
	//	item.modifyAttackValue(5);
	//	item.modifyDefenseValue(3);
	//	item.modifyThrownAttackValue(3);
	//	world.addAtEmptyLocation(item, depth);
	//	return item;
	//}
//
	public Item newBow(int depth){
		Item item = new Item(')', AsciiPanel.yellow, "arc", null);
		item.modifyAttackValue(1);
		item.modifyRangedAttackValue(5);
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	////a spprimerr
	//public Item newEdibleWeapon(int depth){
		//Item item = new Item(')', AsciiPanel.yellow, "baguette", null);
		//item.modifyAttackValue(3);
		//item.modifyFoodValue(100);
		//world.addAtEmptyLocation(item, depth);
		//return item;
	//}
	///////a effacer
	//public Item newLightArmor(int depth){
		//Item item = new Item('[', AsciiPanel.green, "armure", null);
		//item.modifyDefenseValue(2);
		//world.addAtEmptyLocation(item, depth);
		//return item;
	//}
	//// a effacer
	public Item newMediumArmor(int depth){
		Item item = new Item('[', AsciiPanel.white, "armure", null);
		item.modifyDefenseValue(4);
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	//// a effacer
	//public Item newHeavyArmor(int depth){
		//Item item = new Item('[', AsciiPanel.brightWhite, "armure", null);
		//item.modifyDefenseValue(6);
		//world.addAtEmptyLocation(item, depth);
		//return item;
	//}
	
	public Item randomWeapon(int depth){
		switch ((int)(Math.random() * 3)){
		case 0: return newDagger(depth);
		case 1: return newSword(depth);
		default: return newBow(depth);
		}
	}

	public Item randomArmor(int depth){
		switch ((int)(Math.random() * 3)){
		//case 0: return newLightArmor(depth);
		//case 1: return newMediumArmor(depth);
		default: return newMediumArmor(depth);
		}
	}
	
	public Item newPotionOfHealth(int depth){
		String appearance = potionAppearances.get(0);
		final Item item = new Item('!', potionColors.get(appearance), " potion de vie ", appearance);
		item.setQuaffEffect(new Effect(1){
			public void start(Creature creature){
				if (creature.hp() == creature.maxHp())
					return;
				
				creature.modifyHp(15, "Tué par une potion de vie?");
				creature.doAction(item, "vous avez l'air en meilleure santé"  );
			}
		});
		
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	
	public Item newPotionOfMana(int depth){
		String appearance = potionAppearances.get(1);
		final Item item = new Item('!', potionColors.get(appearance), " potion magique", appearance);
		item.setQuaffEffect(new Effect(1){
			public void start(Creature creature){
				if (creature.mana() == creature.maxMana())
					return;
				/////////////ajouter 
				creature.modifyMana(10);
				creature.doAction(item, " ");
			}
		});
		
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	
		
	public Item newPotionOfPoison(int depth){
		String appearance = potionAppearances.get(3);
		final Item item = new Item('!', potionColors.get(appearance), "poison", appearance);
		item.setQuaffEffect(new Effect(20){
			public void start(Creature creature){
				creature.doAction(item, "malade ");
			}
			
			public void update(Creature creature){
				super.update(creature);
				creature.modifyHp(-1, "tué par le poison.");
			}
		});
		
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	
			
	
	
	public Item newPotionOfExperience(int depth){
		String appearance = potionAppearances.get(6);
		final Item item = new Item('!', potionColors.get(appearance), " potion 'axperience", appearance);
		item.setQuaffEffect(new Effect(20){
			public void start(Creature creature){
				creature.doAction(item, "vous avez  l'air plus expérimenté");
				creature.modifyXp(creature.level() * 5);
			}
		});
		
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	
	public Item randomPotion(int depth){
		switch ((int)(Math.random() * 9)){
		case 0: return newPotionOfHealth(depth);
		case 1: return newPotionOfHealth(depth);
		case 2: return newPotionOfMana(depth);
		case 3: return newPotionOfMana(depth);
		//case 4: return newPotionOfSlowHealth(depth);
		case 4: return newPotionOfPoison(depth);
	//	case 6: return newPotionOfWarrior(depth);
		//case 7: return newPotionOfArcher(depth);
		default: return newPotionOfExperience(depth);
		}
	}
	
	public Item newWhiteMagesSpellbook(int depth) {
		Item item = new Item('+', AsciiPanel.brightWhite, "white mage's spellbook", null);
		item.addWrittenSpell("minor heal", 4, new Effect(1){
			public void start(Creature creature){
				if (creature.hp() == creature.maxHp())
					return;
				
				creature.modifyHp(20, "Killed by a minor heal spell?");
				creature.doAction("look healthier");
			}
		});
		
		item.addWrittenSpell("major heal", 8, new Effect(1){
			public void start(Creature creature){
				if (creature.hp() == creature.maxHp())
					return;
				
				creature.modifyHp(50, "Killed by a major heal spell?");
				creature.doAction("look healthier");
			}
		});
		
		item.addWrittenSpell("slow heal", 12, new Effect(50){
			public void update(Creature creature){
				super.update(creature);
				creature.modifyHp(2, "Killed by a slow heal spell?");
			}
		});

		item.addWrittenSpell("inner strength", 16, new Effect(50){
			public void start(Creature creature){
				creature.modifyAttackValue(2);
				creature.modifyDefenseValue(2);
				creature.modifyVisionRadius(1);
				creature.modifyRegenHpPer1000(10);
				creature.modifyRegenManaPer1000(-10);
				creature.doAction("seem to glow with inner strength");
			}
			public void update(Creature creature){
				super.update(creature);
				if (Math.random() < 0.25)
					creature.modifyHp(1, "Killed by inner strength spell?");
			}
			public void end(Creature creature){
				creature.modifyAttackValue(-2);
				creature.modifyDefenseValue(-2);
				creature.modifyVisionRadius(-1);
				creature.modifyRegenHpPer1000(-10);
				creature.modifyRegenManaPer1000(10);
			}
		});
		
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	
	public Item newBlueMagesSpellbook(int depth) {
		Item item = new Item('+', AsciiPanel.brightBlue, "blue mage's spellbook", null);

		item.addWrittenSpell("blood to mana", 1, new Effect(1){
			public void start(Creature creature){
				int amount = Math.min(creature.hp() - 1, creature.maxMana() - creature.mana());
				creature.modifyHp(-amount, "Killed by a blood to mana spell.");
				creature.modifyMana(amount);
			}
		});
		
		item.addWrittenSpell("blink", 6, new Effect(1){
			public void start(Creature creature){
				creature.doAction("fade out");
				
				int mx = 0;
				int my = 0;
				
				do
				{
					mx = (int)(Math.random() * 11) - 5;
					my = (int)(Math.random() * 11) - 5;
				}
				while (!creature.canEnter(creature.x+mx, creature.y+my, creature.z)
						&& creature.canSee(creature.x+mx, creature.y+my, creature.z));
				
				creature.moveBy(mx, my, 0);
				
				creature.doAction("fade in");
			}
		});
		
		item.addWrittenSpell("summon bats", 11, new Effect(1){
			public void start(Creature creature){
				for (int ox = -1; ox < 2; ox++){
					for (int oy = -1; oy < 2; oy++){
						int nx = creature.x + ox;
						int ny = creature.y + oy;
						if (ox == 0 && oy == 0 
								|| creature.creature(nx, ny, creature.z) != null)
							continue;
						
						Creature bat = newBat(0);
						
						if (!bat.canEnter(nx, ny, creature.z)){
							world.remove(bat);
							continue;
						}
						
						bat.x = nx;
						bat.y = ny;
						bat.z = creature.z;
						
						creature.summon(bat);
					}
				}
			}
		});
		
		item.addWrittenSpell("detect creatures", 16, new Effect(75){
			public void start(Creature creature){
				creature.doAction("look far off into the distance");
				creature.modifyDetectCreatures(1);
			}
			public void end(Creature creature){
				creature.modifyDetectCreatures(-1);
			}
		});
		world.addAtEmptyLocation(item, depth);
		return item;
	}
	

	public Item randomSpellBook(int depth){
		switch ((int)(Math.random() * 2)){
		case 0: return newWhiteMagesSpellbook(depth);
		default: return newBlueMagesSpellbook(depth);
		}
	}
	
}
