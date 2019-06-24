package com.github.leetcode.hard;


/**
 * @Author: zerongliu
 * @Date: 6/5/19 09:53
 * @Description: N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.
 * <p>
 * The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
 * <p>
 * The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.
 * <p>
 * Example 1:
 * <p>
 * Input: row = [0, 2, 1, 3]
 * Output: 1
 * Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
 * Example 2:
 * <p>
 * Input: row = [3, 2, 0, 1]
 * Output: 0
 * Explanation: All couples are already seated side by side.
 * Note:
 * <p>
 * len(row) is even and in the range of [4, 60].
 * row is guaranteed to be a permutation of 0...len(row)-1.
 */
public class Leetcode765 {
    private int min = Integer.MAX_VALUE;

    public int minSwapsCouples(int[] row) {
        minSwap(row, 0, 0);
        return min;
    }

    /**
     * @param row
     * @param i   开始位置
     * @param m   交换次数
     */
    private void minSwap(int[] row, int i, int m) {
        if (i >= row.length) {
            min = Math.min(min, m);
            return;
        }
        //奇数和偶数
        if (row[i] % 2 == 1 && row[i + 1] == row[i] - 1 || row[i] % 2 == 0 && row[i + 1] == row[i] + 1) {
            minSwap(row, i + 2, m);
        } else {
            for (int j = i + 1; j < row.length; j++) {
                if (row[i] % 2 == 1 && row[j] == row[i] - 1 || row[i] % 2 == 0 && row[j] == row[i] + 1) {
                    swap(row, i + 1, j);
                    minSwap(row, i + 2, m + 1);
                }
            }
        }
    }

    /**
     * 交换元素
     *
     * @param row
     * @param i
     * @param j
     */
    private void swap(int[] row, int i, int j) {
        int t = row[i];
        row[i] = row[j];
        row[j] = t;
    }
}
