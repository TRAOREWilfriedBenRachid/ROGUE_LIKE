package Rogue_like.Rogue_like;

import java.awt.Color;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import asciiPanel.AsciiPanel;
import Rogue_like.Rogue_like.Creature;
import Rogue_like.Rogue_like.Item;
import Rogue_like.Rogue_like.StuffFactory;
import Rogue_like.Rogue_like.FieldOfView;
import Rogue_like.Rogue_like.Tile;
import Rogue_like.Rogue_like.World;
import Rogue_like.Rogue_like.WorldBuilder;

public class PlayScreen implements Screen {
	private World world;
	private Creature player;
	private int screenWidth;
	private int screenHeight;
	private List<String> messages;
	private FieldOfView fov;
	private Screen subscreen;
	static long  chrono ;

	public PlayScreen(){
		System.out.println("Votre mission consiste a \n Descendez les grottes du moindre danger, \n retrouvez l'ours en peluche perdu pour gagner.\n Utilisez ce que vous trouvez pour éviter de mourir.:");
		
		System.out.println ("appuyer sur g ou , pour ramasser\n");
		System.out.println ("appuyer sur x pour examiner\n");
		System.out.println ("appuyer sur D pour supprimer un item de l'inventaire\n");
		
		System.out.println ("appuyer sur e pour manger les le pain ou la pomme ramassee\n");
		System.out.println ("appuyer sur ; pour voir le resume de votre ^partie\n");
		System.out.println ("appuyer sur entrer pour gagner\n si vous avez obtenu un score >100  et \n si vous avez recuperer litem V pour examiner\n");
		//AsciiPanel terminal;
		//terminal.writeCenter ("appuyer sur g pour ramasser\n", AsciiPanel.yellow, 22);
		
		screenWidth = 80;
		screenHeight = 23;
		messages = new ArrayList<String>();
		createWorld();
		fov = new FieldOfView(world);
		
		StuffFactory factory = new StuffFactory(world);
		createCreatures(factory);
		createItems(factory);
		
	}

	
	private void createCreatures(StuffFactory factory){
		player = factory.newPlayer(messages, fov);
		
		//if(player.xp()>1){
		//	for (int z = 0; z < world.depth(); z++)
		//	factory.newVictoryItem(z);
		//}
		
		
		for (int z = 0; z < world.depth(); z++){
			for (int i = 0; i < 4; i++){
				factory.newFungus(z);
				//factory.newVictoryItem(z);
			}
			for (int i = 0; i < 10; i++){
				factory.newBat(z);
				
			}
			//////////////////////////////////////generation de fruits
			for (int i = 0; i < 10; i++){
				factory.newFruit(z);
		}}
	}

	private void createItems(StuffFactory factory) {
		for (int z = 0; z < world.depth(); z++){
			for (int i = 0; i < world.width() * world.height() / 50; i++){
				factory.newRock(z);
			}

			factory.newFruit(z);
			//factory.newEdibleWeapon(z);
			factory.newBread(z);
			//factory.randomArmor(z);
			factory.randomWeapon(z);
			
			
			for (int i = 0; i < z + 1; i++){
				//factory.randomPotion(z);
				factory.newVictoryItem(z);
				//factory.randomSpellBook(z);
				
				////// OURS EN PELUCHE A EFFACER
		
	}}}
	
	private void createWorld(){
		world = new WorldBuilder(90, 32, 5)
					.makeCaves()
					.build();
	}
	
