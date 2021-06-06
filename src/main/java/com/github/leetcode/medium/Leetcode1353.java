package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
 * <p>
 * You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.
 * <p>
 * Return the maximum number of events you can attend.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: events = [[1,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: You can attend all the three events.
 * One way to attend them all is as shown.
 * Attend the first event on day 1.
 * Attend the second event on day 2.
 * Attend the third event on day 3.
 * Example 2:
 * <p>
 * Input: events= [[1,2],[2,3],[3,4],[1,2]]
 * Output: 4
 * Example 3:
 * <p>
 * Input: events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
 * Output: 4
 * Example 4:
 * <p>
 * Input: events = [[1,100000]]
 * Output: 1
 * Example 5:
 * <p>
 * Input: events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
 * Output: 7
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= events.length <= 105
 * events[i].length == 2
 * 1 <= startDayi <= endDayi <= 105
 */
public class Leetcode1353 {
    public int maxEvents(int[][] events) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 100000; i++) {
            set.add(i);
        }
        int count = 0;
        // 先按结束时间升序排列，结束时间相同的，按开始时间升序排列
        Arrays.sort(events, (a, b) -> a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < events.length; i++) {
            if (set.contains(events[i][0])) {
                set.remove(events[i][0]);
                count++;
            } else {
                Integer high = set.higher(events[i][0]);
                if (high != null && high <= events[i][1]) {
                    count++;
                    set.remove(high);
                }
            }
        }
        return count;
    }
}
