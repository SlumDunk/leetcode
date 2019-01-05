package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 16:42
 * @Description: Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Leetcode76 {
    public static void main(String[] args) {
        Leetcode76 leetcode76 = new Leetcode76();
        leetcode76.minWindow("aa", "aa");
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        } else {
            //双指针
            int left = 0;
            int right = 0;
            //满足条件的最小长度
            int min = s.length();
            //是否找到满足条件的子串的标记
            boolean flag = false;
            //先用map统计要组成字符串t需要的字符情况
            Map<Character, Integer> map = new HashMap<>();
            //字符串t的长度
            int count = t.length();
            for (char val : t.toCharArray()) {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
            //开始滑动窗口
            int start = 0, end = 0;
            while (end < s.length()) {
                char val = s.charAt(end);
                if (map.containsKey(val)) {
                    map.put(val, map.get(val) - 1);
                    //还需要此字符
                    if (map.get(val) >= 0) {
                        count--;
                    }
                }
                while (count == 0 && start <= end) {//找到满足条件的子串了
                    flag = true;
                    if (end - start + 1 <= min) {
                        left = start;
                        right = end;
                        min = end - start + 1;
                    }
                    //调整开始位置
                    char startChar = s.charAt(start);
                    if (map.containsKey(startChar)) {
                        map.put(startChar, map.get(startChar) + 1);
                        //如果这字符是构成t必须的，那么count复位
                        if (map.get(startChar) >= 1) {
                            count++;
                        }
                    }
                    start++;
                }
                end++;
            }
            return flag == true ? s.substring(left, right + 1) : "";
        }
    }
}
