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
        return "E";
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        if(this.entrances < 1) {
            System.out.println("You're standing at the exit to the parking lot. The door is locked shut.");
        }
        this.entrances++;
        Runner.gameOff();
    }


}
