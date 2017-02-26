//*****************************************************************
// Author: Travis Craft
//
// File Name: Sort.java
// 
// Date: October 9, 2010
//
// Purpose: This is the main sort class for the program.
//*****************************************************************

public class Sort 
{
	int[] original, sorted;
	SortType sType;
	
	public Sort(int[] l)
	{
		original = l;//original list
		sorted = new int[original.length];
		System.arraycopy(original, 0, sorted, 0, original.length);
	}
	
	public void sortList() //calls the specific sort method
	{
		System.out.println("\nNow using a sort method.");
		sorted = sType.sort(sorted);
	}
	
	public void printOriginal()
	{
		System.out.print("The original list: ");
		for(int i = 0; i < original.length; i++)
		{
			if(i%100 == 0)
				System.out.println();
			System.out.print(original[i] + " ");
		}
	}
	
	public void printSorted()
	{
		System.out.print("The sorted list: ");
		for(int i = 0; i < sorted.length; i++)
		{
			if(i%100 == 0)
				System.out.println();
			System.out.print(sorted[i] + " ");
		}
	}
	
	public void setSortType(SortType s) //changes sort method
	{
		System.out.println("\nSwitched sorting methods.");
		sType = s;
	}
	
	public void resetSortedList() //resets sorted list to an unsorted list
	{
		System.out.println("\nJust reset the sorted list back to the original unsorted list for next test.");
		System.arraycopy(original, 0, sorted, 0, original.length);
	}
	
	public String getSortType()
	{
		return sType.toString();
	}
}
