package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 17:09
 * @Description: Given a string s. You should re-order the string using the following algorithm:
 * <p>
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 * <p>
 * Return the result string after sorting s with this algorithm.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 * Example 2:
 * <p>
 * Input: s = "rat"
 * Output: "art"
 * Explanation: The word "rat" becomes "art" after re-ordering it with the mentioned algorithm.
 * Example 3:
 * <p>
 * Input: s = "leetcode"
 * Output: "cdelotee"
 * Example 4:
 * <p>
 * Input: s = "ggggggg"
 * Output: "ggggggg"
 * Example 5:
 * <p>
 * Input: s = "spo"
 * Output: "ops"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 500
 * s contains only lower-case English letters.
 */
public class Leetcode1370 {
    public String sortString(String s) {
        int[] charArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        while (sb.length() != s.length()) {
            for (int i = 0; i < 26; i++) {
                if (charArr[i] > 0) {
                    sb.append((char) ('a' + i));
                    charArr[i]--;
                }
            }


            for (int j = 25; j >= 0; j--) {
                if (charArr[j] > 0) {
                    sb.append((char) ('a' + j));
                    charArr[j]--;
                }
            }
        }

        return sb.toString();
    }
}
