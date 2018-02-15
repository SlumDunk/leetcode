package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image below.
 * 
 * 
 * American keyboard
 * 
 * 
 * Example 1: Input: ["Hello", "Alaska", "Dad", "Peace"] Output: ["Alaska",
 * "Dad"] Note: You may use one character in the keyboard more than once. You
 * may assume the input string will only contain letters of alphabet.
 * 
 * @author liuzhongda
 *
 */
public class KeyboardRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] findWords(String[] words) {
		String firstRow = new String("qwertyuiop");
		String secondRow = new String("asdfghjkl");
		String thirdRow = new String("zxcvbnm");
		String[] result = new String[words.length];
		int count = 0;
		for (String word : words) {
			int one = 0, two = 0, three = 0;
			for (char c : word.toCharArray()) {
				if (firstRow.indexOf((int) c) != -1)
					one = 1;
				if (secondRow.indexOf((int) c) != -1)
					two = 1;
				if (thirdRow.indexOf((int) c) != -1)
					three = 1;
				if (one + two + three > 1)
					break;
			}
			if (one + two + three == 1) {
				result[count] = word;
				count++;
			}
		}
		String[] finalResult = new String[count];
		System.arraycopy(result, 0, finalResult, 0, count);
		return finalResult;
	}

}
