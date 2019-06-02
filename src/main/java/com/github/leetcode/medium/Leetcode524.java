package com.github.leetcode.medium;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 14:49
 * @Description: Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 * <p>
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * Output:
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * Output:
 * "a"
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 */
public class Leetcode524 {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String curr :
                d) {
            if (res.length() > curr.length()) continue;
            if (res.length() == curr.length() && res.compareTo(curr) <= 0) continue;
            ;
            if (isMatch(s, curr)) {
                res = curr;
            }
        }
        return res;
    }

    /**
     * 查看两个字符串是否匹配
     *
     * @param s
     * @param curr
     * @return
     */
    private boolean isMatch(String s, String curr) {
        int j = 0, i = 0;
        for (; i < s.length() && j < curr.length(); i++) {
            if (curr.charAt(j) == s.charAt(i)) {
                j++;
            }
        }
        return curr.length() == j;
    }
}
