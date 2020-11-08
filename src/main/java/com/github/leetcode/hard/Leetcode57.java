package com.github.leetcode.hard;

import com.github.leetcode.vo.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 12:01
 * @Description: Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class Leetcode57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null || intervals == null) {
            return intervals;
        }

        List<Interval> results = new ArrayList<>();
        //要插入的位置
        int insertPos = 0;
        for (Interval interval : intervals
                ) {
            if (interval.end < newInterval.start) {//newInterval在后面
                results.add(interval);
                insertPos++;
            } else if (interval.start > newInterval.end) {//newInterval在前面
                results.add(interval);
            } else {//区间有重叠的话，合并区间
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        results.add(insertPos, newInterval);
        return results;
    }


    /**
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            int[][] ans = new int[1][2];
            ans[0] = newInterval;
            return ans;
        }
        int len = intervals.length;

        List<int[]> copyIntervals = new ArrayList<>();
        boolean flag = false;

        for (int i = 0; i < len; i++) {
            if (intervals[i][0] > newInterval[0] && !flag) {
                copyIntervals.add(newInterval);
                flag = true;
            }
            copyIntervals.add(intervals[i]);
        }

        if (!flag) {
            copyIntervals.add(newInterval);
        }

        int[] pre = copyIntervals.remove(0);
        len = copyIntervals.size();
        for (int i = 0; i < len; i++) {
            int[] cur = copyIntervals.remove(0);
            if (pre[1] >= cur[0]) {//合并
                pre[1] = Math.max(cur[1], pre[1]);
            } else {
                result.add(pre);
                pre = cur;
            }
        }

        result.add(pre);
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            int[] interval = result.get(i);
            ans[i][0] = interval[0];
            ans[i][1] = interval[1];
        }

        return ans;
    }
}
