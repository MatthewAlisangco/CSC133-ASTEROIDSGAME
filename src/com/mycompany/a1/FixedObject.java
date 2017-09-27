package com.mycompany.a1;

public abstract class FixedObject extends GameObject {
private static int uniqueid;

public void setUniqueID(int inID){
	this.uniqueid = inID;
}

public int getUniqueid() {
	return this.uniqueid;
			
}

}