	public int getScrollX() { return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth)); }
	
	public int getScrollY() { return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight)); }
	
	//@Override
	public void displayOutput(AsciiPanel terminal) {
		int left = getScrollX();
		int top = getScrollY(); 
		
		displayTiles(terminal, left, top);
		displayMessages(terminal, messages);
		
		String stats = String.format(" %3d/%3d PV   %d/%d magie   %8s", player.hp(), player.maxHp(), player.mana(), player.maxMana(), hunger());
		String stats2 = String.format("%3d/%3d Score", player.xp(), 1000);
		int stats3 =   player.xp();
		terminal.write(stats2, 1,0);
		terminal.write(stats, 1, 23);
     ///terminal.write(stats2   , 1, 1);
     
     System.out.println("score  "+stats3);
     chrono = java.lang.System.currentTimeMillis() ; 
  
	//String s = chrono.getDureeTxt();
		System.out.println("chrono  "+chrono);
		//terminal.write(chrono, 2,1);
		
		if (subscreen != null)
			subscreen.displayOutput(terminal);
		
		
	}
	
	private String hunger(){
		if (player.food() < player.maxFood() * 0.10)
			return "Si vous ne mangez pas vous allez mourir de faim";
		else if (player.food() < player.maxFood() * 0.25)
			return "vous devez manger";
		else if (player.food() > player.maxFood() * 0.90)
			return "vous n'avez pas faim";
		else if (player.food() > player.maxFood() * 0.75)
			return "Vous avez abusé de la nourriture";
		else
			return "";
	}

	private void displayMessages(AsciiPanel terminal, List<String> messages) {
		int top = screenHeight - messages.size();
		for (int i = 0; i < messages.size(); i++){
			terminal.writeCenter(messages.get(i), top + i);
		}
		if (subscreen == null)
			messages.clear();
	}

	private void displayTiles(AsciiPanel terminal, int left, int top) {
		fov.update(player.x, player.y, player.z, player.visionRadius());
		
		for (int x = 0; x < screenWidth; x++){
			for (int y = 0; y < screenHeight; y++){
				int wx = x + left;
				int wy = y + top;

				if (player.canSee(wx, wy, player.z))
					terminal.write(world.glyph(wx, wy, player.z), x, y, world.color(wx, wy, player.z));
				else
					terminal.write(fov.tile(wx, wy, player.z).glyph(), x, y, Color.darkGray);
			}
		}}
	
	//@Override
	public Screen respondToUserInput(KeyEvent key) {
		int level = player.level();
		
		if (subscreen != null) {
			subscreen = subscreen.respondToUserInput(key);
		} else {
			switch (key.getKeyCode()){
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_H: player.moveBy(-1, 0, 0); break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_L: player.moveBy( 1, 0, 0); break;
			case KeyEvent.VK_UP:
			case KeyEvent.VK_K: player.moveBy( 0,-1, 0); break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_J: player.moveBy( 0, 1, 0); break;
			case KeyEvent.VK_Y: player.moveBy(-1,-1, 0); break;
			case KeyEvent.VK_U: player.moveBy( 1,-1, 0); break;
			case KeyEvent.VK_B: player.moveBy(-1, 1, 0); break;
			case KeyEvent.VK_N: player.moveBy( 1, 1, 0); break;
						
			case KeyEvent.VK_D: subscreen = new DropScreen(player); break;
			case KeyEvent.VK_E: subscreen = new MangeScreen(player); break;
		
			case KeyEvent.VK_X: subscreen = new ExamineScreen(player); break;
			case KeyEvent.VK_SEMICOLON: subscreen = new LookScreen(player, "Looking", 
					player.x - getScrollX(), 
					player.y - getScrollY()); break;
//					
			
			
			//:::: le joueur gagne siii il a un score > 100 et sil a pu prendre litem ours en peluche ie litem de victoire
			case KeyEvent.VK_ENTER: if (player.xp()> 100){
				for (Item item : player.inventory().getItems()){
					if (item != null && item.name().equals("ours en peluche "))
			
				return new GagneScreen();}}
			
			
			case KeyEvent.VK_R: subscreen = new ReadScreen(player,
				player.x - getScrollX(), 
						player.y - getScrollY()); break;
			}
			
			switch (key.getKeyChar()){
			case 'g':
			case ',': player.pickup(); break;
			
			
			case '<': 
				if (userIsTryingToExit())
					return userExits();
				else
					player.moveBy( 0, 0, -1); break;
			case '>': player.moveBy( 0, 0, 1); break;
			//case '?': subscreen = new HelpScreen(); break;
			}
		}

		if (player.level() > level)
			subscreen = new LevelUpScreen(player, player.level() - level);
		
		if (subscreen == null)
			world.update();
		
		if (player.hp() < 1)
			return new PerdScreen(player);
		
		return this;
	}

	private boolean userIsTryingToExit(){
		return player.z == 0 && world.tile(player.x, player.y, player.z) == Tile.STAIRS_UP;
	}
	
	private Screen userExits(){
		
		for (Item item : player.inventory().getItems()){
			if (item != null && item.name().equals("ours en peluche"))
			
				return new GagneScreen();
			
		}
		player.modifyHp(0, "tu� en fuyant les cavernes.");
		return new PerdScreen(player);
	}
	
	
	
		
	}
	




