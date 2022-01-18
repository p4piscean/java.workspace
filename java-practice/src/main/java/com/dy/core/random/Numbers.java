package com.dy.core.random;

import java.util.Arrays;

public class Numbers {

	static int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67 };
	
	//03/31/2020
	static int[][] numbers = new int[][] { { 13, 19, 53, 54, 63, 17 }, { 1, 27, 32, 60, 67, 18 },
			{ 13, 15, 24, 67, 70, 17 }, { 13, 35, 39, 46, 55, 14 }, { 29, 47, 65, 69, 70, 7}, {2, 11, 21, 57, 60, 13},
			{25, 33, 43, 51, 68, 20}, { 24, 38, 44, 57, 58, 17}, {8, 17, 51, 57, 70, 2}};

	public static void main(String[] args) {
		int result[] = new int[68];
		int totalArrays = numbers.length;
		for (int r = 0; r < totalArrays; r++) {
			int[] array = numbers[r];
			Arrays.sort(array);
			for (int checkNumber : primes) {
				int res = Arrays.binarySearch(array, checkNumber);
				boolean test = res >= 0 ? true : false;
				if (test) {
					result[checkNumber]++;					
					//System.out.println(checkNumber + " found in the list number:" + (r + 1));
				}
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			if (result[i] > 0) {
				System.out.println((i) + " found " + result[i] + " times.");
			}
		}
	}
}
