package com.github.leetcode.easy;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Leetcode409 {
    public static void main(String[] args) {
        Leetcode409 leetcode409 = new Leetcode409();
        leetcode409.longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez");
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        } else {
            int[] letterArray = new int[58];
            for (int i = 0; i < letterArray.length; i++) {
                letterArray[i] = 0;
            }

            int index = -1;
            for (int i = 0; i < s.length(); i++) {
                index = s.charAt(i) - 'A';
                letterArray[index]++;
            }
            int oddMax = 0;
            int len = 0;
            int result = 0;
            for (int i = 0; i < letterArray.length; i++) {
                if (letterArray[i] % 2 == 0) {
                    len += letterArray[i];
                } else {
                    if (letterArray[i] > oddMax) {
                        len += oddMax - 1;
                        oddMax = letterArray[i];
                    } else {
                        len += letterArray[i] - 1;
                    }
                }
            }
            result = oddMax == 0 ? len : len + oddMax + 1;
            return result;
        }
    }
}
