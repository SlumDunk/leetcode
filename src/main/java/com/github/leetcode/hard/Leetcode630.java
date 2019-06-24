package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/7/19 21:33
 * @Description: There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day.
 * <p>
 * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
 * <p>
 * Example:
 * <p>
 * Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * Output: 3
 * Explanation:
 * There're totally 4 courses, but you can take 3 courses at most:
 * First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
 * Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.
 * Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
 * The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
 * <p>
 * <p>
 * Note:
 * <p>
 * The integer 1 <= d, t, n <= 10,000.
 * You can't take two courses simultaneously.
 */
public class Leetcode630 {
    public int scheduleCourse(int[][] courses) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < courses.length; i++) {
            Pair p = new Pair(courses[i][1], courses[i][0]);
            list.add(p);
        }
        //根据结束时间排序，从小到大
        Collections.sort(list);
        //下个课程开始的最早时间
        int total = 0;
        int size = list.size();
        //存储不冲突的课程
        PriorityQueue<Pair> q = new PriorityQueue<>(size, new LengthComparator());
        for (int i = 0; i < size; i++) {
            Pair p = list.get(i);
            if (p.length > p.limit)
                continue;

            if (total + p.length <= p.limit) {
                q.add(p);
                total += p.length;
            } else {
                //取出耗时最长的课程
                Pair maxPair = q.peek();
                if (maxPair.length > p.length) {
                    Pair removed = q.poll();
                    total -= removed.length;
                    q.add(p);
                    total += p.length;
                }
            }
        }
        return q.size();
    }

}

class Pair implements Comparable<Pair> {
    /**
     * 课程结束时间
     */
    int limit;
    /**
     *
     * 课程时长
     */
    int length;

    public Pair(int limit, int length) {
        this.limit = limit;
        this.length = length;
    }

    @Override
    public int compareTo(Pair p1) {
        return this.limit - p1.limit;
    }

}

/**
 * 根据时长倒序排列
 */
class LengthComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair p1, Pair p2) {
        return p2.length - p1.length;
    }
}
