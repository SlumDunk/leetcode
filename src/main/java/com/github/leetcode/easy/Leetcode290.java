package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 12/18/18 16:31
 * @Description: Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * <p>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * <p>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class Leetcode290 {
    public static void main(String[] args) {
        Leetcode290 leetcode290 = new Leetcode290();
        leetcode290.wordPattern("abba",
                "dog cat cat dog");
    }

    public boolean wordPattern(String pattern, String str) {
        //用Map集合存储pattern中字符和str子串的对应关系
        Map<Character, String> bijectionMap = new HashMap<Character, String>();

        String[] array = str.split(" ");
        if (pattern.length() != array.length) {//对应长度不一致
            return false;
        } else {
            for (int i = 0; i < pattern.length(); i++) {
                if (bijectionMap.containsKey(pattern.charAt(i))) {//已经有对应关系了
                    if (!bijectionMap.get(pattern.charAt(i)).equals(array[i])) {
                        return false;
                    }
                } else {
                    if (!bijectionMap.containsValue(array[i])) {//查看array中的字符串是否已经跟pattern中的字符建立过映射关系
                        bijectionMap.put(pattern.charAt(i), array[i]);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
