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
        dfs(s, 0, temp, result);
        return result;
    }
    private void dfs(String s, int curIndex, List<String> temp, List<List<String>> result) {
        if (curIndex == s.length()) {
            result.add(new ArrayList<String>(temp));
            return;
        }
        for (int i = curIndex + 1; i <= s.length(); i++) {
            String prefix = s.substring(curIndex, i);
            if (!isPrlindrome(prefix))  //剪枝
                continue;
            temp.add(prefix);
            dfs(s, i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
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
