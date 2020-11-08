package com.github.leetcode.hard;

import java.util.*;

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


    /**
     * O(N)
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow_(String s, String t) {
        if (t == null || t.length() == 0) {
            return "";
        }
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        //number of unique characters in t
        int k = 0;

        for (char c : arrayT) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
            if (mapT.get(c) == 1) {
                k++;
            }
        }

        //number of unique character the current window contains
        int now = 0;

        int ansl = -1, ansr = -1;

        int l, r = 0;
        for (l = 0; l < arrayS.length; l++) {
            while (r < arrayS.length && now < k) {
                char c = arrayS[r];
                mapS.put(c, mapS.getOrDefault(c, 0) + 1);

                if (mapS.get(c).equals(mapT.get(c))) {
                    now++;
                }
                r++;
            }

            if (now == k) {
                if (ansl == -1 || r - l < ansr - ansl) {
                    ansl = l;
                    ansr = r;
                }
            }

            //slide window
            mapS.put(arrayS[l], mapS.get(arrayS[l]) - 1);
            //if element l is the critical one
            if (mapS.get(arrayS[l]) == mapT.getOrDefault(arrayS[l], 0) - 1) {
                now--;
            }
        }

        if (ansl == -1) {
            return "";
        } else {
            return s.substring(ansl, ansr);
        }

    }


    public String minWindow___(String s, String t) {
        if (t == null || t.length() == 0) {
            return "";
        }
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        //number of unique characters in t
        int k = 0;

        for (char c : arrayT) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
            if (mapT.get(c) == 1) {
                k++;
            }
        }

        String result = null;

        List<Character> window = new ArrayList<>();

        for (int i = 0; i < arrayS.length; i++) {
            char c = arrayS[i];
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);

            if (mapS.get(c).equals(mapT.get(c))) {
                k--;
            }
            window.add(c);

            //调整窗口
            while (k == 0) {
                if (result == null || result.length() > window.size()) {
                    result = list2str(window);
                }

                Character val = window.remove(0);
                mapS.put(val, mapS.get(val) - 1);
                if (mapS.get(val) == mapT.getOrDefault(val, 0) - 1) {
                    k++;
                }
            }
        }

        return result == null ? "" : result;

    }

    private String list2str(List<Character> list) {
        StringBuilder buffer = new StringBuilder();
        for (Character c : list) {
            buffer.append(c);
        }
        return buffer.toString();
    }
}
