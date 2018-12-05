package Rogue_like.Rogue_like;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {
//////// ECRAN DE DEMARRAGE /////
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("                        ROGUE LIKE GAME", 1, 1);
        terminal.writeCenter("-- Press  entry  for reload --", 22);
       // terminal.setBackground(AsciiPanel.white);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
