package Rooms;

import Game.Runner;
import Items.*;
import People.Person;

import java.util.Scanner;

public class Exit extends Room{

    private static boolean lightsOn;
    private static boolean failedEnd;
    private static boolean normalEnd;

    public Exit(int x, int y) {
        super(x, y);
        this.lightsOn = false;
        this.failedEnd = false;
        this.normalEnd = false;
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
        if(!lightsOn) {
            System.out.println("You stand at the exit door. It's locked.");
        }
        Exit.checkForRust(x);
        if(Exit.failedEnd){
            System.out.println("You jam the crowbar into the tiny crack between the door and its frame. You wiggle it in for whatever\n"
                    + "leverage you can get. With all your might, you begin to try and pry the door open. The crowbar snaps in two.\n"
                    + "With the realization you're stuck in the office for the rest of the weekend, you collapse to the floor in shock and depression.\n"
                    + "You got: the Failed Ending");
            Runner.gameOff();
        }
        Exit.checkForCBar(x);
        if(Exit.normalEnd){
            System.out.println("You jam the crowbar into the tiny crack between the door and its frame. You wiggle it in for whatever\n"
                    + "leverage you can get. With all your might, you begin to try and pry the door open. The door bursts open.\n"
                    + "Crowbar bent and arms exhausted, you step outside into the moonlit parking lot. You pull out your car keys and drive home.\n"
                    + "Later that morning, after a proper rest, you contemplate pressing charges against Brenda. (Will you? Type yes or no)");
            Scanner input =  new Scanner(System.in);
            String choice = input.nextLine();
             while(!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")){
                System.out.println("(Yes or no only)");
                choice = input.nextLine();
             } if(choice.equalsIgnoreCase("yes")){
                System.out.println("After deciding to press charges, the police are unable to collect enough evidence against Brenda to convict her\n"
                        + "On top of it, you're charged with a minor fee for breaking the exit door, and your boss lowers your pay to cover the rest of it.\n"
                        + "You got: the Insult to Injury Ending");
                Runner.gameOff();
             } else if(choice.equalsIgnoreCase("no")){
                System.out.println("After deciding not to press charges, you go on with your life as if nothing ever happened. You of course\n"
                        + "have to explain to your boss why in blazes the exit door was busted. You forcibly lie and say you don't know how you got\n"
                        + "locked in. In the back of your mind however, you do know. You know very well that you let her get away with it.\n"
                        + "You got: the Business As Usual Ending");
                Runner.gameOff();
             }
        }
    }

    public static void setLightsOn(){
        Exit.lightsOn = true;
    }

    public static void checkForRust(Person x){
        for(int i = 0; i < 3; i++){
            if(x.inventory[i] instanceof Chemicals){
                 Exit.failedEnd = true;
            }
        }
    }

    public static void checkForCBar(Person x){
        for(int i = 0; i < 3; i++){
            if(x.inventory[i] instanceof RepairedCrowbar){
                Exit.normalEnd = true;
            }
        }
    }
}
