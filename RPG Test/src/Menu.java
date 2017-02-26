//*******************************************************************************************
// File Name: Menu.java
//
// Date: May 11, 2010
//  Updated: January 1, 2012
//
// Purpose: The beginnings of a tactical role-playing game. Basic menu which performs several
//			tasks like creating characters for battle and displaying a 10 x 10 grid which
//			constitutes as the playing field. Currently the "field" and "battle" are disconnected
//			meaning the user cannot move the characters on the grid and have them attack each other.
//			The battle itself is very basic too.
//
// Author: Travis Craft
//*******************************************************************************************

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class Menu extends Create
{
	static Scanner mainScan = new Scanner(System.in);
	static LinkedList <Character> chars = new LinkedList<Character>();
	static boolean keepGoing = true;
	static Grid playField;

	public static void main(String[] args)
	{
		playField = new Grid();
		chars.add(new Warrior(15, "Jim", 0, 0));//hard coded for initial testing
		chars.add(new Archer(12, "Steve", 9, 9));
		System.out.println("\t\t** Welcome **");
		int choice = -1;

		while(keepGoing)
		{
			mainMenu();
			if(mainScan.hasNextInt())
				choice = mainScan.nextInt();
			choiceIs(choice);
		}
	}

	public static void mainMenu()
	{
		System.out.println("\nWhat would you like to do? (Pick a number)");
		System.out.println("\n 1) Create a character" +
							"\n 2) See the created characters" +
							"\n 3) Fight using the created characers" +
							"\n 4) Print playing field" +
							"\n 5) Print the characters out in order of most to least HP" +
							"\n 6) Move characters on the field" +
							"\n 7) Print character positions" +
							"\n 8) Print a character's position" +
							"\n 0) Quit");
		System.out.print("\nEnter your choice: ");
	}

	private static void choiceIs(int choice)
	{
		switch(choice)
		{
			case 1:
				Character made = Create.makePlayer();
				chars.add(made);
				break;
			case 2:
				if(doCharactersExists())
					printChars();
				break;
			case 3:
				if(doCharactersExists())
					startFight();
				break;
			case 4:
				playField.printField();
				break;
			case 5:
				if(doCharactersExists())
				{
					System.out.println("Characters in order from most to least HP:");
					printCharsHP();
				}
				break;
			case 6:
				System.out.print("\nHere is the field: ");
				playField.printField();
				if(chars.size() != 0)
				{
					playField.listCharactersOnField();
					System.out.println("\nWhich character should be moved? Type their name.");
					String c = mainScan.next();
					//System.out.println("C is: " + c); //debug; need to check if the character chosen exists
					int check6 = playField.move(c);
					if(check6 == 1)//the character was found and moved
						playField.printField();
					else
						System.out.println("\nPlease try again.");
				}
				else
					System.out.println("There are no characters on the field.");
				break;
			case 7:
				if(chars.size() != 0)
				{
					System.out.println("The positions of the characters are: ");
					playField.printPos();
				}
				else
					System.out.println("There are no characters on the field.");
				break;
			case 8:
				if(chars.size() != 0)
				{
					playField.listCharactersOnField();
					System.out.println("Which character? ");
					String cp = mainScan.next();
					System.out.print(cp + "'s position is: ");
					//playerPosition(cp);
					int check8 = playField.printPos(cp);
				}
				else
					System.out.println("There are no characters on the field.");
				break;
			case 0:
				keepGoing = false;
				System.out.println("Thanks for playing, good-bye!");
				break;
			default:
				System.out.println("Error, wrong input, please try again.");
				mainScan.nextLine();
				break;
		}
	}

	private static void printCharsHP()
	{
		PriorityQueue<Character> charsQueue = new PriorityQueue<Character>();
		for(int i = 0; i < chars.size(); i++)
			charsQueue.add(chars.get(i));
		while(!charsQueue.isEmpty())
			charsQueue.poll().printStats();
	}

	private static void printChars()
	{
		System.out.println("\nThe characters are: ");
		for(int i = 0; i < chars.size(); i++)
			System.out.print("\nID:\t" + i +
							 "\nName:\t" + chars.get(i).getName() +
							 "\nHP:\t" + chars.get(i).getHP() +
							 "\nClass:\t" + chars.get(i).getClass().getName() + "\n");
	}

	private static void startFight()
	{
		Random rand = new Random();
		int whoGoesFirst = rand.nextInt(2);

		System.out.println("What two characters would you like to battle?");
		printChars();

		System.out.print("\nChoose a character by their ID number. " +
						 "Enter the first choice: ");
		int one = mainScan.nextInt();
		System.out.print("OK, now one other ID: ");
		int two = mainScan.nextInt();

		if(whoGoesFirst == 0)
			Play.fight(new Character[]{chars.get(one), chars.get(two)});
		else
			Play.fight(new Character[]{chars.get(two), chars.get(one)});
	}

	private static boolean doCharactersExists()
	{
		if(chars.size() == 0)
		{
			System.out.println("\nThere are no characters, make some first!");
			return false;
		}
		else
		{
			return true;
		}
	}

	private static void playerPosition(String name)
	{
		for(int i = 0; i < chars.size(); i++)
			if(chars.get(i).getName().equals(name))
				chars.get(i).getCoor();
	}
}


