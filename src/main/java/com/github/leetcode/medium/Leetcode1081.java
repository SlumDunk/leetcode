package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 08:03
 * @Description: Return the lexicographically smallest subsequence of text that contains all the distinct characters of text exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "cdadabcc"
 * Output: "adbc"
 * Example 2:
 * <p>
 * Input: "abcd"
 * Output: "abcd"
 * Example 3:
 * <p>
 * Input: "ecbacba"
 * Output: "eacb"
 * Example 4:
 * <p>
 * Input: "leetcode"
 * Output: "letcod"
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= text.length <= 1000
 * text consists of lowercase English letters.
 */
public class Leetcode1081 {
    public String smallestSubsequence(String text) {
        int[] count = new int[26];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            count[c - 'a']++;
        }

        boolean[] used = new boolean[26];
        Arrays.fill(used, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (used[c - 'a']) {
                count[c - 'a']--;
                continue;
            }
            int last = sb.length() - 1;
            //遇到更小的，动态调整
            while (sb.length() > 0 && c < sb.charAt(last) && count[sb.charAt(last) - 'a'] > 0) {
                used[sb.charAt(last) - 'a'] = false;
                sb.deleteCharAt(last);
                last -= 1;
            }
            used[c - 'a'] = true;
            sb.append(c);
            count[c - 'a']--;
        }


        return sb.toString();
    }
}
