package main.objects;

import main.ai.Square;

public class Wall {
	
	public static Wall[] walls; // TODO change to array list
	private double x;
	private double y;
	private double height;
	private double width;
	
	
	public Wall(double x, double y, double height, double width) {
		setX(x);
		setY(y);
		setHeight(height);
		setWidth(width);
	}
	
	public void checkIfHit(Square sq) {
		if((sq.getX() + sq.getLength() < this.getX() + this.getWidth()) && 
		(sq.getX() > this.getX()) && (sq.getY() + sq.getLength() < this.getY() + this.getHeight()) && (sq.getY() > this.getY())) {
			sq.setHitWall(true);
		}
	}


	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}


	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}


	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}


	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}


	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

}
