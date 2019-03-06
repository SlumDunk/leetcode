package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 09:54
 * @Description: Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abab", str = "redblueredblue"
 * Output: true
 * Example 2:
 * <p>
 * Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
 * Output: true
 * Example 3:
 * <p>
 * Input: pattern = "aabb", str = "xyzabcxzyabc"
 * Output: false
 */
public class Leetcode291 {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return matach(pattern, str, map, set);
    }

    /**
     * @param pattern 模式字符串
     * @param str     匹配字符串
     * @param map     字符和字符串映射map
     * @param set     已经匹配的字符串单词集合
     * @return
     */
    private boolean matach(String pattern, String str, Map<Character, String> map, Set<String> set) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        Character c = pattern.charAt(0);
        if (map.containsKey(c)) {
            if (!str.startsWith(map.get(c))) {
                return false;
            }

            return matach(pattern.substring(1), str.substring(map.get(c).length()), map, set);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String word = str.substring(0, i + 1);
                if (set.contains(word)) {
                    continue;
                }
                map.put(c, word);
                set.add(word);
                if (matach(pattern.substring(1), str.substring(i + 1), map, set)) {
                    return true;
                }
                set.remove(word);
                map.remove(c);
            }
        }
        return false;
    }
}
