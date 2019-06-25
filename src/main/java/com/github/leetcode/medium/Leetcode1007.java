package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/25/19 08:37
 * @Description: In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * <p>
 * We may rotate the i-th domino, so that A[i] and B[i] swap values.
 * <p>
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 * <p>
 * If it cannot be done, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * Example 2:
 * <p>
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 */
public class Leetcode1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int N = A.length;
        int min = Integer.MAX_VALUE;
        //遍历所有数字 表示将当前A数或B数组每个元素都变成i
        for (int i = 1; i <= 6; i++) {
            //开始位置
            int j = 0;
            int countA = 0;
            int countB = 0;

            // Try make each number on A or B
            while (j < N) {
                if (A[j] != i && B[j] != i) {
                    break;
                }
                //上翻 B->A
                if (A[j] != i && B[j] == i) {
                    countA++;
                }
                //下翻 A->B
                if (A[j] == i && B[j] != i) {
                    countB++;
                }
                j++;
            }
            //整个数组变成功了
            if (j == N) {
                min = Math.min(min, countA);
                min = Math.min(min, countB);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
