package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Ship extends MoveableObject {
	private int missilecount = 10;
	private static Ship tiefighter;

	
	private Ship() {
		super.setLocation(512, 384);
		super.setSpeed(0);
		super.setDirection(0);
		super.setColor(0, 255, 10);
	}
	

	public static Ship getShip () {
		if (tiefighter == null) {
			tiefighter = new Ship();
			System.out.println("Ship created");
		}
		return tiefighter;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public Ship(int x, int y, int speed, int direction, int r, int g, int b) {
		super.setLocation(x, y);
		super.setSpeed(speed);
		super.setDirection(direction);
		super.setColor(r, g, b);
	}

	public void fire() {
		if (missilecount <= 0)
			missilecount = 0;
		else {
			this.missilecount--;
		}
	}

	public void reload() {

	}

	public void move() {
		super.move();
	}

	public void setMissiles(int inMissiles) {
		this.missilecount = inMissiles;
	}

	public int getMissiles() {
		return this.missilecount;
	}

	public void incSpeed() {
		int currSpeed = super.getSpeed() + 5;
		super.setSpeed(currSpeed);
	}

	public void decSpeed() {
		if (super.getSpeed() <= 0) {
			super.setSpeed(0);
		}
		int currSpeed = super.getSpeed() - 5;
		super.setSpeed(currSpeed);
	}

	public void steerLeft() {
		int currDirection = super.getDirection() + 90;
		super.setDirection(currDirection);

	}

	public void steerRight() {
		int currDirection = super.getDirection() - 90;
		super.setDirection(currDirection);

	}

	public int getDirection() {
		return super.getDirection();
	}

	public String toString() {
		return "Ship: " + super.toString() + " missiles=" + this.missilecount;

	}

	public void setLocation(float inX, float inY) {
		super.setLocation(inX, inY);
	}

}
