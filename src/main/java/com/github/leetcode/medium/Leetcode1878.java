package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * You are given an m x n integer matrix grid​​​.
 * <p>
 * A rhombus sum is the sum of the elements that form the border of a regular rhombus shape in grid​​​. The rhombus must have the shape of a square rotated 45 degrees with each of the corners centered in a grid cell. Below is an image of four valid rhombus shapes with the corresponding colored cells that should be included in each rhombus sum:
 * <p>
 * <p>
 * Note that the rhombus can have an area of 0, which is depicted by the purple rhombus in the bottom right corner.
 * <p>
 * Return the biggest three distinct rhombus sums in the grid in descending order. If there are less than three distinct values, return all of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]
 * Output: [228,216,211]
 * Explanation: The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
 * - Blue: 20 + 3 + 200 + 5 = 228
 * - Red: 200 + 2 + 10 + 4 = 216
 * - Green: 5 + 200 + 4 + 2 = 211
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [20,9,8]
 * Explanation: The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
 * - Blue: 4 + 2 + 6 + 8 = 20
 * - Red: 9 (area 0 rhombus in the bottom right corner)
 * - Green: 8 (area 0 rhombus in the bottom middle)
 * Example 3:
 * <p>
 * Input: grid = [[7,7,7]]
 * Output: [7]
 * Explanation: All three possible rhombus sums are the same, so return [7].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j] <= 105
 */
public class Leetcode1878 {
    int rows;
    int cols;
    int[][] grid;

    HashSet<Integer> set;
    PriorityQueue<Integer> minHeap;

    public int[] getBiggestThree(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;

        set = new HashSet<>();
        minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                findRhombusWithCenter(i, j);
            }
        }

        int[] ans = new int[minHeap.size()];
        for (int i = ans.length-1; i >= 0; i--) {
            ans[i] = minHeap.poll();
        }
        return ans;
    }

    private void findRhombusWithCenter(int x, int y) {
        int sum = grid[x][y];
        if (!set.contains(sum)) {
            minHeap.add(sum);
            if (minHeap.size() > 3) minHeap.remove();
            set.add(sum);
        }

        int size = 1;
        while (true) {
            if (!insideGrid(x - size, y)) break;
            if (!insideGrid(x + size, y)) break;
            if (!insideGrid(x, y - size)) break;
            if (!insideGrid(x, y + size)) break;

            sum = 0;

            // 从上边斜向下，从下边端点斜向上
            for (int i = 0; i <= size; i++) {
                sum += grid[x - size + i][y - i];// 左斜向下
                sum += grid[x - size + i][y + i];// 右斜向下

                sum += grid[x + size - i][y - i];// 左斜向上
                sum += grid[x + size - i][y + i];// 右斜向上
            }

            // 四个端点加了两次
            sum -= grid[x - size][y];
            sum -= grid[x + size][y];
            sum -= grid[x][y - size];
            sum -= grid[x][y + size];

            if (!set.contains(sum)) {
                minHeap.add(sum);
                if (minHeap.size() > 3) {
                    minHeap.remove();
                }
                set.add(sum);
            }

            size++;
        }
    }

    private boolean insideGrid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
