package Rogue_like.Rogue_like;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import asciiPanel.AsciiPanel;

public class PlayerAiTest {

	public PlayerAi playerAi;
	
	@Test
	public void test() {
		
		List<String> messages = new ArrayList<String>();
		
		World world = new WorldBuilder(90, 32, 5).makeCaves().build();
		
		FieldOfView fov = new FieldOfView(world);
		Creature creature = new Creature(world, '@', AsciiPanel.brightWhite, "joueur", 100, 20, 5);
		PlayerAi player = new PlayerAi(creature, messages, fov);
		
		
	
	}

}
