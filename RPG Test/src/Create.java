//*******************************************************************************************
// File Name: Create.java
//
// Date: May 13, 2010
//
// Purpose: A class that just helps with the creation of characters. Provides the menus for
//			the user.
//
// Author: Travis Craft
//*******************************************************************************************

import java.util.Scanner;

public class Create
{
	static Scanner scan = new Scanner(System.in);
	public static Character makePlayer()
	{
		Character newCharacter = null;
		int type;

		System.out.println("\n\n\t== Charater creation ==");
		System.out.println("What class would like the character to be? (Enter a number, 1 - 2)\n" +
						   "1) Warrior\n" +
						   "2) Archer");
		type = scan.nextInt();

		if(type == 1)
			newCharacter = makeWar();
		else //if(type == 2)
			newCharacter = makeAr();
		//else if(type == 3)
			//etc, more later

		System.out.println("\nCharacter Complete!");

		return newCharacter;
	}

	public static Warrior makeWar()
	{
		System.out.println("How much HP do you want? (Enter a number, 15 - 20)");
		int HP = scan.nextInt();
		System.out.println("What will their name be?");
		String name = scan.next();

		Character war = new Warrior(HP, name);

		return (Warrior)war;
	}

	public static Archer makeAr()
	{
		System.out.println("How much HP do you want? (Enter a number, 10 - 15)");
		int HP = scan.nextInt();
		System.out.println("What will their name be?");
		String name = scan.next();

		Character arch = new Archer(HP, name);

		return (Archer)arch;
	}

	//for later
//	public ClassType makeCT()
//	{
//		System.out.println("How much HP do you want? (Enter a number, XX - XX)");
//		int HP = scan.nextInt();
//		System.out.println("What will their name be?");
//		String name = scan.nextLine();
//
//		Character type = new ClassType(HP, name);
//
//		return (ClassType)type;
//	}
}
