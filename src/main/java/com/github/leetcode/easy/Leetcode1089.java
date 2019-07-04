package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 22:41
 * @Description: Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * <p>
 * Do the above modifications to the input array in place, do not return anything from your function.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 * <p>
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class Leetcode1089 {
    public void duplicateZeros(int[] arr) {
        int[] copy = arr.clone();
        int index = 0; //index of arr clone
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {//不越界
            if (copy[index] == 0 && start < end) {
                arr[start++] = 0;
            }
            arr[start++] = copy[index++];
        }
    }
}
