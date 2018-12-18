package Rooms;

import Game.Runner;
import People.Person;

public class Exit extends Room{

    private int entrances;

    public Exit(int x, int y) {
        super(x, y);
    }

    public Exit(int x, int y, int entrances) {
        super(x, y);
        this.entrances = entrances;
    }

    public String toString(){
        if(occupant == null){
            return "E";
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
        x.setxLoc(4);
        x.setyLoc(8);
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
}
