package Rooms;

import People.Person;

public class Desk extends Room{

    public Desk(int x, int y){
        super(x, y);
    }

    public String toString(){
        if(occupant == null){
            return "D";
        } else {
            return occupant.toString();
        }
    }

    @Override
    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(4);
        x.setyLoc(4);
        System.out.println("You walk into a desk, and in falling onto it, you lay your hand on what feels like a key.");
    }
}
