//*******************************************************************************************
// File Name: Archer.java
//
// Date: May 11, 2010
//  Updated: January 1, 2012
//
// Purpose: The class defining an archer character.
//
// Author: Travis Craft
//*******************************************************************************************

public class Archer extends Character
{
	public int damage;

	public Archer(int HP, String name)
	{
		super(HP, name);
		damage = 10;
	}

	public Archer (int HP, String name, int psX, int psY)
	{
		super(HP, name, psX, psY);
		damage = 10;
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
