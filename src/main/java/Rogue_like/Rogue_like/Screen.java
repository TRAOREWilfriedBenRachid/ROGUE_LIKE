package Rogue_like.Rogue_like;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public interface Screen {
    public void displayOutput(AsciiPanel terminal);

    public Screen respondToUserInput(KeyEvent key);
}
