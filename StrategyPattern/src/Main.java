//*****************************************************************
// Author: Travis Craft
//
// File Name: Main.java
// 
// Date: October 9, 2010
//
// Purpose: This is the main driver of the program.
//*****************************************************************

import java.util.Random;
public class Main 
{
	public static void main(String[] args)
	{
		long beginning = System.currentTimeMillis();//overall beginning time
		long blStT1, blStT2, mgStT1, mgStT2, itStT1, itStT2; //for checking times (bubble, merge, insertion sorts start and end times)
		long blTotal, mgTotal, itTotal; //for checking total times
		
		System.out.println("Sorting Program!\n");
				
		int [] randomNums = random(); //creates random list of 1000 ints
		//printNum(randomNums);

		Sort s = new Sort(randomNums); //makes a sort object

		s.setSortType(new BubbleSort()); //sets sort to BubbleSort
		System.out.println("Now using the Bubble sort!");
		s.printOriginal();
		blStT1 = System.nanoTime();
		s.sortList();
		blStT2 = System.nanoTime();
		blTotal = blStT2 - blStT1;
		System.out.println();
		s.printSorted();
		
		System.out.println("\nThe Bubble sort's total time (nano seconds): " + blTotal);
		System.out.println();
		s.resetSortedList(); //reset for next test
				
		
		//changed to Insertion Sort
		s.setSortType(new InsertionSort());
		System.out.println("\nNow using the Insertion sort!");
		s.printOriginal();
		itStT1 = System.nanoTime();
		s.sortList();
		itStT2 = System.nanoTime();
		itTotal = itStT2 - itStT1;
		System.out.println();
		s.printSorted();
		System.out.println("\nThe Insertion sort's total time (nano seconds): " + itTotal);
		
		System.out.println();
		s.resetSortedList(); //reset for next test
		
		
		//changed to Merge Sort
		s.setSortType(new MergeSort());
		System.out.println("\nNow using the Merge sort!");
		s.printOriginal();
		mgStT1 = System.nanoTime();
		s.sortList();
		mgStT2 = System.nanoTime();
		mgTotal = mgStT2 - mgStT1;
		System.out.println();
		s.printSorted();
		System.out.println("\nThe Merge sort's total time (nano seconds): " + mgTotal);
				
		long endding = System.currentTimeMillis();//overall beginning time
		System.out.println("\n\nThe total amount of time this program took (milliseconds): " + (endding - beginning));
	}
	
	public static int[] random() //populates array
	{	
		int [] r = new int [1000];
		Random randomGenerator = new Random();
		
		for(int i = 0; i < 1000; i++)
			r[i] = randomGenerator.nextInt(1000); //random num between 0 and 999
		
		return r;
	}
	
	public static void printNum(int [] r) //prints array for debug
	{
		for(int i = 0; i < r.length; i++)
			System.out.print(r[i] + " ");
		System.out.println();
	}
}
