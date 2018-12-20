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

		
	public StuffFactory(World world){
		this.world = world;
		

	}
	
	
	public Creature newPlayer(List<String> messages, FieldOfView fov){
		Creature player = new Creature(world, 'j', AsciiPanel.brightWhite, "joueur", 100, 20, 5);
		world.addAtEmptyLocation(player, 0);
		new PlayerAi(player, messages, fov);
		return player;
	}
	
	public Creature newFungus(int depth){
		Creature fungus = new Creature(world, 'c', AsciiPanel.green, "tortue", 10, 0, 0);
		world.addAtEmptyLocation(fungus, depth);
		new FungusAi(fungus, this);
		new BatAi(fungus);
		return fungus;
	}
	
	public Creature newBat(int depth){
		Creature bat = new Creature(world, 's', AsciiPanel.brightYellow, "serpent", 15, 5, 0);
		world.addAtEmptyLocation(bat, depth);
		new BatAi(bat);
		return bat;
	}
	

	
	public Item newRock(int depth){
		Item rock = new Item(',', AsciiPanel.yellow, "pierre", null);
		rock.modifyThrownAttackValue(5);
		world.addAtEmptyLocation(rock, depth);
		return rock;
	}
	
	public Item newVictoryItem(int depth){
		Item item = new Item('V', AsciiPanel.brightWhite, "coupe", null);
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
		Item item = new Item('%', AsciiPanel.green, "une pomme", null);
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
	
	
	
	

	
	public Item randomWeapon(int depth){
		switch ((int)(Math.random() * 3)){
		case 0: return newDagger(depth);
		//case 1: return newSword(depth);
		default: return newSword(depth);
		}
	}


	
	
	
	
	
}
