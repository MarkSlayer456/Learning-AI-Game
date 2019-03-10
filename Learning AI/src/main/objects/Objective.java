package main.objects;

import main.ai.Square;

public class Objective {

	
	private double x;
	private double y;
	private double length;
	// this object is a square
	
	public Objective() {
		this.x = 300;
		this.y = 100;
		this.length = 25;
		
	}
	
	public boolean checkIfReached(Square sq) {
			if(sq.getX() + sq.getLength() < this.getX() + this.getLength() && 
			sq.getX() > this.getX() && sq.getY() + sq.getLength() < this.getY() + this.getLength() && sq.getY() > this.getY()) {
				sq.setObjectComplete(true);
				return true;
			}
			return false;
	}
	
	
	public double getLength() {
		return this.length;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	
	
}
