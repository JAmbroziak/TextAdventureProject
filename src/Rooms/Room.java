package Rooms;

import People.Person;

public class Room {
	Person occupant;
	int xLoc,yLoc;
	private static boolean lightsOn;
	
	public Room(int x, int y)
	{
		xLoc = x;
		yLoc = y;
		this.lightsOn = false;
	}

	public String toString() {
		if (occupant == null) {
			return " ";
		} else {
			return occupant.toString();
		}
	}

	/**
	 * Method controls the results when a person enters this room.
	 * @param x the Person entering
	 */
	public void enterRoom(Person x)
	{
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		if(!Room.lightsOn){
			System.out.println("The office is pitch black and you can't see anything. You have to feel your way around.");
		} else {
			System.out.println("You walk around the now-lit office.");
		}
	}

	public static void setLightsOn(){
		Room.lightsOn = true;
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void leaveRoom(Person x)
	{
		occupant = null;
	}
}
