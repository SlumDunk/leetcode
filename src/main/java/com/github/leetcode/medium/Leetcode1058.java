package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 16:09
 * @Description: Given an array of prices [p1,p2...,pn] and a target, round each price pi to Roundi(pi) so that the rounded array [Round1(p1),Round2(p2)...,Roundn(pn)] sums to the given target. Each operation Roundi(pi) could be either Floor(pi) or Ceil(pi).
 * <p>
 * Return the string "-1" if the rounded array is impossible to sum to target. Otherwise, return the smallest rounding error, which is defined as Σ |Roundi(pi) - (pi)| for i from 1 to n, as a string with three places after the decimal.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = ["0.700","2.800","4.900"], target = 8
 * Output: "1.000"
 * Explanation:
 * Use Floor, Ceil and Ceil operations to get (0.7 - 0) + (3 - 2.8) + (5 - 4.9) = 0.7 + 0.2 + 0.1 = 1.0 .
 * Example 2:
 * <p>
 * Input: prices = ["1.500","2.500","3.500"], target = 10
 * Output: "-1"
 * Explanation:
 * It is impossible to meet the target.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= prices.length <= 500.
 * Each string of prices prices[i] represents a real number which is between 0 and 1000 and has exactly 3 decimal places.
 * target is between 0 and 1000000.
 */
public class Leetcode1058 {
    public String minimizeError(String[] prices, int target) {
        int n = prices.length;
        Map<Integer, Double>[] dp = new HashMap[n + 1];
        dp[0] = new HashMap<>();
        dp[0].put(0, 0.0);
        for (int i = 1; i <= n; i++) {
            double num = Double.parseDouble(prices[i - 1]);
            double upperCost = Math.ceil(num) - num;
            int upper = (int) Math.ceil(num);
            double lowerCost = num - Math.floor(num);
            int lower = (int) Math.floor(num);

            dp[i] = new HashMap<>();
            for (Map.Entry<Integer, Double> entry : dp[i - 1].entrySet()) {
                int upperKey = entry.getKey() + upper;
                dp[i].put(upperKey, Math.min(dp[i].getOrDefault(upperKey, Double.MAX_VALUE), entry.getValue() + upperCost));

                int lowerKey = entry.getKey() + lower;
                dp[i].put(lowerKey, Math.min(dp[i].getOrDefault(lowerKey, Double.MAX_VALUE), entry.getValue() + lowerCost));
            }
        }
        return dp[n].containsKey(target) ? String.format("%.3f", dp[n].get(target)) : "-1";
    }
}
