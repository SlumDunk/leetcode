package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 21:05
 * @Description: Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.
 * <p>
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
 * <p>
 * The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
 * <p>
 * Example 1:
 * Input: "aba", "cdc", "eae"
 * Output: 3
 * Note:
 * <p>
 * All the given strings' lengths will not exceed 10.
 * The length of the given list will be in the range of [2, 50].
 */
public class Leetcode522 {
    /**
     * 判断较短的字符串是否是较长的字符串的子串
     *
     * @param s1 较长字符串
     * @param s2 较短字符串
     * @return
     */
    public boolean helper(String s1, String s2) {
        //较短字符串的位置
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(index)) index++;
            if (index == s2.length()) return true;
        }
        return false;
    }

    public int findLUSlength(String[] strs) {
        //按字符串长度从长到短排序
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        //遍历所有单词
        for (int i = 0; i < strs.length; i++) {
            boolean flag = false;
            for (int j = 0; j < strs.length && strs[j].length() >= strs[i].length(); j++) {
                if (j == i) continue;
                if (helper(strs[j], strs[i])) {// j is longer than or equal to i
                    flag = true;
                    break;
                }
            }
            if (!flag) return strs[i].length();
        }

        return -1;
    }
}
