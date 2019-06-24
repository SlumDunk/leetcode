package com.github.leetcode.hard;

import java.util.Calendar;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 10:50
 * @Description: In an array A containing only 0s and 1s, a K-bit flip consists of choosing a (contiguous) subarray of length K and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.
 * <p>
 * Return the minimum number of K-bit flips required so that there is no 0 in the array.  If it is not possible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [0,1,0], K = 1
 * Output: 2
 * Explanation: Flip A[0], then flip A[2].
 * Example 2:
 * <p>
 * Input: A = [1,1,0], K = 2
 * Output: -1
 * Explanation: No matter how we flip subarrays of size 2, we can't make the array become [1,1,1].
 * Example 3:
 * <p>
 * Input: A = [0,0,0,1,0,1,1,0], K = 3
 * Output: 3
 * Explanation:
 * Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
 * Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
 * Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 30000
 * 1 <= K <= A.length
 */
public class Leetcode995 {
    public static void main(String[] args) {
        Leetcode995 leetcode995 = new Leetcode995();
        leetcode995.minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3);
    }

    public int minKBitFlips(int[] A, int K) {
        int n = A.length, flipped = 0, res = 0;
        //表明第i个位置是否发生翻转
        int[] isFlipped = new int[n];
        for (int i = 0; i < A.length; i++) {
            if (i >= K) {//消除上一个窗口翻转的影响
                flipped ^= isFlipped[i - K];
            }
            if (flipped == A[i]) {
                if (i + K > A.length) {
                    return -1;
                }
                isFlipped[i] = 1;
                flipped ^= 1;//进行翻转
                res++;
            }
        }
        return res;

    }
}
