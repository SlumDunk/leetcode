package com.github.interview.google;

import com.github.leetcode.vo.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 12/10/18 11:12
 * @Description:
 */
public class Google8 {
    public int soulution(int[] S, int[] E) {
        if (S.length == 0 || E.length == 0) {
            return 0;
        } else {
            int len = S.length;
            //generate pairs of start time and end time of each person
            Interval[] intervals = new Interval[len];
            for (int i = 0; i < len; i++) {
                Interval interval = new Interval(S[i], E[i]);
                intervals[i] = interval;
            }
            //order by start time
            Arrays.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval interval1, Interval interval2) {
                    return interval1.start - interval2.start;
                }
            });
            int chairs = 0;
            //mini heap，store the end time of each person，return the endtime of the person who finish most early
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int i = 0; i < intervals.length; i++) {
                minHeap.offer(intervals[i].end);
                //if the start time small than the finish time of the earlist person, time conflict, need add chair
                if (intervals[i].start < minHeap.peek()) {
                    chairs++;
                } else {//the earlist end time of this chair need to be update
                    minHeap.poll();
                }
            }
            return chairs;
        }
    }
}
