package Rogue_like.Rogue_like;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class WinScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("you are winner.", 5, 1);
        terminal.writeCenter("--#### Press entry for reload### --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}