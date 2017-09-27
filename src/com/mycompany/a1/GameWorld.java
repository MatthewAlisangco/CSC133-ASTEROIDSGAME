package com.mycompany.a1;

import java.util.Iterator;
import java.util.Vector;
import com.codename1.charts.util.ColorUtil;

public class GameWorld {
	private int playerscore, clock, lives;
	private Vector<GameObject> spaceObjects;
	
	public void init() {
		playerscore = 0;
		clock = 0;
		lives = 3;
		spaceObjects = new Vector<GameObject>();
	}

	public void addAsteroid() {
		spaceObjects.add(new Asteroids());
	}

	public void addSpaceStation() {
		SpaceStation deathstar = SpaceStation.getSpaceStation();
		deathstar.setBlinkrate(2);
		spaceObjects.add(deathstar);
		
		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.elementAt(i) instanceof FixedObject) {
				if ((!spaceObjects.contains(deathstar))) {
					spaceObjects.add(deathstar);
					break;
				}
				else {
					System.out.println("space station exists");
					deathstar.toString();
					break;
				}
			}
		}
	}

	public void addShip() {
		Ship playership = Ship.getShip();
		
		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.elementAt(i) instanceof MoveableObject) {
				if ((!spaceObjects.contains(playership))) {
					spaceObjects.add(playership);
					break;
				}
				else {
					System.out.println("ship exists");
					playership.toString();
					break;
				}
			}
		}
			
		}
		
	public void increaseShipSpeed() {
		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.elementAt(i) instanceof MoveableObject) {
				if (spaceObjects.elementAt(i) instanceof Ship) {
					Ship shpObj = (Ship) spaceObjects.elementAt(i);
					shpObj.incSpeed();
					System.out.println("Ship speed increased: " + shpObj.toString());
				}
			}
		}
	}

	public void decreaseShipSpeed() {
		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.elementAt(i) instanceof MoveableObject) {
				if (spaceObjects.elementAt(i) instanceof Ship) {
					Ship shpObj = (Ship) spaceObjects.elementAt(i);
					shpObj.decSpeed();
					System.out.println("Ship speed decreased: " + shpObj.toString());
				}
			}
		}
	}

	public void turnShipLeft() {
		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.elementAt(i) instanceof MoveableObject) {
				if (spaceObjects.elementAt(i) instanceof Ship) {
					Ship shpObj = (Ship) spaceObjects.elementAt(i);
					shpObj.steerLeft();
					System.out.println("Ship speed decreased: " + shpObj.toString());
				}
			}
		}
	}

	public void turnShipRight() {
		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.elementAt(i) instanceof MoveableObject) {
				if (spaceObjects.elementAt(i) instanceof Ship) {
					Ship shpObj = (Ship) spaceObjects.elementAt(i);
					shpObj.steerRight();
					System.out.println("Ship speed decreased: " + shpObj.toString());
				}
			}
		}
	}

	public void FireMissiles() {
		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.elementAt(i) instanceof MoveableObject) {
				if (spaceObjects.elementAt(i) instanceof Ship) {
					Ship shpObj = (Ship) spaceObjects.elementAt(i);
					shpObj.incSpeed();
					if (shpObj.getMissiles() > 0)
						System.out.println("Firing");
					spaceObjects.add(new Missiles(shpObj.getDirection(), shpObj.getSpeed(), shpObj.getX(), shpObj.getY()));
					shpObj.fire();
			
					if (shpObj.getMissiles() == 0) // accidently removes ship
						System.out.println("you are out of missiles, reload");
				}
			}

		}
	}

	public void tickTimer() {
		System.out.println("clock current time:" + this.clock);
		clock++;
		System.out.println("Elapsed time:" + this.clock);
		for (int i = 0; i < spaceObjects.size(); i++) {

			if (spaceObjects.elementAt(i) instanceof Ship) {
				Ship shpObj = (Ship) spaceObjects.elementAt(i);
				shpObj.move();
				System.out.println("the Ship is moving" + shpObj.toString());
			}

			if (spaceObjects.elementAt(i) instanceof Asteroids) {
				Asteroids mObj = (Asteroids) spaceObjects.elementAt(i);
				mObj.move();
				System.out.println("this object is moving" + mObj.toString());

			}

			if (spaceObjects.elementAt(i) instanceof Missiles) {
				Missiles mObj = (Missiles) spaceObjects.elementAt(i);
				if (mObj.getFuelLevel() > 0) {
					mObj.move();
					System.out.println("the missile is moving" + mObj.toString());
				}
				if (mObj.getFuelLevel() == 0)
					System.out.println("Missile ran out of fuel" + mObj.toString());
				spaceObjects.removeElementAt(i);
			}
		}
	}

	public void printMap() {
		Iterator<GameObject> itr = spaceObjects.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}
	
	public void printCurrentStateOfGame(){
		int missilecountinstance = 0;
		for (int i = 0; i < spaceObjects.size(); i++) {

			if (spaceObjects.elementAt(i) instanceof Ship) {
				Ship shpObj = (Ship) spaceObjects.elementAt(i);
				missilecountinstance = shpObj.getMissiles();

			}
		}
		System.out.println("Playerscore: " + this.playerscore + " " + "Elapsed time: " + this.clock + " ship missilecount: " + missilecountinstance);
		
	}

	public void jumpHyperspace() {
		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.elementAt(i) instanceof MoveableObject) {
				if (spaceObjects.elementAt(i) instanceof Ship) {
					Ship shpObj = (Ship) spaceObjects.elementAt(i);
					shpObj.setLocation(512, 384);
					System.out.println("Jumped to hyperspace " + shpObj.toString());
				}
			}
		}
	}
	
	
	public void rearmFromStation(){
		for (int i = 0; i < spaceObjects.size(); i++)
		if (spaceObjects.elementAt(i) instanceof MoveableObject) {
			if (spaceObjects.elementAt(i) instanceof Ship) {
				Ship shpObj = (Ship) spaceObjects.elementAt(i);
				shpObj.reload();
				System.out.println("Rearming: " + shpObj.toString());
			}
		}
		
	}

	public void shipCollideWithAsteroid(){
		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.elementAt(i) instanceof MoveableObject) {
				if (spaceObjects.elementAt(i) instanceof Ship) {
					spaceObjects.removeElementAt(i);
					decrementlife();
				}
				
				if (spaceObjects.elementAt(i) instanceof Asteroids) {
					spaceObjects.removeElementAt(i);
				}
			}
		}
	}
	

	public void asteroidCollisions(){
		for (int i = 0; i < spaceObjects.size(); i++) {
			while(spaceObjects.elementAt(i) instanceof Asteroids) {
				spaceObjects.removeElement(i);
				System.out.println("two Asteroids collide");
			}
		}
		
	}
	
	
	public void decrementlife(){
		if(lives <=0){
			lives = 0;
		}
		lives--;
	}

}
