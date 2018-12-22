package Rooms;

import Game.Runner;
import People.Person;

import java.util.Scanner;

public class RandomDesk extends Room {

    private String call;
    private static boolean lightsOn;

    public RandomDesk(int x, int y) {
        super(x, y);
        this.lightsOn = false;
        this.call = "n/a";
    }

    public RandomDesk(int x, int y, String call) {
        super(x, y);
        this.call = call;
        this.lightsOn = false;
    }

    public String toString() {
        if (occupant == null && !RandomDesk.lightsOn) {
            return " ";
        } else if (occupant == null) {
            return "D";
        } else {
            return occupant.toString();
        }
    }

    @Override
    public void enterRoom(Person x) {
        occupant = x;
        if(call.equalsIgnoreCase("")){
            x.setxLoc(4);
            x.setyLoc(5);
            if(RandomDesk.lightsOn){
                System.out.println("You notice one of the drawers in this desk slightly ajar. You open it to find a single-use diposable cellphone.\n"
                        + "Who do you choose to call? (Type boss or police)");
                Scanner choice = new Scanner(System.in);
                String pick = choice.nextLine();
                while (!pick.equalsIgnoreCase("boss") && !pick.equalsIgnoreCase("police")) {
                    System.out.println("(Boss or police only)");
                    pick = choice.nextLine();
                }
                if (pick.equalsIgnoreCase("boss")) {
                    System.out.println("You decide to call your boss. After you explain your situation, he rushes over to come free you. You sit down \n"
                            + "and you fill him in on what happened. The two of you decide to take the matter to the police, who come and investigate the office.\n"
                            + "A few days later, you get a call from your boss. Brenda has been convicted. He vows to give her hell after she gets out. \n"
                            + "He also lets you know what you need anything, you can call him.\n"
                            + "You got: the Weirdest Bonding Experience Ever (true) ending");
                    Runner.gameOff();
                } else if (pick.equalsIgnoreCase("police")) {
                    System.out.println("You decide to dial 911. The police arrive within a few minutes and begin questioning you.\n"
                            + "They take the coffee you got from Brenda into evidence. Your phone is tracked down to a trash can outside the building, \n"
                            + "along with the building keys. Brenda is arrested a few days later and convicted, facing a month-long sentence. \n"
                            + "Your boss fires her and gives you a few days off to recoup mentally.\n"
                            + "You got: the Strangely Convenient Ending");
                    Runner.gameOff();
                } else {
                    System.out.println("The office is pitch black and you can't see anything. You have to feel your way around.");
                }
            }
        } if(call.equalsIgnoreCase("n/a")){
            x.setxLoc(2);
            x.setyLoc(3);
            if(RandomDesk.lightsOn){
                System.out.println("Just a plain old desk. Nothing to see here.");
            } else {
                System.out.println("The office is pitch black and you can't see anything. You have to feel your way around.");
            }
        }
    }

    public static void setLightsOn(){
        RandomDesk.lightsOn = true;
    }
}