package com.github.leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 11/3/20 15:04
 * @Description: Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
 * <p>
 * A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 2
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 2
 * row 4 -> 5
 * Rows ordered from the weakest to the strongest are [2,0,3,1,4]
 * Example 2:
 * <p>
 * Input: mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 1
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 1
 * Rows ordered from the weakest to the strongest are [0,2,3,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 */
public class Leetcode1337 {
    class Pair {
        Integer rowIdx;
        Integer count = 0;

        public Pair(Integer rowIdx, Integer count) {
            this.rowIdx = rowIdx;
            this.count = count;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.count == o2.count) {
                    return Integer.compare(o1.rowIdx, o2.rowIdx);
                }
                return Integer.compare(o1.count, o2.count);
            }
        });
        for (int i = 0; i < m; i++) {
            Pair rowPair = new Pair(i, 0);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowPair.count++;
                }
            }
            pq.offer(rowPair);
        }

        int[] ans = new int[k];
        int idx = 0;
        while (k-- > 0) {
            ans[idx++] = pq.poll().rowIdx;
        }

        return ans;
    }
}
