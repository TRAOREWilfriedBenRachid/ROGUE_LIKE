package Rogue_like.Rogue_like;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("                       JEUX DE ROGUE LIKE", 1, 1);
        terminal.writeCenter("-- Appuyez sur entrée pour démarrer --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
