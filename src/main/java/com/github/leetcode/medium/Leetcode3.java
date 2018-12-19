package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 9/25/18 10:28
 * @Description: Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Leetcode3 {
    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        System.out.println(leetcode3.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int left = -1;//存储该字符最后一次出现的位置
        int max = 0;//存储最长长度
        //存储各字符最近一次的索引
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < len; i++) {
            //找到最近一次出现的位置
            left = Math.max(left, map.getOrDefault(s.charAt(i), -1));
            map.put(s.charAt(i), i);//更新字符位置索引
            max = Math.max(max, i - left);
        }

        return max;
    }
}
