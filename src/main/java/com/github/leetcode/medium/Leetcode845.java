package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 22:45
 * @Description: Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 * <p>
 * B.length >= 3
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 * <p>
 * Given an array A of integers, return the length of the longest mountain.
 * <p>
 * Return 0 if there is no mountain.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * Example 2:
 * <p>
 * Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 * Note:
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * Follow up:
 * <p>
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 */
public class Leetcode845 {
    public int longestMountain(int[] A) {
        //山的开始位置
        int front = 0;
        //山后
        int back = 0;
        int largest = Integer.MIN_VALUE;
        boolean grew = false;
        boolean shrink = false;
        for (int i = 1; i < A.length; ) {
            // need to grow before it shrinks 上升
            while (i != A.length && A[back] < A[i]) {
                back = i;
                i++;
                grew = true;
            }
            // while shrinking  下降
            while (i != A.length && A[back] > A[i] && grew) {
                back = i;
                i++;
                shrink = true;
            }

            // find out how much it grew
            if (shrink) {
                largest = Math.max(largest, back - front + 1);
            }
            // it didn't grow so just update pointer to look at next index
            else {
                back = back + 1;
            }
            // 重置下一座山的开始位置
            front = back;
            // 更新i的位置
            i = back + 1;
            //重新置位
            grew = false;
            shrink = false;
        }
        return largest == Integer.MIN_VALUE ? 0 : largest;
    }
}
