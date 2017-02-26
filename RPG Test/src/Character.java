//*******************************************************************************************
// File Name: Character.java
//
// Date: May 11, 2010
//  Updated: January 1, 2012
//
// Purpose: The super class for the characters. This should probably be an abstract class
//			as very similar child classes will be inheriting from it.
//
// Author: Travis Craft
//*******************************************************************************************

public class Character implements Comparable<Character>
{
	public int hitPoints, battleHP, posX, posY, damage;
	public String name;

	public Character (int HP, String name)
	{
		this.name = name;
		hitPoints = HP;
		battleHP = hitPoints;
	}

	public Character (int HP, String name, int psX, int psY)
	{
		this.name = name;
		hitPoints = HP;
		battleHP = hitPoints;
		posX = psX;
		posY = psY;
	}

	public Character()
	{
		hitPoints = -1;
		battleHP = -1;
		posX = -1;
		posY = -1;
	}

	public int getHP()
	{
		return hitPoints;
	}

	public void setHP(int HP)
	{
		hitPoints = HP;
	}

	public int getBattleHP()
	{
		return battleHP;
	}

	public void setBattleHP(int HP)
	{
		battleHP = HP;
	}

	public void resetBattleHP()
	{
		battleHP = hitPoints;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setPosX(int x)
	{
		posX = x;
	}

	public int getPosX()
	{
		return posX;
	}

	public void setPosY(int y)
	{
		posY = y;
	}

	public int getPosY()
	{
		return posY;
	}

	public void getCoor()
	{
		System.out.println(this.getPosX() + ", " + this.getPosY() + "\n");
	}

	public int compareTo(Character chara)
	{
		if(hitPoints == chara.getHP())
			return 0;
		else if (hitPoints < chara.getHP()) // change to ">" for least to most; currently it's most to least
			return 1;
		else
			return -1;
	}

	public void printStats()
	{
		System.out.print("\nName:\t" + this.getName() +
				 		 "\nHP:\t" + this.getHP() +
				 		 "\nClass:\t" + this.getClass().getName() + "\n");
		//this.getCoor();
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
