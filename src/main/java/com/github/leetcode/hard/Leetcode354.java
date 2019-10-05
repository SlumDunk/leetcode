package com.github.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zerongliu
 * @Date: 2/24/19 19:15
 * @Description: You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Note:
 * Rotation is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class Leetcode354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        } else {
            int len = envelopes.length;
            //按信封面积的大小递增排序
            Comparator<int[]> comp = new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] * o1[1] - o2[0] * o2[1];
                }
            };
            Arrays.sort(envelopes, comp);
            int[] dp = new int[len];

            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    public int maxEnvelopes__(int[][] envelopes) {
        int len = envelopes.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
