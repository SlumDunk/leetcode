package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zerongliu
 * @Date: 9/24/18 21:55
 * @Description: You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * <p>
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 * <p>
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * Note:
 * The number of given pairs will be in the range [1, 1000].
 */
public class Leetcode646 {
    public static void main(String[] args) {
        Leetcode646 leetcode646 = new Leetcode646();
        int[][] pairs = {{3, 4}, {2, 3}, {1, 2}};
        leetcode646.findLongestChain(pairs);
    }

    public int findLongestChain(int[][] pairs) {
//        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
//        int count = 0, end = Integer.MIN_VALUE;
//        for (int[] pair : pairs) {
//            if (pair[0] > end) {
//                count++;
//                end = pair[1];
//            }
//        }
//        return count;
        //保证按pairs[][1]递增顺序排列，保证最优子结构
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[] dp = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs.length; j++) {
                if (i != j && pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
