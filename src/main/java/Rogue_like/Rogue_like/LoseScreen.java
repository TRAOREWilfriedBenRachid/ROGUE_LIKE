package Rogue_like.Rogue_like;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
////////ECRAN POUR PERDANT /////
public class LoseScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        //terminal.setBackground(AsciiPanel.yellow);
        terminal.write("you 're loser.", 1, 1);
        terminal.writeCenter("-- Press  entry  for reload --", 22);
    
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}