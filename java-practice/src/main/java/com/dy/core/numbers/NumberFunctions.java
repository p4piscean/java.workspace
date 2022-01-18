package com.dy.core.numbers;

import java.util.HashMap;
import java.util.Map;

public class NumberFunctions {
	
	
	public Integer largestPrimeFactor(Integer n) {
		int factor = -1;
		for (int i = 2; i * i <= n; i++) {
		    if (n == 1) { break; }
		    if (n % i != 0) { continue; }
		    factor = i;
		    while (n % i == 0) {
		        n /= i;
		    }
		}
		return n == 1 ? factor : n;
	}

	public Integer findSecondMax(Integer[] arr) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
			}

			if (arr[i] < max && arr[i] > secondMax) {
				secondMax = arr[i];
			}
		}
		return secondMax;
	}

	/*
	 * Write a method that checks if there is at least on pair of numbers which sum equals target.
arr=[1, 3, 4] and target=5 result is true because the pair (1,4) sums to five.
	 */
	public Boolean sumsToTarget(Integer[] arr, Integer target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];
			if (numMap.containsKey(complement)) {
				return true;
			} else {
				numMap.put(arr[i], i);
			}
		}
		return false;
	}

}
