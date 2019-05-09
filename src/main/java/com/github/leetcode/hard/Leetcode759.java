package com.github.leetcode.hard;

import com.github.leetcode.vo.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/24/19 10:45
 * @Description: We are given a list schedule of employees, which represents the working time for each employee.
 * <p>
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 * <p>
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
 * <p>
 * Example 1:
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation:
 * There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 * Example 2:
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)
 * <p>
 * Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
 * <p>
 * Note:
 * <p>
 * schedule and schedule[i] are lists with lengths in range [1, 50].
 * 0 <= schedule[i].start < schedule[i].end <= 10^8.
 */
public class Leetcode759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> flattened = new ArrayList<>();
        for (List<Interval> list :
                schedule) {
            flattened.addAll(list);
        }

        if (flattened.size() == 0) return Collections.emptyList();
        Collections.sort(flattened, (a, b) -> (
                a.start - b.start
        ));
        List<Interval> merged = new ArrayList<>();
        merged.add(flattened.get(0));
        List<Interval> result = new ArrayList<>();
        Interval prev = flattened.get(0);
        for (int i = 1; i < flattened.size(); i++) {
            Interval cur = flattened.get(i);
            if (cur.start > prev.end) {
                result.add(new Interval(prev.end, cur.start));
                prev = cur;
            } else {
                prev.end = Math.max(prev.end, cur.end);
            }
        }
        return result;
    }
}
