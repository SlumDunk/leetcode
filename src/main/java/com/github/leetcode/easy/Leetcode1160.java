package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 11:34
 * @Description: You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * <p>
 * Return the sum of lengths of all good strings in words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 * <p>
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * All strings contain lowercase English letters only.
 */
public class Leetcode1160 {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        int result = 0;
        for (String word : words) {
            int[] wordCount = new int[26];
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (++wordCount[c - 'a'] > count[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += word.length();
            }
        }
        return result;
    }
}
