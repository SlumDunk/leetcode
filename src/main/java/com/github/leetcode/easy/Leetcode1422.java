package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 13:32
 * @Description: Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).
 * <p>
 * The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "011101"
 * Output: 5
 * Explanation:
 * All possible ways of splitting s into two non-empty substrings are:
 * left = "0" and right = "11101", score = 1 + 4 = 5
 * left = "01" and right = "1101", score = 1 + 3 = 4
 * left = "011" and right = "101", score = 1 + 2 = 3
 * left = "0111" and right = "01", score = 1 + 1 = 2
 * left = "01110" and right = "1", score = 2 + 1 = 3
 * Example 2:
 * <p>
 * Input: s = "00111"
 * Output: 5
 * Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
 * Example 3:
 * <p>
 * Input: s = "1111"
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= s.length <= 500
 * The string s consists of characters '0' and '1' only.
 */
public class Leetcode1422 {
    public int maxScore(String s) {
        int leftSum = s.charAt(0) == '0' ? 1 : 0;
        int rightSum = s.charAt(s.length() - 1) == '1' ? 1 : 0;

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                rightSum++;
            }
        }

        int maxScore = leftSum + rightSum;

        for (int j = 1; j < s.length() - 1; j++) {
            if (s.charAt(j) == '0') {
                leftSum++;
            } else {
                rightSum--;
            }

            maxScore = Math.max(leftSum + rightSum, maxScore);
        }

        return maxScore;
    }
}
