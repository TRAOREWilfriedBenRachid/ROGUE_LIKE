package Rogue_like.Rogue_like;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class GagneScreen implements Screen {
	//private Creature player;
//////// ECRAN AFFICHER POUR UN GAGNANT /////
//	public WinScreen(Creature player){
//		this.player = player;
//	}
    public void displayOutput(AsciiPanel terminal) {

System.out.println("Bravooooooooo Vous avez gagné!!!!!!!!!!!!!!");
		
		terminal.writeCenter("Felicitations.", 1);
		//terminal.write("*****************************************************************************", 1, 1);
		terminal.write("***************************************************************************", 2, 2);
		terminal.write("*************************************************************************", 3, 3);
		terminal.write("***********************************************************************", 4, 4);
		terminal.write("*********************************************************************", 5, 5);
		terminal.write("*******************************************************************", 6, 6);
		terminal.write("*****************************************************************", 7, 7);
		terminal.write("***************************************************************", 8, 8);
		terminal.write("*************************************************************", 9, 9);
		terminal.write("***********************************************************", 10, 10);
		terminal.write("*********************************************************", 11, 11);
		terminal.write("*******************************************************", 12, 12);
		terminal.write("*****************************************************", 13, 13);
		terminal.write("***************************************************", 14, 14);
		
		System.out.println("-----Appuyez entrer pour redemarrer----.");
		terminal.writeCenter("-- appuyer entrer pour une nouvelle partie --", 22);
        terminal.writeCenter("Bravooooooooo Vous avez gagnee!!!!!!!!!!!!!!.", 5);
        terminal.writeCenter("-- Appuyez entrer pour redemarrer --", 22);
     ////   String stats2 = String.format(" Vous avez obtenu le Score de %3d points", player.xp());
		//terminal.write(stats2, 20,10);

    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    
}
}