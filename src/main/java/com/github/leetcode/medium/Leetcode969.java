package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/25/19 16:36
 * @Description: Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.
 * <p>
 * Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,4,1]
 * Output: [4,2,4,3]
 * Explanation:
 * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
 * Starting state: A = [3, 2, 4, 1]
 * After 1st flip (k=4): A = [1, 4, 2, 3]
 * After 2nd flip (k=2): A = [4, 1, 2, 3]
 * After 3rd flip (k=4): A = [3, 2, 1, 4]
 * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
 * Example 2:
 * <p>
 * Input: [1,2,3]
 * Output: []
 * Explanation: The input is already sorted, so there is no need to flip anything.
 * Note that other answers, such as [3, 3], would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * A[i] is a permutation of [1, 2, ..., A.length]
 */
public class Leetcode969 {
    public static void main(String[] args) {
        Leetcode969 leetcode969 = new Leetcode969();
        int[] A = new int[]{3, 2, 4, 1};
        leetcode969.pancakeSort(A);
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) return result;

        helper(A, result, A.length - 1);
        return result;
    }

    private void helper(int[] A, List<Integer> result, int right) {
        if (right == 0) return;
        int maxId = findIndex(A, right);
        //如果最大的值不在正确的位置上，需要做翻转
        if (maxId != right) {
            if (maxId != 0) {
                flip(A, maxId);
                result.add(maxId + 1);
            }
            flip(A, right);
            result.add(right + 1);
        }

        helper(A, result, right - 1);
    }

    /**
     * 翻转数组
     *
     * @param A
     * @param end
     */
    private void flip(int[] A, int end) {
        int left = 0;
        int right = end;
        while (left < right) {
            int temp = A[left];
            A[left++] = A[right];
            A[right--] = temp;
        }
    }

    /**
     * 查看最大值的位置
     *
     * @param A
     * @param right
     * @return
     */
    private int findIndex(int[] A, int right) {
        for (int i = 0; i <= right; i++) {
            if (A[i] == right+1) {
                return i;
            }
        }
        return -1;
    }
}
