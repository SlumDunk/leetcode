package com.github.leetcode.easy;

import java.util.Stack;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.


 * @author liuzhongda
 *
 */
public class Leetcode557 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords(""));
	}
	
	public static String reverseWords(String s) {

		String[] arrayStr = s.split(" ");
		StringBuffer sBuffer = new StringBuffer();
		int count = 0;
		for (String childStr : arrayStr) {
			sBuffer.append(reverseWord(childStr));
			if (count < arrayStr.length - 1) {
				sBuffer.append(" ");
			}
			count++;
		}
		return sBuffer.toString();

	}

	/**
	 * reverse each word
	 * @param word the input word
	 * @return
	 */
	private static String reverseWord(String word) {
		// TODO Auto-generated method stub
		char[] arrayChar = word.toCharArray();
		char[] newarrayChar = new char[word.length()];
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i <= arrayChar.length - 1; i++) {
			stack.push(arrayChar[i]);
		}
		int count = 0;
		while (!stack.isEmpty()) {
			newarrayChar[count] = stack.pop();
			count++;
		}
		return new String(newarrayChar);
	}
}
