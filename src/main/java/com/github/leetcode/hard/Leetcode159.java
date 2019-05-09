package com.github.leetcode.hard;

import java.util.HashMap;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 21:46
 * @Description: Given a string word , find the length of the longest substring t  that contains at most 2 distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * Example 2:
 * <p>
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */
public class Leetcode159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //滑动窗口中存储的不重复字符的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int result = 0;
        while (end < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(end), end);
                end++;
            }
            if (map.size() > 2) {
                //调整窗口开始位置
                int leftMost = s.length();
                for (int num :
                        map.values()) {
                    leftMost = Math.min(num, leftMost);
                }
                map.remove(s.charAt(leftMost));
                start = leftMost + 1;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }
}
