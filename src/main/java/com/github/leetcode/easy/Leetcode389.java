package com.github.leetcode.easy;

/**
 * Given two strings s and t which consist of only lowercase letters.
 * <p>
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * <p>
 * Find the letter that was added in t.
 * <p>
 * Example:
 * <p>
 * Input:
 * s = "abcd"
 * t = "abcde"
 * <p>
 * Output:
 * e
 * <p>
 * Explanation:
 * 'e' is the letter that was added.
 *
 * @author liuzhongda
 */
public class Leetcode389 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public char findTheDifference(String s, String t) {
        //按位异或运算
        char result = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
            result ^= t.charAt(i);
        }
        return result;
    }

}
