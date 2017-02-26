//*******************************************************************************************
// File Name: Warrior.java
//
// Date: May 11, 2010
//  Updated: January 1, 2012
//
// Purpose: The class defining a warrior character.
//
// Author: Travis Craft
//*******************************************************************************************

public class Warrior extends Character
{
	public int damage;

	public Warrior(int HP, String name)
	{
		super(HP, name);
		damage = 8;
	}

	public Warrior (int HP, String name, int psX, int psY)
	{
		super(HP, name, psX, psY);
		damage = 8;
	}

	public int getDamage()
	{
		return damage;
	}

	public void receiveHit(int damage)
	{
		battleHP -= damage;
	}
}
