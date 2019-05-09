package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/17/19 16:41
 * @Description: Given an integer array A, and an integer target, return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.
 * <p>
 * As the answer can be very large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation:
 * Enumerating by the values (A[i], A[j], A[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
 * Example 2:
 * <p>
 * Input: A = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation:
 * A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 * <p>
 * <p>
 * Note:
 * <p>
 * 3 <= A.length <= 3000
 * 0 <= A[i] <= 100
 * 0 <= target <= 300
 */
public class Leetcode923 {
    public int threeSumMulti(int[] A, int target) {
        long[] c = new long[101];
        for (int a :
                A) {
            c[a]++;
        }
        long res = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k) {//i==j==k
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                } else if (i == j && j != k) {//i==j!=k
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                } else if (j < k) {//i<k&&j<k
                    res += c[i] * c[j] * c[k];
                }
            }
        }
        return (int) (res % (1e9 + 7));
    }
}
