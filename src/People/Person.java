package People;

import Items.*;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
	int xLoc, yLoc;
	Item[] inventory;

	public Person (int xLoc, int yLoc)
	{
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.inventory = new Item[3];
	}

	public String toString(){
		return "U";
	}

	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public void pickupItem(){

	}
}
