package main;

import main.objects.Objective;
import main.objects.Wall;

public class Level {
	
	private Wall[] walls;
	private int levelCount;
	private Objective obj;
	
	/**
	 * The level constructor
	 * @param walls - Array of walls that exists in the level
	 * @param levelCount - The level number
	 * @param obj - The objective in the level
	 */
	public Level(Wall[] walls, int levelCount, Objective obj) {
        this.walls = walls;
        this.levelCount = levelCount;
        this.obj = obj;
	}
	
	/**
	 * Creates all levels that are in the game.
	 */
	public static void createLevels() {
		// This way will cause all the levels to be loaded at the start of the program, it's small it should be fine
	}
	
	/**
	 * Checks the walls in the active level to see if the AI or player hits them,
	 * if so they are killed
	 */
	public void checkIfHitWall() {
		
	}
	
	/**
	 * Checks the objective in the active level to see if the AI or player hits
	 * it, if so they are killed
	 */
	public void checkIfHitObjective() {
		
	}
	
	// Setters //
	/**
	 * Sets the wall array.
	 * @param walls - Wall array to be set
	 */
	public void setWalls(Wall[] walls) {
		this.walls = walls;
	}
	
	/**
	 * Sets the level count.
	 * @param levelCount - The level you want to set as the current level
	 */
	public void setLevelCount(int levelCount) {
		this.levelCount = levelCount;
	}
	
	/**
	 * Sets the objective for the given level.
	 * @param obj - The objective you want to set
	 */
	public void setObj(Objective obj) {
		this.obj = obj;
	}
	
	// Getters //
	
	/**
	 * Returns walls array.
	 * @return - The walls of the given level
	 */
	public Wall[] getWalls() {
		return walls;
	}

	/**
	 * Returns the current level.
	 * @return - The number of the level
	 */
	public int getLevelCount() {
		return levelCount;
	}

	/**
	 * Returns an objective object
	 * @return - The objective object for the given level
	 */
	public Objective getObj() {
		return obj;
	}
}
