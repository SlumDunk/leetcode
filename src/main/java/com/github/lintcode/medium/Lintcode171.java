package com.github.lintcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/26/19 22:46
 * @Description: Given an array of strings, return all groups of strings that are anagrams.
 * <p>
 * Example
 * Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
 * <p>
 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 * <p>
 * Challenge
 * What is Anagram?
 * <p>
 * Two strings are anagram if they can be the same after change the order of characters.
 * Notice
 * All inputs will be in lower-case
 */
public class Lintcode171 {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        } else {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String key = reorder(str);
                List valueList = map.getOrDefault(key, new ArrayList<>());
                valueList.add(str);
                map.put(key, valueList);
            }

            for (String key : map.keySet()) {
                if (map.get(key).size() > 1) {
                    result.addAll(map.get(key));
                }
            }
            return result;
        }
    }

    public String reorder(String str) {
        String output = null;
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);

    }
}
