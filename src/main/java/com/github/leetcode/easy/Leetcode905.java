package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 3/21/19 21:09
 * @Description: Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class Leetcode905 {
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            if (A[left] % 2 == 0) left++;//left is even
            else if (A[right] % 2 == 0) {//left is odd, right is even
                int tmp = A[left];
                A[left++] = A[right];
                A[right--] = tmp;
            } else {//left is odd, right is odd
                right--;
            }
        }
        return A;
    }
}
