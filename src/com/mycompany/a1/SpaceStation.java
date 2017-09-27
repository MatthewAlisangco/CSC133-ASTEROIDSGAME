package com.mycompany.a1;

public class SpaceStation extends FixedObject {
	private static SpaceStation DeathSTAR;
	private int blinkrate;

	private SpaceStation() {
	}

	public void blinklights() {

	}

	public static SpaceStation getSpaceStation() {
		if (DeathSTAR == null) {
			DeathSTAR = new SpaceStation();
			DeathSTAR.setUniqueID(45);
			DeathSTAR.setLocation(210, 800);
		}
		return DeathSTAR;
	}

	public void setBlinkrate(int blink) {
		this.blinkrate = blink;
	}

	public int getBlinkrate() {
		return this.blinkrate;
	}

	public String toString() {
		return "Station:" + super.toString() + "rate=" + this.blinkrate;
	}

}
