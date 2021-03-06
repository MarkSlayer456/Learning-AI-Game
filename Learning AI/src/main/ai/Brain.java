package main.ai;

import java.util.Random;

public class Brain {

	public final static float chanceToMutate = 0.01f;
	
	private PVector[] directions;
	private int size;
	
	public Brain(int size) {
		this.size = size;
		this.directions = new PVector[size];
		randomizer();
	}
	
	public void randomizer() {
		for(int i = 0; i < directions.length; i++) {
			Random ran = new Random();
			int angel = ran.nextInt(360);
			Random ran1 = new Random();
			int mag = ran1.nextInt(Square.PVECTOR_LIMIT * 2);
			// the * 2 gives a higher chance to get the maximum speed which will be required most of the time
			// however in some cases slower speeds may be needed
			directions[i] = new PVector(mag, angel);
		}
	}
	
	public Brain clone() {
		Brain brain = new Brain(this.size);
		for(int i = 0; i < this.size; i++) {
			brain.directions[i] = this.getDirections(i);
		}
		return brain;
	}
	
	public Brain mutate() {
		for(int i = 0; i < this.directions.length; i++) {
			Random ran2 = new Random();
			float r = ran2.nextFloat();
			if(r < chanceToMutate) {
				Random ran = new Random();
				int angel = ran.nextInt(360);
				Random ran1 = new Random();
				int mag = ran1.nextInt(Square.PVECTOR_LIMIT * 2);
				// the * 2 gives a higher chance to get the maximum speed which will be required most of the time
				// however in some cases slower speeds may be needed
				this.directions[i] = new PVector(mag, angel);
			}
		}
		return this;
	}
	
	public PVector getDirections(int i) {
		return this.directions[i];
	}
	
	public Integer getSize() {
		return this.size;
	}
}
