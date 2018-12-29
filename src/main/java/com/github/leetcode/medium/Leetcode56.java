package com.github.leetcode.medium;

import com.github.leetcode.vo.Interval;

import java.util.*;

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
        //按开始时间升序排序intervals
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        Interval top = intervals.get(0);
        res.add(new Interval(top.start, top.end));
        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            //每次拿出集合中结束时间最晚的元素
            top = res.get(res.size() - 1);
            if (top.end >= currentInterval.start) {
                //修正上边界
                top.end = Math.max(top.end, currentInterval.end);
            } else {//没有交集，需要添加新的
                res.add(new Interval(currentInterval.start, currentInterval.end));
            }
        }
        return res;
    }
}
