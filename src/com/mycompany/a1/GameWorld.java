package com.mycompany.a1;

import java.util.Iterator;
import java.util.Vector;
import com.codename1.charts.util.ColorUtil;

public class GameWorld {
	private int playerscore;
	private int clock;
	private int lives;
	private Vector<GameObject> spaceObjects;
	private Missiles m;

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
	}

	public void addShip() {
		
		for (int i = 0; i < spaceObjects.size(); i++) {
				if (spaceObjects.elementAt(i) instanceof Ship ) {
					Ship shpObj = (Ship) spaceObjects.elementAt(i);
					System.out.println("a current ship exists: " + shpObj.toString());
					break;
				}
				else {
					spaceObjects.add(new Ship());
					break;
				}
							
		}	
		System.out.println("ship created");
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
					spaceObjects
							.add(new Missiles(shpObj.getDirection(), shpObj.getSpeed(), shpObj.getX(), shpObj.getY()));
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
			// Object Element = itr.next();
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
					System.out.println("Jumped to hyperspaxce " + shpObj.toString());
				}
			}
		}
	}

}
