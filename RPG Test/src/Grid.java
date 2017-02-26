//*******************************************************************************************
// File Name: Grid.java
//
// Date: May 11, 2010
//  Updated: January 1, 2012
//
// Purpose: The Grid or battle field that the characters fight on. Similar to a chess board.
//			This should be reworked to use a simpler matrix, like an ID matrix which could be
//			used in conjunction with a database instead of a full character object matrix.
//
// Author: Travis Craft
//*******************************************************************************************

import java.util.Scanner;

public class Grid
{
	static Scanner gridScan = new Scanner(System.in);
	static Character[][] field = new Character[10][10];
	static boolean startUp = true;//used to check if this is the first time the printField() function is called

	public Grid()//creates a field of character objects
	{
		for(int i = 0; i < field.length; i++)
			for(int j = 0; j < field[0].length; j++)
				field[i][j] = new Character();
	}

	public void playField(Character [] fighters)
	{
		field[0][0] = fighters[0];
		field[9][9] = fighters[1];
	}

	public static void printField()
	{
		//debug
			if(startUp)
			{
				field[0][0] = new Warrior(15, "Jim", 0, 0);
				field[9][9] = new Archer(12, "Steve", 9, 9);
				startUp = false;
			}
		//

		for(int i = 0; i < field.length; i++)
		{
			System.out.println();
			for(int j = 0; j < field[0].length; j++)
				if(field[i][j] != null)
					System.out.print(field[i][j].getClass().getName().substring(0, 1) + " ");
				else
					System.out.print("0 ");
		}

		System.out.println();
	}

	public static int move(String s)
	{
		Character c = findChar(s);

		if(c == null)
			return 0; //character not found
		else
		{
			//System.out.println("\nInMove-C is: "); //debug
			//c.printStats(); //debug

			System.out.println("Where do you want to move? Enter x,y coordinates EX: 4,5: ");
			String where = gridScan.nextLine();
			int x, y;
			String [] pos;
			pos = where.split(",");
			x = Integer.parseInt(pos[0]);
			y = Integer.parseInt(pos[1]);

			field[x][y] = c;//move character to new location
			field[c.getPosX()][c.getPosY()] = new Character();//remove character from old location
			//System.out.println("\nCharacter's X pos: " + c.getPosX() + ", Y pos: " + c.getPosY());

			//update character object with new position
			c.setPosX(x);
			c.setPosY(y);

			return 1; //character moved, everything OK
		}
	}

	private static Character findChar(String s)
	{
		for(int i = 0; i < field.length; i++)
			for(int j = 0; j < field[0].length; j++)
			{
				if(field[i][j].getName() != null)
				{
					//System.out.print(field[i][j].getName() + " ");
					if(field[i][j].getName().equals(s))
						return field[i][j];
				}
//				if(i == field.length-1 && j == field[0].length-1 && !field[i][j].getName().equals(s))
//					System.out.println("The character isn't in the field, choose another.");
			}

		return null;
	}

	public static void listCharactersOnField()
	{
		System.out.println("\n = List of the characters = ");
		for(int i = 0; i < field.length; i++)
			for(int j = 0; j < field[0].length; j++)
				if(field[i][j] != null && field[i][j].getName() != null)
					System.out.print(field[i][j].getName() + " - " + field[i][j].getClass() + "\n");
	}

	public static void printPos() //could also make a method in menu.java that looks through the linkedlist and prints getCoor
	{
		for(int i = 0; i < field.length; i++)
			for(int j = 0; j < field[0].length; j++)
				if(field[i][j].getName() != null)
				{
					System.out.println(field[i][j].getName());
					field[i][j].getCoor();
				}
	}

	public static int printPos(String s)
	{
		Character c = findChar(s);

		if(c == null)
			return 0; //character not found
		else
		{
			//System.out.println("\nC is: "); //debug
			//c.printStats(); //debug
			c.getCoor();
			return 1;
		}
	}
}
