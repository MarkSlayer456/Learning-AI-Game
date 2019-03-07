package main.ai;

public class PVector {
	
	private double magnitude;
	private int direction;
	private int limit = 25;
	
	public PVector(int magnitude, int direction) {
		this.magnitude = magnitude;
		this.direction = direction;
	}
	
	public PVector() {
		this.magnitude = 0;
		this.direction = 0;
	}
	
	public void add(PVector addVector) {
		this.magnitude += addVector.magnitude;
		if(this.limit >= this.magnitude) {
			this.magnitude = this.limit;
		}
		this.direction = addVector.direction;
	}
	
	// TODO update this if needed
	/*public void sub(PVector subVector) {
		this.magnitude -= subVector.magnitude;
		this.direction -= subVector.direction;
	}*/
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public double getDir() {
		return this.direction;
	}
	
	public double getMag() {
		return this.magnitude;
	}
	
	public void reset() {
		this.magnitude = 0;
		this.direction = 0;
	}
		
	
	
}
