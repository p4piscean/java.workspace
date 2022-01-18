package com.dy.core.string;

import java.util.List;
import java.util.stream.Collectors;

public class StringFunctions {
	
	//Given two strings, write a method that finds the longest common sub-sequence.
	public String findLongestCommonSequence(String s1, String s2) {
		String result = "";
		for (int length = s1.length(); length > 0; length--) {
		    int startIndex = 0;
		    while (startIndex + length <= s1.length()) {
		        String current = s1.substring(startIndex, startIndex + length);
		        if (s2.contains(current)) {
		            result = current;
		            break;
		        }
		        startIndex++;
		    }
		    if (result.length() != 0) {
		        break;
		    }
		}
		return result;
	}

	public String reverse(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			result += s.charAt(s.length() - i - 1);
		}
		return result;
	}

	/*
	 * The Ceasar cipher is a basic encryption technique used by Julius Ceasar to
	 * securely communicate with his generals. Each letter is replaced by another
	 * letter N positions down the english alphabet. For example, for a rotation of
	 * 5, the letter 'c' would be replaced by an 'h'. In case of a 'z', the alphabet
	 * rotates and it is transformed into a 'd'. Implement a decoder for the Ceasar
	 * cipher where N = 5.
	 */
	public String decode(String code) {
		String decoded = "";
		int lastCharValue = 'z';
		int alphabetLength = 'z' - 'a' + 1;
		for (char character : code.toCharArray()) {
			int charNoRotation = character + 5;
			int charValue = charNoRotation < lastCharValue ? charNoRotation : charNoRotation - alphabetLength;
			decoded += (char) charValue;
		}
		return decoded;
	}

	/*
	 * Write a method that returns a comma-separated string based on a given list of
	 * integers. Each element should be preceded by the letter 'e' if the number is
	 * even, and preceded by the letter 'o' if the number is odd. For example, if
	 * the input list is (3,44), the output should be 'o3,e44'.
	 */
	public String getString(List<Integer> list) {
		return list.stream().map(i -> i % 2 == 0 ? "e" + i : "o" + i).collect(Collectors.joining(","));
	}

}