package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.models.*;

public abstract class GameObject {
	// private float location;
	// private int color;
	private float x;
	private float y;
	static int color;
	ColorUtil colorutil = new ColorUtil();

	public void setX(float inX) {
		this.x = inX;
	}

	public void setY(float inY) {
		this.y = inY;
	}

	public void setColor(int inr, int ing, int inb) {
		color = colorutil.rgb(inr, ing, inb);

	}

	public void setLocation(float inX, float inY) {
		this.x = inX;
		this.y = inY;
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	// public float getLocation(){
	// return this.location;
	// }

	public String toString() {
		return "loc=" + this.x + "," + this.y + " color=[" + colorutil.red(color)+ "," + colorutil.green(color) + "," + colorutil.blue(color) + "] ";
	}

}
