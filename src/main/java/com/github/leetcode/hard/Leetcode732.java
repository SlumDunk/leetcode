package com.github.leetcode.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 6/11/19 00:32
 * @Description:
 */
public class Leetcode732 {

    public static void main(String[] args) {
        MyCalendarThree calendar = new MyCalendarThree();
        calendar.book(10, 20); // returns 1
        calendar.book(50, 60); // returns 1
        calendar.book(10, 40); // returns 2
        calendar.book(5, 15); // returns 3
        calendar.book(5, 10); // returns 3
        calendar.book(25, 55); // returns 3
    }

    static class MyCalendarThree {
        private TreeMap<Integer, Integer> map;

        public MyCalendarThree() {
            map = new TreeMap<>();
        }

        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int count = 0, max = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                count += entry.getValue();
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
