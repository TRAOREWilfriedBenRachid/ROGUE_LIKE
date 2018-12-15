package Rogue_like.Rogue_like;

public abstract class LevelUpOption {
	private String name;
	public String name() { return name; }
	
	public LevelUpOption(String name){
		this.name = name;
	}
	
	public abstract void invoke(Creature creature);
}
