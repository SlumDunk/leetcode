package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/30/19 22:08
 * @Description: Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
 * <p>
 * Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 3, K = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * Example 2:
 * <p>
 * Input: N = 2, K = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 9
 * 0 <= K <= 9
 */
public class Leetcode967 {
    public static void main(String[] args) {
        Leetcode967 leetcode967 = new Leetcode967();
        leetcode967.numsSameConsecDiff(3, 7);
    }

    public int[] numsSameConsecDiff(int N, int K) {
        int[] l = new int[10];
        int[] r = new int[10];
        for (int i = 0; i <= 9; i++) {
            l[i] = Math.max(-1, i - K);
            r[i] = Math.min(10, i + K);
        }

        List<Integer> sol = new ArrayList<>();
        for (int i = (N > 1 ? 1 : 0); i <= 9; i++) {
            helper(0, i, N, l, r, K, sol);
        }
        int[] solArray = new int[sol.size()];
        int i = 0;
        Iterator<Integer> li = sol.listIterator();
        while (li.hasNext()) {
            solArray[i++] = li.next();
        }
        return solArray;

    }

    /**
     * @param num
     * @param dig
     * @param N
     * @param l
     * @param r
     * @param K
     * @param sol
     */
    private void helper(int num, int dig, int N, int[] l, int[] r, int K, List<Integer> sol) {
        num = num * 10 + dig;
        if (N == 1) {
            sol.add(num);
            return;
        }
        if (!(l[dig] < 0)) {
            helper(num, l[dig], N - 1, l, r, K, sol);
        }
        if (K > 0 && !(r[dig] > 9)) {
            helper(num, r[dig], N - 1, l, r, K, sol);
        }
    }
}
