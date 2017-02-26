//*****************************************************************
// Author: Travis Craft
//
// File Name: MergeSort.java
// 
// Date: October 9, 2010
//
// Purpose: This is the merge sort, from my time in CS 223 with 
//			Dr. Tang, for the program. Lab 1, Spring 2010
//*****************************************************************

public class MergeSort implements SortType
{
	public int [] sort(int [] a)
	{
		mergeSort(a);//calls the voided mergeSort with one parameter
		System.out.println("\nFinished Merge sort.");
		return a;
	}
	
	public void mergeSort (int[] arr, int [] temp, int min, int max)//part of mergesort
	{
		if (min < max)
		{
			int mid = ( min + max) / 2; 
			mergeSort(arr, temp, min, mid);//splits the array
			mergeSort(arr, temp, mid + 1, max);//splits the array
			merge(arr, temp, min, mid + 1, max); //concatenates lists together
		}
	}
	
	public void mergeSort(int [] arr)//part of mergesort
	{
		int [] temp = (int[]) new int [arr.length];
		mergeSort(arr, temp, 0, arr.length - 1);
	}
	
	public void merge(int [] arr, int [] temp, int left, int right, int end)//part of mergesort
	{
		int leftEnd = right - 1;
		int tempPos = left;
		int numEl = end - left + 1;
		
		while(left <= leftEnd && right <= end)
		{
			if(arr[left] < arr[right])//choose the smallest number to place into the temp array
				temp[tempPos++] = arr[left++];
			else
				temp[tempPos++] = arr[right++];
		}
		
		while(left <= leftEnd)//place the remaining numbers from the first half into the arrary
			temp [tempPos++] = arr[left++];
		
		while(right <= end)//place the remaining numbers from the second hald into the array
			temp[ tempPos++ ] = arr[right++];
		
		for(int i = 0; i < numEl; i++,end--)
			arr[end] = temp[end];//copy the sorted arrary into the first array
	}
}
