package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 14:24
 * @Description: Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two 'a's.
 * Example 2:
 * <p>
 * Input: s = "abca"
 * Output: 2
 * Explanation: The optimal substring here is "bc".
 * Example 3:
 * <p>
 * Input: s = "cbzxy"
 * Output: -1
 * Explanation: There are no characters that appear twice in s.
 * Example 4:
 * <p>
 * Input: s = "cabbac"
 * Output: 4
 * Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 300
 * s contains only lowercase English letters.
 */
public class Leetcode1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> valueList = map.getOrDefault(c, new ArrayList<>());
            valueList.add(i);
            map.put(c, valueList);
        }

        int max = -1;
        for (List<Integer> value :
                map.values()) {
            if (value.size() > 1) {
                max = Math.max(max, value.get(value.size()-1) - value.get(0) - 1);
            }
        }
        return max;
    }

}
