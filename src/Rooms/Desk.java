package Rooms;

import Items.Item;
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
        x.setxLoc(1);
        x.setyLoc(6);
        System.out.println("You walk into a desk, and in trying to catch yourself, you flick a lamp on. there be a key");
        JanitorsCloset.setLampOn();
    }
}
