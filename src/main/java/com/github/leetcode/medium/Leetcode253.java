package com.github.leetcode.medium;

import com.github.leetcode.vo.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 12/10/18 13:37
 * @Description: Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
public class Leetcode253 {
    public static void main(String[] args) {
        Leetcode253 leetcode253 = new Leetcode253();
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);

        System.out.println(leetcode253.minMeetingRooms(intervals));
    }

    public int minMeetingRooms(Interval[] intervals) {
        //按开始时间从小到大排列
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start - interval2.start;
            }
        });
        int rooms = 0;
        //最小堆，存储会议的结束时间，每次返回最早结束的会议时间
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            minHeap.offer(intervals[i].end);
            //会议开始时间小于最早结束会议的时间,时间有冲突，需要加房间
            if (intervals[i].start < minHeap.peek()) {
                rooms++;
            } else {
                minHeap.poll();
            }
        }
        return rooms;
    }
}
