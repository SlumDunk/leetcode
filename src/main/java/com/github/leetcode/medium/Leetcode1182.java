package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 18:07
 * @Description: You are given an array colors, in which there are three colors: 1, 2 and 3.
 * <p>
 * You are also given some queries. Each query consists of two integers i and c, return the shortest distance between the given index i and the target color c. If there is no solution return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
 * Output: [3,0,3]
 * Explanation:
 * The nearest 3 from index 1 is at index 4 (3 steps away).
 * The nearest 2 from index 2 is at index 2 itself (0 steps away).
 * The nearest 1 from index 6 is at index 3 (3 steps away).
 * Example 2:
 * <p>
 * Input: colors = [1,2], queries = [[0,3]]
 * Output: [-1]
 * Explanation: There is no 3 in the array.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= colors.length <= 5*10^4
 * 1 <= colors[i] <= 3
 * 1 <= queries.length <= 5*10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] < colors.length
 * 1 <= queries[i][1] <= 3
 */
public class Leetcode1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        int len = colors.length;
        int[][] posFromLeft = new int[len][4], posFromRight = new int[len][4];
        for (int[] p : posFromLeft) {
            Arrays.fill(p, -1);
        }

        for (int[] p : posFromRight) {
            Arrays.fill(p, -1);
        }

        for (int i = 0, j = len - 1; i < len; ++i, --j) {
            posFromLeft[i][colors[i]] = i;
            posFromRight[j][colors[j]] = j;

            if (i > 0) {
                for (int k = 1; k <= 3; k++) {
                    if (k != colors[i]) {
                        posFromLeft[i][k] = posFromLeft[i - 1][k];
                    }
                }
            }

            if (j < len - 1) {
                for (int k = 1; k <= 3; k++) {
                    if (k != colors[j]) {
                        posFromRight[j][k] = posFromRight[j + 1][k];
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int i = query[0];
            int c = query[1];
            if (posFromRight[i][c] < 0 && posFromLeft[i][c] < 0) {
                ans.add(-1);
            } else if (posFromLeft[i][c] < 0 || posFromRight[i][c] < 0) {
                ans.add(Math.abs(i - (posFromLeft[i][c] < 0 ? posFromRight[i][c] : posFromLeft[i][c])));
            } else {
                ans.add(Math.min(i - posFromLeft[i][c], posFromRight[i][c] - i));
            }
        }
        return ans;
    }
}
