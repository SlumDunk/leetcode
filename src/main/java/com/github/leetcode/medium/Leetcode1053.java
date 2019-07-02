package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 22:25
 * @Description: Given an array A of positive integers (not necessarily distinct), return the lexicographically largest permutation that is smaller than A, that can be made with one swap (A swap exchanges the positions of two numbers A[i] and A[j]).  If it cannot be done, then return the same array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1]
 * Output: [3,1,2]
 * Explanation: Swapping 2 and 1.
 * Example 2:
 * <p>
 * Input: [1,1,5]
 * Output: [1,1,5]
 * Explanation: This is already the smallest permutation.
 * Example 3:
 * <p>
 * Input: [1,9,4,6,7]
 * Output: [1,7,4,6,9]
 * Explanation: Swapping 9 and 7.
 * Example 4:
 * <p>
 * Input: [3,1,1,3]
 * Output: [1,3,1,3]
 * Explanation: Swapping 1 and 3.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= A[i] <= 10000
 */
public class Leetcode1053 {
    /**
     * 交换两个元素，获取小于当前值的最大值
     *
     * @param A
     * @return
     */
    public int[] prevPermOpt1(int[] A) {
        int index = -1;
        //找到数组最后一个位置满足A[i]>A[i+1]
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i + 1] < A[i]) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            //获取后面的最大值和其位置
            int _i = index + 1, cur = A[index + 1];
            for (int i = index + 2; i < A.length; i++) {
                if (A[i] > cur && A[i] < A[index]) {
                    cur = A[i];
                    _i = i;
                }
            }
            int tmp = A[_i];
            A[_i] = A[index];
            A[index] = tmp;
        }
        return A;
    }
}
