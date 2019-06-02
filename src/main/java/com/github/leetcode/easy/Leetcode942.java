package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 5/31/19 21:19
 * @Description: Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * <p>
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * <p>
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 * <p>
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 * <p>
 * Input: "DDI"
 * Output: [3,2,0,1]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 */
public class Leetcode942 {
    public int[] diStringMatch(String S) {
        if (S == null || S.length() == 0) return new int[0];
        int len = S.length(), low = 0, high = len;
        int[] res = new int[len + 1];
        for (int i = 0; i < len; i++) {
            res[i] = S.charAt(i) == 'I' ? low++ : high--;
        }
        res[len] = low;
        return res;
    }
}
