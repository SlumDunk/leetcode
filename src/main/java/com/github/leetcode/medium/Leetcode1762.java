package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
 * <p>
 * The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
 * <p>
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: heights = [4,2,3,1]
 * Output: [0,2,3]
 * Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
 * Example 2:
 * <p>
 * Input: heights = [4,3,2,1]
 * Output: [0,1,2,3]
 * Explanation: All the buildings have an ocean view.
 * Example 3:
 * <p>
 * Input: heights = [1,3,2,4]
 * Output: [3]
 * Explanation: Only building 3 has an ocean view.
 * Example 4:
 * <p>
 * Input: heights = [2,2,2,2]
 * Output: [3]
 * Explanation: Buildings cannot see the ocean if there are buildings of the same height to its right.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 109
 */
public class Leetcode1762 {
    public int[] findBuildings(int[] heights) {
        List<Integer> ansList = new ArrayList<>();
        int len = heights.length;
        ansList.add(len - 1);
        int max = heights[len - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > max) {
                ansList.add(i);
                max = Math.max(max, heights[i]);
            }
        }

        int[] ans = new int[ansList.size()];
        int index = 0;
        for (Integer item : ansList) {
            ans[index++] = item;
        }
        Arrays.sort(ans);
        return ans;
    }
}
