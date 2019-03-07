package main;

import main.objects.Objective;
import main.objects.Wall;

public class Level {
	
	private Wall[] walls;
	private int levelCount;
	private Objective obj;
	
	
	public Level(Wall[] walls, int levelCount, Objective obj) {
		setWalls(walls);
		setLevelCount(levelCount);
		setObj(obj);
	}
	
	public static void createLevels() {
		// This way will cause all the levels to be loaded at the start of the program, it's small it should be fine
	}
	
	
	public void checkIfHitWall() {
		
	}
	
	public void cehckIfHitObjective() {
		
	}
	
	
	
	public Wall[] getWalls() {
		return walls;
	}

	public void setWalls(Wall[] walls) {
		this.walls = walls;
	}

	public int getLevelCount() {
		return levelCount;
	}

	public void setLevelCount(int levelCount) {
		this.levelCount = levelCount;
	}

	public Objective getObj() {
		return obj;
	}

	public void setObj(Objective obj) {
		this.obj = obj;
	}
}
