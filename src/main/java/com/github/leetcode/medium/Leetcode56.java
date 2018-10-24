package com.github.leetcode.medium;

import com.github.leetcode.vo.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 11:10
 * @Description:
 */
public class Leetcode56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        if (intervals.size() <= 0)
            return intervals;
        //根据interval的start排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start)
                    return -1;
                else if (o1.start > o2.start)
                    return 1;
                else
                    return 0;
            }
        });
        Interval top = intervals.get(0);
        res.add(new Interval(top.start, top.end));

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            top = res.get(res.size() - 1);

            if (top.end >= current.start) {
                top.end = Math.max(current.end, top.end);
            } else {
                res.add(new Interval(current.start, current.end));
            }
        }
        return res;
    }
}
