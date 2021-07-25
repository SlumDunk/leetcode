package com.github.leetcode.medium;

/**
 * You are given a string s consisting only of characters 'a' and 'b'​​​​.
 * <p>
 * You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
 * <p>
 * Return the minimum number of deletions needed to make s balanced.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aababbab"
 * Output: 2
 * Explanation: You can either:
 * Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
 * Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
 * Example 2:
 * <p>
 * Input: s = "bbaaaaabb"
 * Output: 2
 * Explanation: The only solution is to delete the first two characters.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is 'a' or 'b'​​.
 */
public class Leetcode1653 {
    public int minimumDeletions(String s) {
        // 计算 b 之后 a 出现的个数
        int a = 0, b = 0, cnt = 0;
        for (char c :
                s.toCharArray()) {
            if (c == 'a') {
                if (b == 0) {
                    continue;
                }
                a++;
                if (a > b) {
                    cnt += b;
                    b = 0;
                    a = 0;
                }
            } else {
                b++;
            }
        }

        // 最后 b 后面的一波 a
        cnt += a;
        return cnt;
    }
}
