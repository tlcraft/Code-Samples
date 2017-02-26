//*******************************************************************************************
// File Name: Play.java
//
// Date: May 11, 2010
//  Updated: January 1, 2012
//
// Purpose: The class that handles the battle between two characters. Outputs information
//			concerning the battle. Resets things once done.
//
// Author: Travis Craft
//*******************************************************************************************

public class Play
{
	public static void fight(Character [] characters)
	{
		boolean win = false;
		System.out.println("Fight!\n" + characters[0].getName() + " is attacking first!");

		while (!win)
		{
			printHPs(characters);//show user character info

			//just a basic fight for now, character [0] goes then character [1] goes
			System.out.println("Fighting!");
			System.out.println(characters[0].getName() + " attacks!");
			System.out.println(characters[0].getName() + " attacks " + characters[1].getName() + " for " +
								characters[0].getDamage() + "!");
			characters[1].receiveHit(characters[0].getDamage());

			if(characters[1].getBattleHP() <= 0)
				win = true;
			else
			{
				System.out.println(characters[1].getName() + " attacks!");
				System.out.println(characters[1].getName() + " attacks " + characters[0].getName() + " for " +
									characters[1].getDamage() + "!");
				characters[0].receiveHit(characters[1].getDamage());
			}

			if(characters[0].getBattleHP() <= 0)
				win = true;
		}

		if(characters[0].getBattleHP() > 0)
			System.out.println("\nThe winner is, " + characters[0].getName() + "!");
		else
			System.out.println("\nThe winner is, " + characters[1].getName() + "!");

		resetChars(characters);
	}

	private static void resetChars(Character[] characters)
	{
		characters[0].resetBattleHP();
		characters[1].resetBattleHP();
	}

	public static void printHPs(Character [] arr)
	{
		System.out.println("\n" + arr[0].getName() + "'s remaining HP is: " + arr[0].getBattleHP());
		System.out.println(arr[1].getName() + "'s remaining HP is: " + arr[1].getBattleHP() + "\n");
	}
}
