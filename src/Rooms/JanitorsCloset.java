package Rooms;

import Items.Chemicals;
import Items.ClosetKey;
import Items.RustyCrowbar;
import People.Person;

public class JanitorsCloset extends Room{

    private static boolean lampOn;
    private static boolean unlocked;
    private int entrances;
    private Chemicals chem;
    private RustyCrowbar rust;

    public JanitorsCloset(int x, int y){
        super(x, y);
        this.lampOn = false;
        this.unlocked = false;
        this.entrances = 0;
        this.chem = new Chemicals();
        this.rust = new RustyCrowbar();
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
        } else if(lampOn && unlocked && entrances == 0){
            System.out.println("Having unlocked the door, you stand inside. You see a few mops, cleaning chemicals and oddly\n"
                    + "enough, a rusty crowbar. You reach for the main power switch and pulls it. The lights in the office come to life.");
            entrances++;
            x.removeItems();
            RandomDesk.setLightsOn();
            KeyDesk.setLightsOn();
            Exit.setLightsOn();
            Bathroom.setLightsOn();
            Room.setLightsOn();
            x.pickupItem(chem);
            x.pickupItem(rust);
        } else {
            System.out.println("You stand in the janitor's closet. You don't really know why you are, as there's a task at hand that needs your focus.");
        }
    }

    public static void unlock(Person x){
        for(int i = 0; i < 3; i++){
            if(x.inventory[i] instanceof ClosetKey){
                JanitorsCloset.unlocked = true;
            }
        }
    }

    public static void setLampOn(){
        JanitorsCloset.lampOn = true;
    }
}
