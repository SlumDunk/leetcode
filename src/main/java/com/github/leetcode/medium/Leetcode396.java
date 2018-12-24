package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/21/18 10:47
 * @Description: Given an array of integers A and let n to be its length.
 * <p>
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * <p>
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * <p>
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * <p>
 * Note:
 * n is guaranteed to be less than 105.
 * <p>
 * Example:
 * <p>
 * A = [4, 3, 2, 6]
 * <p>
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * <p>
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 */
public class Leetcode396 {
    public int maxRotateFunction(int[] A) {
        //找规律
        //F(1)=F(0)+allSum-4*A[3]
        //F(2)=F(1)+allSum-4*A[2]
        //F(3)=F(2)+allSum-4*A[1]
        //存储数组的和
        int allSum = 0;
        int len = A.length;
        //存储各个F(i)的和
        int F = 0;
        for (int i = 0; i < len; i++) {
            //求F(0)
            F += i * A[i];
            allSum += A[i];
        }

        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(max, F);
        }
        return max;
    }
}
