package Rooms;

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
            System.out.println("You stand inside the closet. You see a few mops, cleaning chemicals and oddly enough, a rusty crowbar.\n"
                    +" ");
        }
    }

    public static void setLampOn(){
        JanitorsCloset.lampOn = true;
    }
}
