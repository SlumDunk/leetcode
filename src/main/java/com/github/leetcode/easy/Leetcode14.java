package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/25/18 15:33
 * @Description: Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class Leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            String prev = strs[0];
            String cur = strs[1];
            int index = commonPrefix(prev, cur);
            //第一和第二个字符串共同的前缀
            prev = prev.substring(0, index);
            if ("".equals(prev)) {
                return "";
            }
            for (int i = 2; i < strs.length; i++) {
                index = commonPrefix(prev, strs[i]);
                if (index == 0) {
                    return "";
                } else {
                    prev = prev.substring(0, index);
                }
            }
            return prev;
        }
    }

    /**
     * 找到两个字符串共同的前缀
     *
     * @param prev
     * @param cur
     * @return
     */
    private int commonPrefix(String prev, String cur) {
        int index1 = 0, index2 = 0;
        while (index1 < prev.length() && index2 < cur.length()) {
            if (prev.charAt(index1) == cur.charAt(index2)) {
                index1++;
                index2++;
            } else {
                break;
            }
        }
        return index1;
    }
}
