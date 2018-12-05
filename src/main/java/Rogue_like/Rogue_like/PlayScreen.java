package Rogue_like.Rogue_like;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class PlayScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("Vous vous amusez.", 1, 1);
        terminal.writeCenter("-- appuyez sur échap pour perdre ou sur entrée pour gagner --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
        case KeyEvent.VK_ESCAPE: return new LoseScreen();
        case KeyEvent.VK_ENTER: return new WinScreen();
        }
    
        return this;
    }
}