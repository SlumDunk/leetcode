package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 09:39
 * @Description: An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * <p>
 * a) it                      --> it    (no abbreviation)
 * <p>
 * 1
 * ↓
 * b) d|o|g                   --> d1g
 * <p>
 * 1    1  1
 * 1---5----0----5--8
 * ↓   ↓    ↓    ↓  ↓
 * c) i|nternationalizatio|n  --> i18n
 * <p>
 * 1
 * 1---5----0
 * ↓   ↓    ↓
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * <p>
 * Example:
 * <p>
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * <p>
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 */
public class Leetcode288 {
    class ValidWordAbbr {
        Map<String, String> map;

        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();
            for (String s :
                    dictionary) {
                String key = getKey(s);
                if (map.containsKey(key)) {
                    //不唯一，把该key对应的value清空
                    if (!map.get(key).equals(s)) {
                        map.put(key, "");
                    }
                } else {
                    map.put(key, s);
                }
            }
        }

        private String getKey(String s) {
            if (s.length() <= 2) return s;
            return s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
        }

        public boolean isUnique(String word) {
            return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
        }
    }
}
