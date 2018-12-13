package Rooms;

import People.Person;

import java.util.Scanner;

public class CustomRoom extends Room{

    private int entrances;
    private boolean guessed;

    public CustomRoom(int x, int y){
        super(x, y);
        this.entrances = 0;
        this.guessed = false;
    }

    public String toString(){
        if(occupant == null && guessed){
            return "J";
        } else if(occupant == null) {
            return " ";
        } else {
            return occupant.toString();
        }
    }

    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        Scanner ask = new Scanner(System.in);
        if(entrances >= 3){
            System.out.println("I've already told you. Get. OUT.");
        } else {
            System.out.println("Psst. Hey, you, give me a keyword.");
            String input = ask.nextLine();
            if (input.equalsIgnoreCase("apcsa")) {
                System.out.println("niveL. rM");
                this.guessed = true;
            } else {
                System.out.println("Wrong. Get out.");
                entrances++;
            }
        }
    }
}
