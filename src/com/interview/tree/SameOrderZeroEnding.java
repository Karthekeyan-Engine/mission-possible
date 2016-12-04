package com.interview.tree;

import java.util.Arrays;

/*
 *  Date: 5/12/2016
 *  @Author Karthekeyan
 *  
 *  Question: Given an array of zero's & non-zero's values. Move all zero's to end of the array without changing their order.
 *  
 *  Example : 
 *  Input: arr[] = {7, 0, 0, 2, 0, 5, 8}
 *  Output: [7, 2, 5, 8, 0, 0, 0]
 *  
 */

class SameOrderZeroEnding {

	// Simple Method - Time Complexity: O(n) & Space Complexity: O(n)
	public void zeroEndPusherMethod1(int array[]) {

		int length = array.length, index = 0;
		int copiedArray[] = new int[length];

		for(int i = 0; i < length; i++) {
			if(array[i] != 0) copiedArray[index++] = array[i];
		}
		System.out.println(Arrays.toString(copiedArray));
	}

	// Efficient Method - Time Complexity: O(n) & Space Complexity: O(1)
	public void zeroEndPusherMethod2(int array[]) {

		int length = array.length, currentJ = 0, nextJ = 0;
		boolean firstTimeIdx = true;
		
		for(int i = 0; i < length; i++) {
			if(array[i] == 0) {
				currentJ = firstTimeIdx ?  i + 1 : nextJ;
				while(currentJ < length) {
					if(array[currentJ] != 0) {
						array[i] = array[currentJ];
						array[currentJ] = 0;
						nextJ = ++currentJ;
						firstTimeIdx = false;
						break;
					}
					currentJ++;
				}
			}
			if(length == nextJ && array[nextJ - 1] == 0) break; 
		}
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {

		SameOrderZeroEnding zeroEnding = new SameOrderZeroEnding();
		int[] givenArray = {7, 0, 0, 2, 0, 5, 8};

		zeroEnding.zeroEndPusherMethod1(givenArray);
		zeroEnding.zeroEndPusherMethod2(givenArray);
	}
}