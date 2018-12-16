package Rogue_like.Rogue_like;

public class BatAi extends CreatureAi {

	public BatAi(Creature creature) {
		super(creature);
	}
	

	public void onUpdate(){
		wander();
		wander();
	}
}
