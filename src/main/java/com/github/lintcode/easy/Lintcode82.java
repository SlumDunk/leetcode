package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 10:29
 * @Description: Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
 * <p>
 * Example
 * Given [1,2,2,1,3,4,3], return 4
 * <p>
 * Challenge
 * One-pass, constant extra space.
 */
public class Lintcode82 {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        if(A==null||A.length==0){
            return 0;
        }
        int number = A[0];
        for (int i = 1; i < A.length; i++) {
            number ^= A[i];
        }
        return number;
    }
}
