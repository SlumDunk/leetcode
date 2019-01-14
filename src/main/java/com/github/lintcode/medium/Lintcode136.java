package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/13/19 17:09
 * @Description: Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example
 * Given s = "aab", return:
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Lintcode136 {
    public static void main(String[] args) {
        Lintcode136 lintcode136 = new Lintcode136();
        lintcode136.partition("bb");
    }

    /*
   * @param s: A string
   * @return: A list of lists of string
   */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        } else {
            List<String> temp = new ArrayList<>();
            int len = s.length();
            dfs(0, len, temp, result, s);
            return result;
        }
    }

    public void dfs(int start, int len, List<String> temp, List<List<String>> result, String s) {
        if (start == len) {
            result.add(new ArrayList<String>(temp));
            return;
        } else {
            for (int i = start + 1; i <= len; i++) {
                String str1 = s.substring(start, i);
                if (!isPalindrome(str1)) {
                    continue;
                } else {
                    temp.add(str1);
                    dfs(i, len, temp, result, s);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
