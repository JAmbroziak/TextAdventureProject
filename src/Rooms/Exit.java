package Rooms;

import Game.Runner;
import People.Person;

public class Exit extends Room{

    private int entrances;
    private static boolean lightsOn;

    public Exit(int x, int y) {
        super(x, y);
    }

    public Exit(int x, int y, int entrances) {
        super(x, y);
        this.entrances = entrances;
        this.lightsOn = false;
    }

    public String toString(){
        if(occupant == null && Exit.lightsOn){
            return "E";
        } else if(occupant == null){
            return " ";
        } else {
            return occupant.toString();
        }
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(8);
        x.setyLoc(4);
        if(this.entrances < 1) {
            System.out.println("You stand at the exit. The door is locked shut.");
        }
        if(this.entrances > 0 && this.entrances < 3){
            System.out.println("You stand at the locked exit door and stare at the single dim light in the parking lot.");
        }
        this.entrances++;
        if(this.entrances == 3){
            System.out.println("The door decided to unlock itself. Go home.");
            Runner.gameOff();
        }
    }

    public static void setLightsOn(){
        Exit.lightsOn = true;
    }

    public void leaveRoom(Person x)
    {
        occupant = null;
    }
}
