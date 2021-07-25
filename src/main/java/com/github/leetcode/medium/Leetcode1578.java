package com.github.leetcode.medium;

/**
 * Given a string s and an array of integers cost where cost[i] is the cost of deleting the ith character in s.
 * <p>
 * Return the minimum cost of deletions such that there are no two identical letters next to each other.
 * <p>
 * Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abaac", cost = [1,2,3,4,5]
 * Output: 3
 * Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
 * Example 2:
 * <p>
 * Input: s = "abc", cost = [1,2,3]
 * Output: 0
 * Explanation: You don't need to delete any character because there are no identical letters next to each other.
 * Example 3:
 * <p>
 * Input: s = "aabaa", cost = [1,2,3,4,1]
 * Output: 2
 * Explanation: Delete the first and the last character, getting the string ("aba").
 * <p>
 * <p>
 * Constraints:
 * <p>
 * s.length == cost.length
 * 1 <= s.length, cost.length <= 10^5
 * 1 <= cost[i] <= 10^4
 * s contains only lowercase English letters.
 */
public class Leetcode1578 {
    public int minCost(String s, int[] cost) {
        int ans = 0;
        // "aaabbbabbbb"
        // [3,5,10,7,5,3,5,5,4,8,1]
        int prev = s.charAt(0);
        int prevCost = cost[0];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                if (cost[i] < prevCost) {
                    ans += cost[i];
                } else {
                    ans += prevCost;
                    prevCost = cost[i];
                }
            } else {
                prev = s.charAt(i);
                prevCost = cost[i];
            }
        }
        return ans;
    }
}
