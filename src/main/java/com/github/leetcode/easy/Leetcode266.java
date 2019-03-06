package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 20:47
 * @Description: Given a string, determine if a permutation of the string could form a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "code"
 * Output: false
 * Example 2:
 * <p>
 * Input: "aab"
 * Output: true
 * Example 3:
 * <p>
 * Input: "carerac"
 * Output: true
 */
public class Leetcode266 {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()
                ) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
}
