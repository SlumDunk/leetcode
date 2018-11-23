package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/20/18 10:58
 * @Description: Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "aaabb", k = 3
 * <p>
 * Output:
 * 3
 * <p>
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * <p>
 * Input:
 * s = "ababbc", k = 2
 * <p>
 * Output:
 * 5
 * <p>
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class Leetcode395 {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }
    public int helper(char[] chs, int left, int right, int k) {
        if(right - left < k) return 0;
        int[] count = new int[26];
        for(int i = left; i < right; i++)
            count[chs[i]-'a']++;
        for(int i = left; i < right; i++) {
            if(count[chs[i]-'a'] < k) {
                int j = i + 1;
                while(j < right && count[chs[j]-'a'] < k) j++;
                return Math.max(helper(chs, left, i, k), helper(chs, j, right, k));
            }
        }
        return right - left;
    }
}
