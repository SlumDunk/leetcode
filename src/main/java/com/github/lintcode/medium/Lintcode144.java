package com.github.lintcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 23:02
 * @Description: Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
 * <p>
 * Example
 * Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.
 * <p>
 * Challenge
 * Do it in-place and without extra memory.
 * <p>
 * Notice
 * You are not necessary to keep the original order of positive integers or negative integers.
 */
public class Lintcode144 {
    /*
    * @param A: An integer array.
    * @return: nothing
    */
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        } else {
            Arrays.sort(A);
            int len = A.length;
            int i = 0, j = len - 1;
            int count = 0;
            for (i = 0; i < len; i++) {
                if (A[i] < 0) {
                    count++;
                }
            }
            i = 0;
            //插空法
            if (count > len - count) {//负数多
                i = 1;
            } else if (count + 1 == len - count) {//正数多
                j = len - 2;
            }
            while (i < j) {
                if (i < j) {
                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                    i += 2;
                    j -= 2;
                } else {
                    break;
                }
            }
        }
    }
}
