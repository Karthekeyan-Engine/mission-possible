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

public class SubArraySumEfficient {

	// Efficient Method - Time Complexity: O(n) - Worst Case & Space Complexity: O(1)
	public void subArrayFinder(int array[], int length, int givenSum) {
		
		int currentSum = array[0], start = 0;
		boolean indexFound = false;
		
		for(int i = 1; i <= length; i++) {

			while(currentSum > givenSum && start < i - 1) {
				currentSum-=array[start++];
			}
			
			if(currentSum == givenSum) {
				System.out.println("Sum found between indexes " + start + " and " + (i - 1));
				indexFound = true;
				return;
			}
			
			if(i < length) {
				currentSum+= array[i];
			}
		}
		if(!indexFound) System.out.println("No subarray found");
	}
	
	public static void main(String[] args) {
		SubArraySumEfficient arraySum = new SubArraySumEfficient();
		int[] givenArray = {1, 4, 0, 0, 3, 10, 5};
		int length = givenArray.length;
		int sum = 7;
		arraySum.subArrayFinder(givenArray, length, sum);
	}
}