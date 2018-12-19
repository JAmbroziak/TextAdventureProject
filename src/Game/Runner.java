package Game;

import People.Person;
import Rooms.*;

import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		Room[][] building = new Room[9][9];
		
		//Fill the building with normal rooms
		for (int x = 0; x<building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
			}
		}
		
		//Create a random winning room.
		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building[0].length);
		building[8][4] = new Exit(x, y);

		building[0][8] = new JanitorsCloset(x, y);

		building[1][6] = new LampDesk(x, y);

		building[5][3] = new KeyDesk(x, y);

		building[7][0] = new Bathroom(x, y);
		 
		 //Setup player 1 and the input scanner
		Person player1 = new Person(  0,0);
		building[0][0].enterRoom(player1);
		Board board = new Board(building);
		Scanner in = new Scanner(System.in);
		System.out.println("You've been working many long shifts lately, which has garnered some admiration from your boss.\n"
				+ "Some of your jealous coworkers decided it would be hilarious to spike your coffee with sleeping meds.\n"
				+ "You wake up at your desk in the corner. The room is pitch black and the bright red text of your desk clock \n"
				+ "reads 2:38. You feel around for your phone and the keys the janitor left you, and they're nowhere to be \n"
				+ "found. Still somewhat dazed, you stand up and proceed to figure out how to escape the office.");
		while(gameOn)
		{
			board.print();
			System.out.println("Where would you like to move? (Choose N, S, E, W)");
			String move = in.nextLine();
			if(validMove(move, player1, building))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				
			}
			else {
				System.out.println("Please choose a valid move.");
			}
		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "n":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "e":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "w":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;
					
		}
		return true;
	}
	public static void gameOff()
	{
		gameOn = false;
	}
}