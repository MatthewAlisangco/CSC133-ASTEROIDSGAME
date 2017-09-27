package com.mycompany.a1;

public class Missiles extends MoveableObject {
	private int fuellevel;

	public void steerLeft() {} /* Not applicable */
	public void steerRight() {} /* Not applicable */

	public Missiles(int direction, int inspeed, float x, float y) {
		this.fuellevel = 10;
		super.setSpeed(inspeed + 10);
		super.setDirection(direction);
		super.setLocation(x, y);
	}

	public void move() {
		this.fuellevel -= 1;
		super.move();

	}

	public void setFuelLevel(int inFuellevel) {
		this.fuellevel = inFuellevel;
	}

	public int getFuelLevel() {
		return this.fuellevel;
	}

	public String toString(){
		return "Missiles: " + super.toString() + "fuel=" + this.fuellevel; 
	}
}
