//*****************************************************************
// Author: Travis Craft
//
// File Name: InsertionSort.java
// 
// Date: October 10, 2010
//
// Purpose: This is the insertion sort, from my time in CS 223 with 
//			Dr. Tang, for the program. Lab 1, Spring 2010
//*****************************************************************

public class InsertionSort implements SortType
{
	public int[] sort(int[] a) 
	{
		int ind, j;
		for(int i = 1; i < a.length; i++)//the first element won't be moved until checking the second so i = 1
		{
			ind = a[i];//temporary holds the number for insertion
			j = i - 1;
			while(j >= 0 && a[j] > ind)//j is not negative and is larger than the current number
			{
				a[j + 1] = a[j];
				j -= 1;//ready to check next space 
			}
			a[j + 1] = ind;//places the number into the array
		}	
		
		System.out.println("\nFinished Insertion sort.");
		return a;
	}

}
