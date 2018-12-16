package Rogue_like.Rogue_like;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class WinScreen implements Screen {
//////// ECRAN AFFICHER POUR UN GAGNANT /////
    public void displayOutput(AsciiPanel terminal) {

System.out.println("Bravooooooooo Vous avez gagné!!!!!!!!!!!!!!");
		
		terminal.write("Felicitations.", 1, 1);
		
		System.out.println("-----Appuyez entrer pour redemarrer----.");
		terminal.writeCenter("-- appuyer entrer pour une nouvelle partie --", 22);
        terminal.write("Bravooooooooo Vous avez gagné!!!!!!!!!!!!!!.", 5, 1);
        terminal.writeCenter("-- Press entr for reload --", 22);

    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    
}
}