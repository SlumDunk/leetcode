package com.github.leetcode.easy;
/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 * @author liuzhongda
 *
 */
public class DetectCaptital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean detectCapitalUse(String word) {
		char[] arrChar = word.toCharArray();
		int capitcalCount = 0;
		boolean isFirst = false;
		for (int i = 0; i < arrChar.length; i++) {
			if ('A' <= arrChar[i] && arrChar[i] <= 'Z') {
				capitcalCount++;
				if (i == 0) {
					isFirst = true;
				}
			}
		}
		if (isFirst && capitcalCount == 1) {
			return true;
		}
		if (capitcalCount == arrChar.length) {
			return true;
		}
		if (capitcalCount == 0) {
			return true;
		}
		return false;
	}

}
