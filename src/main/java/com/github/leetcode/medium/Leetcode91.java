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
 * 按位遍历字符串，如果在1-9之间，
 * 1.单位成码，此时它的解码方式的种数等于count[i-1]
 * 2.如果该字符同前一位字符能组成一个编码，那么它的解码方式的种数再加count[i-2]
 * 如果等于0，那么必须结合前一位组成编码，那么它的解码方式的种数等于count[i-2]
 */
public class Leetcode91 {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        //count[i]记录从开始到i-1点有count[i]中可能的编码方式
        int[] count = new int[s.length() + 1];
        count[0] = 1;
        if (s.charAt(0) >= '1') {
            count[1] = 1;
        }
        for (int i = 2; i <= s.length(); i++) {
            //单个字符独立
            if (s.charAt(i - 1) >= '1') {
                count[i] = count[i - 1];
            }
            //和前面字符组合
            int num = Integer.parseInt(s.substring(i - 2, i));
            if (num <= 26 && s.charAt(i - 2) > '0') {
                count[i] += count[i - 2];
            }
        }
        return count[s.length()];
    }

    /**
     * O(n)
     *
     * @param s
     * @return
     */
    public int numDecodings__(String s) {
        int len = s.length();
        char[] array = s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            if (array[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            if (i > 1 && ((array[i - 2] == '2' && array[i - 1] <= '6') || (array[i - 2] == '1'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
