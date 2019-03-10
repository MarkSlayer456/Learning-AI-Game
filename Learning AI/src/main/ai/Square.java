package main.ai;

import main.Main;
import main.objects.Objective;

public class Square {

	public static final int PVECTOR_LIMIT = 3;
	public static final int BRAIN_SIZE = 500;
	
	private PVector state;
	private PVector acc;
	private PVector vel;
	private int length;
	private boolean alive;
	private double x;
	private double y;
	private Brain brain;
	private float fitness;
	private boolean complete; // is the objective complete
	Objective currentObj;
	private int stepsTaken;
	private boolean hitWall;
	
	public Square() {
		this.state = new PVector();
		this.acc = new PVector();
		this.vel = new PVector();
		this.length = 5;
		this.x = 300;
		this.y = 500;
		this.alive = true;
		this.brain = new Brain(BRAIN_SIZE);
		this.fitness = 0;
		this.complete = false;
		this.currentObj = Main.obj;
		this.hitWall = false;
	}
	
	public void move() {
		if(this.isAlive() && !(isObjectiveComplete())) {
			if(this.getHitWall()) {
				this.killSquare();
			}
			if(this.stepsTaken >= this.getBrain().getSize()) {
				this.killSquare();
			} else {
				this.acc = this.getBrain().getDirections(this.stepsTaken);
				this.vel.add(this.acc);
				this.vel.setLimit(PVECTOR_LIMIT);
				this.state.setLimit(PVECTOR_LIMIT);
				this.state.add(this.vel);
				this.vel.reset();
				
				double x = Math.toRadians(Math.cos(Math.toRadians(this.state.getDir()))) * this.state.getMag();
				double y = Math.toRadians(Math.sin(Math.toRadians(this.state.getDir()))) * this.state.getMag();
//				System.out.println(this.getX() - y);
//				System.out.println(this.getY() - x);
				if(!Main.obj.checkIfReached(this)) {
					for(int i = 0; i < x; i++) {
						this.setX(this.getX() + i);
					}
				}
				if(!Main.obj.checkIfReached(this)) {
					for(int i = 0; i > x; i--) {
						this.setX(this.getX() + i);
						Main.obj.checkIfReached(this);
					}
				}
				if(!Main.obj.checkIfReached(this)) {
					for(int i = 0; i < y; i++) {
						this.setY(this.getY() + i);
					}
				}
				if(!Main.obj.checkIfReached(this)) {
					for(int i = 0; i > y; i--) {
						this.setY(this.getY() + i);
					}
				}
//				this.setY(y);
				this.stepsTaken++;
				if(this.getX() > 750 || this.getX() < 50 || this.getY() > 550 || this.getY() < 50) {
					this.killSquare();
				}
			}
		} else {
			if(isAlive()) completeObjective();
		}
	}
	
	public void completeObjective() {
		Main.pop.setAmountAlive(Main.pop.getAmountAlive() - 1);
		this.setAlive(false);
		this.calculateFitness();
		if(Main.pop.getAmountAlive() == 0) {
			Main.pop.recreate();
			Main.gen++;
		}
	}
	
	public void killSquare() {
		this.setAlive(false);
		this.calculateFitness();
		Main.pop.setAmountAlive(Main.pop.getAmountAlive() - 1);
		if(Main.pop.getAmountAlive() == 0) {
			Main.pop.recreate();
			Main.gen++;
		}
	}
	
	public void calculateFitness() {
		float score = 10000;
		for(int i = 0; i < this.stepsTaken; i++) {
			score += 10f;
		}
		if(this.hitWall) {
			score -= 100f;
		}
		if(this.isObjectiveComplete()) {
			score += 100 * (BRAIN_SIZE - this.stepsTaken) * 2;
			for(int i = 0; i < this.stepsTaken; i++) {
				score -= 20f;
			}
		} else if(!this.isAlive()) {
			score -= 100f;
		}
		this.fitness = score;
	}
	
	public Square makeChild() {
		Square child = new Square();
		child.setBrain(this.getBrain().clone().mutate());
		return child;
	}
	
	public Square makePerfectChild() {
		Square child = new Square();
		child.setBrain(this.getBrain().clone());
		return child;
	}
	
	public boolean isObjectiveComplete() {
		return this.complete;
	}
	
	public void modifyFitness(int modify) {
		this.fitness += modify;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public Brain getBrain() {
		return this.brain;
	}
	
	public void setBrain(Brain brain) {
		this.brain = brain;
	}
	
	public float getFitness() {
		return this.fitness;
	}
	
	public void setObjectComplete(boolean bool) {
		this.complete = bool;
	}
	
	public int getStepsTaken() {
		return this.stepsTaken;
	}
	
	public void setHitWall(boolean bool) {
		this.hitWall = bool;
	}
	
	public boolean getHitWall() {
		return this.hitWall;
	}
}
