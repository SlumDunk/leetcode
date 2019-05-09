package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 10:52
 * @Description: Given a string word, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * Example 1:
 * <p>
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 * <p>
 * Input: "abcd"
 * Output: "dcbabcd"
 */
public class Leetcode214 {
    public static void main(String[] args) {
        Leetcode214 leetcode214 = new Leetcode214();
        String s = "aacecaaa";
        System.out.println(leetcode214.shortestPalindrome(s));
    }

    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
