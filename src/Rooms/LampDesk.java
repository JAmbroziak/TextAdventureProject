package Rooms;

import People.Person;

public class LampDesk extends Room{

    private static boolean entered;
    private static boolean lampOn;

    public LampDesk(int x, int y){
        super(x, y);
        this.entered = false;
        this.lampOn = false;
    }

    public String toString(){
        if(occupant == null && !LampDesk.lampOn){
            return " ";
        } else if(occupant == null){
            return "L";
        } else {
            return occupant.toString();
        }
    }

    @Override
    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(1);
        x.setyLoc(6);
        LampDesk.entered = true;
        if(LampDesk.entered && !LampDesk.lampOn) {
            System.out.println("You stumble into a desk, and in trying to catch yourself, you flick a lamp on.");
            JanitorsCloset.setLampOn();
            LampDesk.lampOn = true;
        } else {
            System.out.println("You stand by the desk with the lit lamp.");
        }
    }
}
