package Rooms;

import People.Person;

public class JanitorsCloset extends Room{

    private boolean lampOn;

    public JanitorsCloset(int x, int y){
        super(x, y);
        this.lampOn = false;
    }

    public String toString() {
        if (occupant == null && lampOn) {
            return "J";
        } else if (occupant == null) {
            return " ";
        } else {
            return occupant.toString();
        }
    }

    @Override
    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(0);
        x.setyLoc(8);
        System.out.println("The wall feels different here, but you can't see why.");
    }
}
