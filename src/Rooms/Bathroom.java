package Rooms;

import Items.*;
import People.Person;

public class Bathroom extends Room{

    private static boolean lightsOn;
    private int entrances;
    private RepairedCrowbar cbar;

    public Bathroom(int x, int y){
        super(x, y);
        this.lightsOn = false;
        this.entrances = 0;
        this.cbar = new RepairedCrowbar();
    }

    public String toString(){
        if(occupant == null && !Bathroom.lightsOn){
            return " ";
        } else if(occupant == null){
            return "B";
        } else {
            return occupant.toString();
        }
    }

    @Override
    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(7);
        x.setyLoc(0);
        if(!lightsOn) {
            System.out.println("You feel the all-too-familiar bathroom door. You make a mental note to drink less coffee.");
        } else if(entrances == 0) {
            x.removeItems();
            System.out.println("Remembering what you can from your chemistry class in college, you mix some of the chemicals from the closet in the sink\n"
                    + "and place the rusty crowbar in. While waiting for the chemicals to work their magic, you contemplate why you become a second rate accountant\n"
                    + "anyway. After a few minutes, you drain the sink and rinse the crowbar off. You've managed to clean off most of the rust.");
            x.pickupItem(cbar);
            entrances++;
        } else {
            System.out.println("You stand in the bathroom. You don't really need to use it.(Stop dillydallying, you've got an office to leave.)");
        }
    }

    public static void setLightsOn(){
        Bathroom.lightsOn = true;
    }
}
