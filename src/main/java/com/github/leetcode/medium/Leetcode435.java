package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/26/19 20:21
 * @Description: Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * Note:
 * <p>
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * Output: 1
 * <p>
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: [ [1,2], [1,2], [1,2] ]
 * <p>
 * Output: 2
 * <p>
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: [ [1,2], [2,3] ]
 * <p>
 * Output: 0
 * <p>
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class Leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2)
            return 0;

        int toRemove = 0;
        //按开始时间排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int max = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            //和前面的有交集，需要移除, 移除范围大的
            if (intervals[i][0] < max) {
                toRemove++;
                max = Math.min(max, intervals[i][1]);
            } else {
                max = intervals[i][1];
            }
        }

        return toRemove;
    }
}
