package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    public boolean canPermutePalindrome__(String s) {
        char[] array = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        int odd = 0;
        for (char item : array) {
            map.put(item, map.getOrDefault(item, 0) + 1);
            odd += (map.get(item) % 2 == 1 ? 1 : -1);
        }

        if (odd > 1) {
            return false;
        } else {
            return true;
        }
    }
}
