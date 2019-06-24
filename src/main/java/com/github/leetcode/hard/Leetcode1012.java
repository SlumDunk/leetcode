package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 22:22
 * @Description: Given a positive integer N, return the number of positive integers less than or equal to N that have at least 1 repeated digit.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 20
 * Output: 1
 * Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.
 * Example 2:
 * <p>
 * Input: 100
 * Output: 10
 * Explanation: The positive numbers (<= 100) with atleast 1 repeated digit are 11, 22, 33, 44, 55, 66, 77, 88, 99, and 100.
 * Example 3:
 * <p>
 * Input: 1000
 * Output: 262
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 */
public class Leetcode1012 {

    /**
     * Intuition
     * Count res the Number Without Repeated Digit
     * Then the number with repeated digits = N - res
     * <p>
     * Similar as
     * 788. Rotated Digits
     * 902. Numbers At Most N Given Digit Set
     * <p>
     * Explanation:
     * Transform N + 1 to arrayList
     * Count the number with digits < n
     * Count the number with same prefix
     * For example,
     * if N = 8765, L = [8,7,6,6],
     * the number without repeated digit can the the following format:
     * XXX
     * XX
     * X
     * 1XXX ~ 7XXX
     * 80XX ~ 86XX
     * 870X ~ 875X
     * 8760 ~ 8765
     * <p>
     * Time Complexity:
     * the number of permutations A(m,n) is O(1)
     * We count digit by digit, so it's O(logN)
     *
     * @param N
     * @return
     */
    public int numDupDigitsAtMostN(int N) {
        // Transform N + 1 to arrayList
        ArrayList<Integer> L = new ArrayList<Integer>();
        for (int x = N + 1; x > 0; x /= 10)
            L.add(0, x % 10);

        // Count the number with digits < N
        int res = 0, n = L.size();
        for (int i = 1; i < n; ++i)
            res += 9 * A(9, i - 1);

        // Count the number with same prefix
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            //1xxx-7xxx
            for (int j = i > 0 ? 0 : 1; j < L.get(i); ++j)
                if (!seen.contains(j))
                    res += A(9 - i, n - i - 1);
            if (seen.contains(L.get(i))) break;
            seen.add(L.get(i));
        }
        return N - res;
    }

    /**
     * m个里面挑n个组合
     * 从后往前推
     *
     * @param m
     * @param n
     * @return
     */
    public int A(int m, int n) {
        return n == 0 ? 1 : A(m, n - 1) * (m - n + 1);
    }
}
