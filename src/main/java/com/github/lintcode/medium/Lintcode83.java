package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 10:46
 * @Description: Given 3*n + 1 non-negative integer, every numbers occurs triple times except one, find it.
 * <p>
 * Example
 * Given [1,1,2,3,3,3,2,2,4,1] return 4
 * <p>
 * Challenge
 * One-pass, constant extra space.
 */
public class Lintcode83 {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumberII(int[] A) {
        // write your code here
        //抵消，二元操作，三进制
        if (A == null || A.length == 0) {
            return -1;
        }
        int result = 0;
        //每个比特位
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                bits[i] += A[j] >> i & 1;
            }
            //对3取模
            bits[i] %= 3;
            result |= (bits[i] << i);
        }
        return result;
    }
}
