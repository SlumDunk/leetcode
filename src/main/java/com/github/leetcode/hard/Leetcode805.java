package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 16:11
 * @Description: In a given integer array A, we must move every element of A to either list B or list C. (B and C initially start empty.)
 * <p>
 * Return true if and only if after such a move, it is possible that the average value of B is equal to the average value of C, and B and C are both non-empty.
 * <p>
 * Example :
 * Input:
 * [1,2,3,4,5,6,7,8]
 * Output: true
 * Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
 * Note:
 * <p>
 * The length of A will be in the range [1, 30].
 * A[i] will be in the range of [0, 10000].
 */
public class Leetcode805 {
    public boolean splitArraySameAverage(int[] A) {
        Arrays.sort(A);

        int cTot = 0;
        for(int i=0; i<A.length; i++) {
            cTot += A[i];
        }

        return bt(A, 0, 0, cTot, 0, A.length);
    }

    /**
     *
     * @param A
     * @param start 开始位置
     * @param bTot B数组的和
     * @param cTot C数组的和
     * @param bLen B数组的长度
     * @param cLen C数组的长度
     * @return
     */
    private boolean bt(int[] A, int start, int bTot, int cTot, int bLen, int cLen) {

        if(bTot != 0 && cTot != 0 && (double)bTot/bLen == (double)cTot/cLen) return true;

        for(int i=start; i<A.length; i++) {
            // Avoid duplicates
            if(i != start && A[i] == A[i-1]) continue;

            if(bt(A, i+1, bTot+A[i], cTot-A[i], bLen+1, cLen-1)) return true;
        }

        return false;
    }
}
