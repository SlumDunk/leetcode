package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 16:38
 * @Description: Given an array A of 0s and 1s, divide the array into 3 non-empty parts such that all of these parts represent the same binary value.
 * <p>
 * If it is possible, return any [i, j] with i+1 < j, such that:
 * <p>
 * A[0], A[1], ..., A[i] is the first part;
 * A[i+1], A[i+2], ..., A[j-1] is the second part, and
 * A[j], A[j+1], ..., A[A.length - 1] is the third part.
 * All three parts have equal binary value.
 * If it is not possible, return [-1, -1].
 * <p>
 * Note that the entire part is used when considering what binary value it represents.  For example, [1,1,0] represents 6 in decimal, not 3.  Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,1,0,1]
 * Output: [0,3]
 * Example 2:
 * <p>
 * Input: [1,1,0,1,1]
 * Output: [-1,-1]
 * <p>
 * <p>
 * Note:
 * <p>
 * 3 <= A.length <= 30000
 * A[i] == 0 or A[i] == 1
 */
public class Leetcode927 {
    public int[] threeEqualParts(int[] A) {
        if (A == null || A.length < 3) return new int[]{-1, -1};
        int oneCnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) oneCnt++;
        }
        if (oneCnt % 3 != 0) return new int[]{-1, -1};
        int oneAvg = oneCnt / 3;
        if (oneAvg == 0) return new int[]{0, A.length - 1};

        // 找到第三段的开始位置
        int postOnes = 0, start3 = A.length - 1;
        while (postOnes < oneAvg) {
            if (A[start3--] == 1) postOnes++;
        }
        start3++;

        // 找到第一段的结束位置
        //二进制子串的有效长度为l
        int l = A.length - start3, i = 0;
        while (A[i] == 0) i++;
        for (int k = 0; k < l; k++) {
            if (A[i + k] != A[start3 + k]) return new int[]{-1, -1};
        }
        //第一段的结束位置 第二段的开始位置
        int left = i + l - 1, j = left + 1;

        // 第二段的结束位置
        while (A[j] == 0) j++;
        for (int k = 0; k < l; k++) {
            if (A[k + j] != A[start3 + k]) return new int[]{-1, -1};
        }
        int right = j + l;

        return new int[]{left, right};
    }
}
