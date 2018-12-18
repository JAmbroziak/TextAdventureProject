package Rooms;

import Items.ClosetKey;
import People.Person;

public class JanitorsCloset extends Room{

    private static boolean lampOn;
    private static boolean unlocked;

    public JanitorsCloset(int x, int y){
        super(x, y);
        this.lampOn = false;
        this.unlocked = false;
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
        if(!lampOn) {
            System.out.println("The wall feels different here, but you can't see why.");
        } else if(lampOn && !unlocked){
            System.out.println("You stand at the door to the janitor's closet. It's locked.");
        } else {
            System.out.println("Having unlocked the door, you stand inside. You see a few mops, cleaning chemicals and oddly\n"
                    + "enough, a rusty crowbar. You reach for the main power switch and pulls it. The lights in the office come to life.");
            Exit.setLightsOn();
        }
    }

    public void unlock(Person x){
        for(int i = 0; i < 3; i++){
            if(x.inventory[i] instanceof ClosetKey){
                this.unlocked = true;
            }
        }
    }

    public static void setLampOn(){
        JanitorsCloset.lampOn = true;
    }
}
