package main.ai;

import java.util.Random;

import main.objects.Objective;
import main.objects.Wall;

public class Population {
	
	public static float CHANCEOFDUMBBABY = 0.025f;
	public static Square bestOfBest = new Square();
	
	private Square[] squares;
	private int size;
	private int alive;
	
	
	public Population(int size) {
		this.size = size;
		squares = new Square[size];
		for(int i = 0; i < squares.length; i++) {
			squares[i] = new Square();
		}
		this.alive = size;
	}
	
	public void doLogic(Wall[] walls, Objective obj) {
		for(int i = 0; i < this.size; i++) {
			squares[i].move();
			for(int j = 0; j < walls.length; j++) {
				if(walls[j] != null) {
					walls[j].checkIfHit(squares[i]);
				}
			}
			obj.checkIfReached(squares[i]);
		}
	}
	
	
	public Square selectParent() {
		Square top = bestOfBest;
		for(int i = 0; i < squares.length; i++) {
			if(top == null) {
				top = squares[i];
			} else if(top.getFitness() < squares[i].getFitness()) {
				top = squares[i];
			}
		}
		System.out.println("top fitness : " + top.getFitness());
		System.out.println("Stpes taken : " + top.getStepsTaken());
		if(top.getFitness() >= bestOfBest.getFitness()) {
			bestOfBest = top;
		}
		return top;
	  }
	
	public Square[] getSquares() {
		return squares;
	}
	
	
	public void recreate() {
		Square parent = selectParent();
		for(int i = 0; i < squares.length; i++) {
			Random ran = new Random();
			float r = ran.nextFloat();
			if(r < CHANCEOFDUMBBABY) {
				 squares[i] = new Square();
			} else {
				squares[i] = parent.makeChild();
			}
		}
		this.alive = this.size;
	}
	
	public int getAmountAlive() {
		return this.alive;
	}
	
	public void setAmountAlive(int amount) {
		this.alive = amount;
	}
	
	public int getSize() {
		return this.size;
	}
}
