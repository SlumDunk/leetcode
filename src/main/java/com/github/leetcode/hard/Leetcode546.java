package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 15:25
 * @Description: Given several boxes with different colors represented by different positive numbers.
 * You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and dfs k*k points.
 * Find the maximum points you can dfs.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * Output:
 * 23
 * Explanation:
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
 * ----> [1, 3, 3, 3, 1] (1*1=1 points)
 * ----> [1, 1] (3*3=9 points)
 * ----> [] (2*2=4 points)
 * Note: The number of boxes n would not exceed 100.
 */
public class Leetcode546 {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }

        int size = boxes.length;
        int[][][] dp = new int[size][size][size];

        return dfs(dp, boxes, 0, size - 1, 1);
    }

    /**
     * @param dp
     * @param boxes
     * @param left  开始位置
     * @param right 结束位置
     * @param k     连续的字符个数
     * @return
     */
    private int dfs(int[][][] dp, int[] boxes, int left, int right, int k) {
        if (left > right) {
            return 0;
        } else if (left == right) {
            return k * k;
        } else if (dp[left][right][k] != 0) {
            return dp[left][right][k];
        } else {
            int temp = dfs(dp, boxes, left + 1, right, 1) + k * k;

            for (int m = left + 1; m <= right; m++) {//取中间分隔点
                if (boxes[left] == boxes[m]) {
                    temp = Math.max(temp, dfs(dp, boxes, left + 1, m - 1, 1) + dfs(dp, boxes, m, right, k + 1));
                }
            }

            dp[left][right][k] = temp;
            return temp;
        }


    }
}
