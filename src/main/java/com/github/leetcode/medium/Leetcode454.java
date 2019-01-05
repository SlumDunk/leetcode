package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 16:18
 * @Description: Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class Leetcode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        //存储A和B元素的组合
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int key = A[i] + B[j];
                Integer value = map.getOrDefault(key, 0);
                value++;
                map.put(key, value);
            }
        }
        int result = 0;
        //C和D元素组合，然后在map中查找是否有-key
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int key = C[i] + D[j];
                result += map.getOrDefault(-key, 0);
            }
        }
        return result;
    }


    class Pair {
        int index1;
        int index2;

        public Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        public int getIndex1() {
            return index1;
        }

        public int getIndex2() {
            return index2;
        }
    }
}
