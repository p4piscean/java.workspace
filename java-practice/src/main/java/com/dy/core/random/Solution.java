package com.dy.core.random;

import java.util.Scanner;

public class Solution {

	static int addNumbers(int a, int b) {
		return a + b;
	}

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int num1, num2, sum;
		num1 = in.nextInt();
		num2 = in.nextInt();

		sum = addNumbers(num1, num2);
		System.out.println("The sum is " + sum);
	}

}
