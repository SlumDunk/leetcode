package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings dict where all the strings are of the same length.
 * <p>
 * Return True if there are 2 strings that only differ by 1 character in the same index, otherwise return False.
 * <p>
 * Follow up: Could you solve this problem in O(n*m) where n is the length of dict and m is the length of each string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: dict = ["abcd","acbd", "aacd"]
 * Output: true
 * Explanation: Strings "abcd" and "aacd" differ only by one character in the index 1.
 * Example 2:
 * <p>
 * Input: dict = ["ab","cd","yz"]
 * Output: false
 * Example 3:
 * <p>
 * Input: dict = ["abcd","cccc","abyd","abab"]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Number of characters in dict <= 10^5
 * dict[i].length == dict[j].length
 * dict[i] should be unique.
 * dict[i] contains only lowercase English letters.
 */
public class Leetcode1554 {
    public boolean differByOne(String[] dict) {
        if (dict.length == 0) {
            return false;
        }
        Set<String> dictSet = new HashSet<>();
        for (String item : dict) {
            for (int i = 0; i < item.length(); i++) {
                String modify = item.substring(0, i) + "*" + item.substring(i + 1, item.length());
                if (dictSet.contains(modify)) {
                    return true;
                }
                dictSet.add(modify);
            }
        }
        return false;
    }
}
