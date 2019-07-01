package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 10:36
 * @Description: Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
 * <p>
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
 * <p>
 * (Note also that a translation does not include any kind of rotation.)
 * <p>
 * What is the largest possible overlap?
 * <p>
 * Example 1:
 * <p>
 * Input: A = [[1,1,0],
 * [0,1,0],
 * [0,1,0]]
 * B = [[0,0,0],
 * [0,1,1],
 * [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 * Notes:
 * <p>
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 */
public class Leetcode835 {
    public int largestOverlap(int[][] A, int[][] B) {
        Map<String, Integer> overlaps = new HashMap<>();
        //存储A,B中1出现的位置
        List<int[]> aList = new ArrayList<>(), bList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i][j] == 1) aList.add(new int[]{i, j});
                if (B[i][j] == 1) bList.add(new int[]{i, j});
            }
        }
        int max = 0;
        //从相对位置入手
        for (int[] a : aList) {
            for (int[] b : bList) {
                String offset = (a[0] - b[0]) + "," + (a[1] - b[1]);
                overlaps.put(offset, overlaps.getOrDefault(offset, 0) + 1);
                max = Math.max(max, overlaps.get(offset));
            }
        }
        return max;
    }
}
