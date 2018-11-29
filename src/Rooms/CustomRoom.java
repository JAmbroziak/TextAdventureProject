package Rooms;

import People.Person;

import java.util.Scanner;

public class CustomRoom extends Room{

    private int entrances;

    public CustomRoom(int x, int y){
        super(x, y);
        this.entrances = 0;
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
            if (input.equalsIgnoreCase("pyrocynical")) {
                System.out.println("So guys, we did it, we reached a quarter of a million subscribers, 250,000 subscribers and still growing the fact that we\'ve reached this number in such a short amount of time is just phenomenal, I\'m-I\'m just amazed. Thank you all so much for supporting this channel and helping it grow. I-I love you guys... You guys are just awesome.\n\n");
            } else {
                System.out.println("Wrong. Get out.");
                entrances++;
            }
        }
    }
}
