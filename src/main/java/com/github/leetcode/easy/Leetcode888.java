package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 17:32
 * @Description: Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 * <p>
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 * <p>
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 * <p>
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 * Example 4:
 * <p>
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * It is guaranteed that Alice and Bob have different total amounts of candy.
 * It is guaranteed there exists an answer.
 */
public class Leetcode888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for (int item : A
                ) {
            sumA += item;
        }
        int sumB = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int item : B
                ) {
            set.add(item);
            sumB += item;
        }
        int avg = (sumA + sumB) >> 1;
        for (int i = 0; i < A.length; i++) {
            int diff = avg - (sumA - A[i]);
            if (set.contains(diff)) {
                return new int[]{A[i], diff};
            }
        }
        return null;
    }
}
