package main;

import java.awt.Dimension;
import java.util.Random;

import main.ai.Population;
import main.objects.Objective;
import main.objects.Wall;

public class Main implements Runnable {

	
	public static UIManager ui = new UIManager(new Dimension(800, 600));
	public static Main main = new Main();
	public static Thread mainThread;
	
	public static final double graphicsFrameRate = 16.66667; // 60 fps
	public static final double logicFrameRate = 16.66667; // 60 fps
	
	public final static FrameRateManager frame = new FrameRateManager(graphicsFrameRate);
	public final static FrameRateManager logic = new FrameRateManager(logicFrameRate);
	
	public static final int populationSize = 10000;
	
	public static Wall[] walls = new Wall[100];
	public static Population pop = new Population(populationSize);
	public static Objective obj = new Objective();
	public static int gen = 1;
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		mainThread = new Thread(main, "main");
		mainThread.start();
	}
	
	private boolean wallsSetup = false; // TODO remove this later
	
	/**
	 * Manages logic of the game.
	 */
	public void doLogic() {
		////////////////////////////////////////////////////////////////////////////
		//TODO everything in this section will be removed at a later date this is just for testing
		if(!wallsSetup) {
		Random ran = new Random();
		walls[0] = new Wall(ran.nextInt(700) + 100, (ran.nextInt(375) + 100), 50, 50);
		walls[1] = new Wall(ran.nextInt(700) + 100, (ran.nextInt(375) + 100), 50, 50);
		walls[2] = new Wall(ran.nextInt(700) + 100, (ran.nextInt(375) + 100), 50, 50);
		walls[3] = new Wall(ran.nextInt(700) + 100, (ran.nextInt(375) + 100), 50, 50);
//		walls[4] = new Wall(100, 400, 50, 100);
//		walls[5] = new Wall(100, 300, 50, 50);
//		walls[6] = new Wall(200, 300, 50, 50);
//		walls[7] = new Wall(300, 300, 50, 50);
//		walls[8] = new Wall(400, 300, 50, 50);
//		walls[9] = new Wall(500, 300, 50, 50);
//		walls[10] = new Wall(100, 200, 50, 50);
//		walls[11] = new Wall(200, 200, 50, 50);
//		walls[12] = new Wall(300, 200, 50, 50);
//		walls[13] = new Wall(400, 200, 50, 50);
//		walls[14] = new Wall(500, 200, 50, 50);
//		walls[15] = new Wall(600, 400, 50, 50);
//		walls[16] = new Wall(600, 300, 50, 50);
//		walls[17] = new Wall(600, 200, 50, 50);
		wallsSetup = true;
		}
		///////////////////////////////////////////////////////////////////////////////
		pop.doLogic(walls, obj);
	}
	
	@Override
	public void run() {
		while(true) {
			logic.setStartingTime(System.currentTimeMillis());
			doLogic();
			logic.setEndingTime(System.currentTimeMillis());
			frame.setStartingTime(System.currentTimeMillis());
			ui.draw();
			frame.setEndingTime(System.currentTimeMillis());
		}
	}
	
	public void terminate() {
		System.exit(0);
	}

}
