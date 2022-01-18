package com.dy.core.random;

public class Algorithms {
	/*
	 * Provided that you have a given number of small rice bags (1 kilo each) and
	 * big rice bags (5 kilos each), write a method that returns the minimum number
	 * of small bags necessary to package goal kilos of rice. Return -1 if it is not
	 * possible to package the required rice amount with the bags provided.
	 */

	public Integer getNumberSmallBags(Integer big, Integer small, Integer goal) {
		int result = -1;
		if (big * 5 >= goal) {
			if (small >= goal % 5)
				result = goal % 5;
		} else {
			if (small >= goal - big * 5) {
				result = goal - big * 5;
			}
		}
		return result;
	}
}
