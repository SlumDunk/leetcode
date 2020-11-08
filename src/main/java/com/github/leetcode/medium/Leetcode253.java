package com.github.leetcode.medium;

import com.github.leetcode.vo.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
        //对起始时间进行排序，使用最小堆来记录当前会议的结束时间，
        //新会议的起始时间大于最小堆中的最早结束时间，说明新会议与堆中的最早结束会议不重叠。
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


    /**
     * O(nlgn)
     * @param intervals
     * @return
     */
    public int minMeetingRooms_(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int rooms = 0;
        Queue<Integer> pq = new PriorityQueue<Integer>();

        for (int[] interval : intervals) {
            if (!pq.isEmpty()) {
                if (interval[0] < pq.peek()) {
                    rooms++;
                } else {//有会议室可以复用
                    pq.poll();
                }
            } else {
                rooms++;
            }
            pq.offer(interval[1]);
        }

        return rooms;
    }
}
