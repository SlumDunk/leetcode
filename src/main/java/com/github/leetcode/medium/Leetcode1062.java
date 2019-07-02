package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 07:49
 * @Description: Given a string S, find out the length of the longest repeating substring(s). Return 0 if no repeating substring exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abcd"
 * Output: 0
 * Explanation: There is no repeating substring.
 * Example 2:
 * <p>
 * Input: "abbaba"
 * Output: 2
 * Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
 * Example 3:
 * <p>
 * Input: "aabcaabdaab"
 * Output: 3
 * Explanation: The longest repeating substring is "aab", which occurs 3 times.
 * Example 4:
 * <p>
 * Input: "aaaaa"
 * Output: 4
 * Explanation: The longest repeating substring is "aaaa", which occurs twice.
 * <p>
 * <p>
 * Note:
 * <p>
 * The string S consists of only lowercase English letters from 'a' - 'z'.
 * 1 <= S.length <= 1500
 */
public class Leetcode1062 {
    /**
     * dp[i][j] means longest repeating substring that ends at i and j position of the string.
     * <p>
     * if s[i] == s[j] then dp[i][j] = dp[i - 1][j - 1] + 1;
     * else dp[i][j] = 0
     * <p>
     * It is easy to see that dp[i][j] only depends on dp[i - 1][j - 1], then we can reduce the space complexity to linear.
     *
     * @param S
     * @return
     */
    public int longestRepeatingSubstring(String S) {
        Set<String> known = new HashSet<>();
        int maxCount = 0;

        int i = 0;
        while (i < S.length()) {
            int j = i + maxCount + 1;
            if (j > S.length()) return maxCount;
            String x = S.substring(i, j);

            if (known.contains(x)) {
                maxCount++;
                known.clear();
                i = 0;
                continue;
            } else {
                known.add(x);
                i++;
            }
        }

        return maxCount;
    }
}
