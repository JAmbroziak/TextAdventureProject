package Rooms;

import Items.*;
import People.Person;

public class Desk extends Room{

    private static boolean entered;
    private static boolean lampOn;
    private ClosetKey key;

    public Desk(int x, int y){
        super(x, y);
        this.entered = false;
        this.lampOn = false;
        this.key = new ClosetKey();
    }

    public String toString(){
        if(occupant == null && !Desk.lampOn){
            return " ";
        } else if(occupant == null){
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
        Desk.entered = true;
        if(Desk.entered && !Desk.lampOn) {
            System.out.println("You walk into a desk, and in trying to catch yourself, you flick a lamp on.");
            JanitorsCloset.setLampOn();
            Desk.lampOn = true;
            x.pickupItem(key);
        } else {
            System.out.println("You stand by the desk with the lit lamp.");
        }
    }
}
