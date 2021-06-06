package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 16:33
 * @Description: Given an array of string words. Return all strings in words which is substring of another word in any order.
 * <p>
 * String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 * Example 2:
 * <p>
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 * Example 3:
 * <p>
 * Input: words = ["blue","green","bu"]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] contains only lowercase English letters.
 * It's guaranteed that words[i] will be unique.
 */
public class Leetcode1408 {
    public List<String> stringMatching(String[] words) {
        int l = words.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < l - 1; i++) {
            String st1 = words[i];
            for (int j = i + 1; j < l; j++) {
                String st2 = words[j];
                if (st2.length() >= st1.length()) {
                    if (st2.contains(st1)) {
                        set.add(st1);
                    }
                } else {
                    if (st1.contains(st2)) {
                        set.add(st2);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (String s : set) {
            list.add(s);
        }
        return list;
    }
}
