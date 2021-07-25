package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary string s (a string consisting only of '0's and '1's), we can split s into 3 non-empty strings s1, s2, s3 (s1+ s2+ s3 = s).
 * <p>
 * Return the number of ways s can be split such that the number of characters '1' is the same in s1, s2, and s3.
 * <p>
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "10101"
 * Output: 4
 * Explanation: There are four ways to split s in 3 parts where each part contain the same number of letters '1'.
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 * Example 2:
 * <p>
 * Input: s = "1001"
 * Output: 0
 * Example 3:
 * <p>
 * Input: s = "0000"
 * Output: 3
 * Explanation: There are three ways to split s in 3 parts.
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 * Example 4:
 * <p>
 * Input: s = "100100010100110"
 * Output: 12
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= s.length <= 10^5
 * s[i] is '0' or '1'.
 */
public class Leetcode1573 {
    public int numWays(String s) {
        long mod = 1000000000 + 7;
        int count = 0;
        for (char c :
                s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }

        if (count % 3 != 0) {
            return 0;
        } else if (count == 0) {
            return (int) (((long) (s.length() - 1) * (s.length() - 2)/2) % mod);
        }

        int e2 = count / 3;
        int e3 = e2 + 1, e4 = count * 2 / 3;
        int e5 = e4 + 1;
        Map<Integer, Integer> map = new HashMap<>();
        count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
            if (count == e2) map.putIfAbsent(e2, i);
            if (count == e3) map.putIfAbsent(e3, i);
            if (count == e4) map.putIfAbsent(e4, i);
            if (count == e5) map.putIfAbsent(e5, i);
        }

        long ans = (long) (map.get(e3) - map.get(e2)) * (map.get(e5) - map.get(e4)) % mod;
        return (int) ans;
    }
}
