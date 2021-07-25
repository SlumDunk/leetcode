package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/3/20 14:56
 * @Description: Given a string s consisting only of letters 'a' and 'b'. In a single step you can remove one palindromic subsequence from s.
 * <p>
 * Return the minimum number of steps to make the given string empty.
 * <p>
 * A string is a subsequence of a given string, if it is generated by deleting some characters of a given string without changing its order.
 * <p>
 * A string is called palindrome if is one that reads the same backward as well as forward.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ababa"
 * Output: 1
 * Explanation: String is already palindrome
 * Example 2:
 * <p>
 * Input: s = "abb"
 * Output: 2
 * Explanation: "abb" -> "bb" -> "".
 * Remove palindromic subsequence "a" then "bb".
 * Example 3:
 * <p>
 * Input: s = "baabb"
 * Output: 2
 * Explanation: "baabb" -> "b" -> "".
 * Remove palindromic subsequence "baab" then "b".
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 1000
 * s only consists of letters 'a' and 'b'
 */
public class Leetcode1332 {
    public int removePalindromeSub(String s) {
        int n=s.length();
        if(n==0){
            return 0;
        }
        for (int i = 0; i < n / 2; i++) {
            if(s.charAt(i)!=s.charAt(n-1-i)){
                return 2;
            }
        }
        return 1;
    }
}