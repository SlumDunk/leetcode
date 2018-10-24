package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 13:23
 * @Description: A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class Leetcoe91 {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] count = new int[s.length() + 1];      //count[i]记录从开始到i-1点有count[i]中可能的编码方式
        count[0] = 1;
        if (s.charAt(0) > '0')
            count[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) >= '1')
                count[i] = count[i - 1];
            int sum = Integer.parseInt(s.substring(i - 2, i));
            if (sum <= 26 && s.charAt(i - 2) != '0')
                count[i] += count[i - 2];
        }
        return count[s.length()];
    }
}
