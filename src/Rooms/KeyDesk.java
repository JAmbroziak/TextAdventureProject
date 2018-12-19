package Rooms;

import Items.ClosetKey;
import People.Person;

public class KeyDesk extends Room{

    private static boolean entered;
    private static boolean keyacquired;
    private ClosetKey key;

    public KeyDesk(int x, int y){
        super(x, y);
        this.entered = false;
        this.keyacquired = false;
        this.key = new ClosetKey();
    }

    public String toString(){
        if(occupant == null && !KeyDesk.keyacquired){
            return " ";
        } else if(occupant == null){
            return "K";
        } else {
            return occupant.toString();
        }
    }

    @Override
    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(5);
        x.setyLoc(3);
        entered = true;
        if(entered && !keyacquired) {
            System.out.println("You bump into a desk. You feel around and come into contact with a small cold metal object. It feels like a key.");
            keyacquired = true;
            x.pickupItem(key);
            JanitorsCloset.unlock(x);
        } else {
            System.out.println("You stub your toe on the desk you think you got the little metal thing from and quietly swear in pain.");
        }
    }
}
