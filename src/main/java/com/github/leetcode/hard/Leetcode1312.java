package com.github.leetcode.hard;

/**
 * Given a string s. In one step you can insert any character at any index of the string.
 *
 * Return the minimum number of steps to make s palindrome.
 *
 * A Palindrome String is one that reads the same backward as well as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 * Example 2:
 *
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 * Example 3:
 *
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 * Example 4:
 *
 * Input: s = "g"
 * Output: 0
 * Example 5:
 *
 * Input: s = "no"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * All characters of s are lower case English letters.
 */
public class Leetcode1312 {
    public int minInsertions(String s) {
        int n=s.length();
        // 缓存的角色, i 到 e 之间的子串变成回文序列的最小成本
        int[][] cache=new int[n][n];
        char[] chars=s.toCharArray();
        return minInsertions(chars, 0, n-1, cache);
    }

    private static int minInsertions(char[] chars, int start, int end, int[][] cache) {

        if (start == end) {
            return 0;
        }
        if (start == end - 1) {
            return chars[start] == chars[end] ? 0 : 1;
        }
        if (cache[start][end] != 0) {
            return cache[start][end];
        }

        if (chars[start] == chars[end]) {
            int rr = minInsertions(chars, start + 1, end - 1, cache);
            cache[start][end] = rr;
            return rr;
        } else {
            // 右边插入成本高 还是 左边插入成本高
            int rr = Math.min(minInsertions(chars, start + 1, end, cache), minInsertions(chars, start, end - 1, cache)) + 1;
            cache[start][end] = rr;
            return rr;
        }

    }
}
