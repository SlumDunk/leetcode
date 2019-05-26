package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 5/13/19 13:08
 * @Description: Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word following rules below.
 * <p>
 * Begin with the first character and then the number of characters abbreviated, which followed by the last character.
 * If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
 * If the abbreviation doesn't make the word shorter, then keep it as original.
 * Example:
 * Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
 * Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 * Note:
 * Both n and the length of each word will not exceed 400.
 * The length of each word is greater than 1.
 * The words consist of lowercase English letters only.
 * The return answers should be in the same order as the original array.
 */
public class Leetcode527 {
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, String> map = helper(dict, 1);
        List<String> res = new ArrayList<>();
        for (String s :
                dict) {
            res.add(map.get(s));
        }
        return res;
    }

    private Map<String, String> helper(List<String> dict, int prefixSize) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s :
                dict) {
            String prefix = s.substring(0, prefixSize);
            String suffix = s.substring(s.length() - 1, s.length());
            String key = prefix + "," + suffix + "," + s.length();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        Map<String, String> res = new HashMap<>();
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            if (e.getValue().size() == 1) {
                String s = e.getValue().get(0);
                int num = s.length() - prefixSize - 1;
                if (num <= 1) {
                    res.put(s, s);
                } else {
                    res.put(s, s.substring(0, prefixSize) + num + s.substring(s.length() - 1, s.length()));
                }
            } else {
                res.putAll(helper(e.getValue(), prefixSize + 1));
            }
        }
        return res;
    }
}
