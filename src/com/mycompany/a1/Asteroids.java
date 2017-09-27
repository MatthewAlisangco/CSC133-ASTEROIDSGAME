package com.mycompany.a1;
import java.util.Random;

public class Asteroids extends MoveableObject{
	private int rocksize;
	public void steerLeft() {}  /* Not applicable */
	public void steerRight() {} /* Not applicable */
	
	public Asteroids(){
		this.rocksize = RandomNumber();
		super.setLocation(RandomNumber(), RandomNumber());
		super.setSpeed(RandSpeed());
		super.setDirection(RandDirection());
		super.setColor(255,0,0);
	}

	public void move() {
		super.move();
	}
	
	public void setRockSize(int inSize){
		this.rocksize = inSize;
	}
	
	public int getRockSize(){
		return this.rocksize;
	}
	
	private int RandomNumber(){
		int max = 100;
		int min = 1;
		Random randomNum = new Random();
		int randomNumber = min + randomNum.nextInt(max);
		return randomNumber;
	}

	private int RandSpeed(){
		int max = 10;
		int min = 1;
		Random randomNum = new Random();
		int randomNumber = min + randomNum.nextInt(max);
		return randomNumber;
	}
	
	private int RandDirection(){
		int max = 359;
		int min = 0;
		Random randomNum = new Random();
		int randomNumber = min + randomNum.nextInt(max);
		return randomNumber;
	}
	
	public String toString(){
		
	return "Asteroids: " + super.toString() + " size=" + this.rocksize;
	}

}
