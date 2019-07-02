package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 16:29
 * @Description: You have an initial power P, an initial score of 0 points, and a bag of tokens.
 * <p>
 * Each token can be used at most once, has a value token[i], and has potentially two ways to use it.
 * <p>
 * If we have at least token[i] power, we may play the token face up, losing token[i] power, and gaining 1 point.
 * If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 1 point.
 * Return the largest number of points we can have after playing any number of tokens.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = [100], P = 50
 * Output: 0
 * Example 2:
 * <p>
 * Input: tokens = [100,200], P = 150
 * Output: 1
 * Example 3:
 * <p>
 * Input: tokens = [100,200,300,400], P = 200
 * Output: 2
 * <p>
 * <p>
 * Note:
 * <p>
 * tokens.length <= 1000
 * 0 <= tokens[i] < 10000
 * 0 <= P < 10000
 */
public class Leetcode948 {
    public int bagOfTokensScore(int[] tokens, int P) {
        //以最小的power获取最多的分数
        //以最小的分数获取最大的Power
        if (tokens == null || tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int n = tokens.length, l = 0, r = n - 1, res = 0, cur = 0;
        while (l <= r) {
            while (l <= r && P >= tokens[l]) {
                P -= tokens[l++];
                cur++;
            }
            res = Math.max(res, cur);
            if (cur > 0 && r > l) {
                P += tokens[r--];
                cur--;
            } else {
                break;
            }
        }
        return res;
    }
}
