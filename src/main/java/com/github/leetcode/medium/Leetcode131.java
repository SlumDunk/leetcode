package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 20:57
 * @Description: Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        backTrack(s, 0, temp, result);
        return result;
    }

    /**
     * @param s          字符串
     * @param startIndex 开始位置
     * @param temp       中间结果
     * @param result     结果集
     */
    private void backTrack(String s, int startIndex, List<String> temp, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<String>(temp));
            return;
        }
        for (int i = startIndex + 1; i <= s.length(); i++) {
            //startIndex...i前缀子串
            String prefix = s.substring(startIndex, i);
            //前缀子串非回文序列
            if (!isPrlindrome(prefix))  //剪枝
                continue;
            //前缀子串为回文序列，添加到中间结果集
            temp.add(prefix);
            backTrack(s, i, temp, result);
            //移除末尾元素
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 校验字符串是不是回文序列
     *
     * @param s
     * @return
     */
    private boolean isPrlindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

}
