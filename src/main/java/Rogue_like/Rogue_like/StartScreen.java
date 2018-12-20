package Rogue_like.Rogue_like;


import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;


public class StartScreen implements Screen {
	///Chronometre chrono = new Chronometre();
//////// ECRAN DE DEMARRAGE /////
    public void displayOutput(AsciiPanel terminal) {
    	
    			
    			terminal.write("*****************************************************************************", 1, 1);
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
    			
    			terminal.write("***************************** Roguelike ***************************", 1, 1);
    			//terminal.createImage(100, 200);
    			//terminal.repaint();
    			///terminal.prepareImage("b.jpg", 20, 20, ImageObserver );
    			terminal.writeCenter("-- appuyer [entrer] pour commencer --", 22);
    			System.out.println("Appuyer sur entrer pour comnencer le jeu");
    			System.out.println("Bonne partie  Roguelike !!!!!!!");
    			
    	
    	
       
       // terminal.setBackground(AsciiPanel.white);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
