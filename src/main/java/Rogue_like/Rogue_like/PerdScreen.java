package Rogue_like.Rogue_like;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class PerdScreen implements Screen {
	private Creature player;
	
	public PerdScreen(Creature player){
		this.player = player;
	}
	
	public void displayOutput(AsciiPanel terminal) {
		
		//////////game over////////////
		terminal.writeCenter("GAME OVER", 4);
		//terminal.writeCenter("***********************************************************************************",3,1);
		terminal.writeCenter("----------------------------------", 5);
		terminal.writeCenter("-----------------------------------", 6);
		terminal.writeCenter("------Envie de retenter????????----", 7);
		terminal.writeCenter(player.causeOfDeath(), 5);
		String stats2 = String.format(" Vous avez obtenu le Score de %3d points", player.xp());
		terminal.write(stats2, 20,10);
		
	    terminal.writeCenter("-- appuyer [entrer] pour rejouer --", 22);
	    
	    System.out.println("game over");
	       String s= player.causeOfDeath(); 
	       System.out.println(s);
	       System.out.println("-- appuyer [entrer] pour rejouer --");
	
	
	}
	
	
//////si on appuie enter alors restart the game/////
//	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}
