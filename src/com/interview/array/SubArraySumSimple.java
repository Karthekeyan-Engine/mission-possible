package com.interview.array;

/*
 *  Date: 5/12/2016
 *  @Author Karthekeyan
 *  
 *  Question: Find SubArray with given sum (Non-negative Numbers)
 *  Description: Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number. 
 *  
 *  Example : 
 *  Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 *  Ouptut: Sum found between indexes 2 and 4
 *  
 *  Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 *  Ouptut: Sum found between indexes 1 and 4
 *  
 *  Input: arr[] = {1, 4}, sum = 0
 *  Output: No subarray found
 */

public class SubArraySumSimple {

	// Simple Method - Time Complexity: O(n^2) - Worst Case & Space Complexity: O(1)
	public void subArrayFinder(int array[], int length, int givenSum) {
		
		int currentSum = 0;
		boolean indexFound = false;
		
		for(int i = 0; i < length; i++) {
			currentSum = array[i];
			for(int j = i + 1; j <= length; j++) {
				if(currentSum == givenSum) {
					System.out.println("Sum found between indexes " + i + " and " + (j - 1));
					indexFound = true;
					return;
				}
				if(currentSum > givenSum || j == length) break;
				currentSum+= array[j];
			}
		}
		if(!indexFound) System.out.println("No subarray found");
	}

	public static void main(String[] args) {
		SubArraySumSimple arraySum = new SubArraySumSimple();
		int[] givenArray = {1, 4, 20, 3, 10, 5};
		int length = givenArray.length;
		int sum = 33;
		arraySum.subArrayFinder(givenArray, length, sum);
	}
}
