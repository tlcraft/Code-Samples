//*****************************************************************
// Author: Travis Craft
//
// File Name: BubbleSort.java
// 
// Date: October 9, 2010
//
// Purpose: This is the bubble sort, from Wikipedia, for the program.
//*****************************************************************

public class BubbleSort implements SortType
{
	public int[] sort(int[] a) 
	{
		int temp;
		boolean swapped = true;
		
		while(swapped)//anything change? yes/no
		{
			swapped  = false;
			for(int i = 0; i < a.length-1; i++)
			{
				if(a[i] > a[i+1])
				{
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					swapped = true;//something changed need to check again
				}
			}
		}
		
		System.out.println("\nFinished Bubble sort.");
		return a;
	}
}
