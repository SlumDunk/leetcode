package com.github.leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 5/25/19 19:44
 * @Description: Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.
 * <p>
 * Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 * <p>
 * A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)
 * <p>
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
 * <p>
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * Example 1:
 * <p>
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 * Explanation:
 * The first two events can be booked.  The third event can be double booked.
 * The fourth event (5, 15) can't be booked, because it would result in a triple booking.
 * The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
 * The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
 * the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of calls to MyCalendar.book per test case will be at most 1000.
 * In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 */
public class Leetcode731 {
    class MyCalendarTwo {
        TreeMap<Integer, Integer> doubleBook;
        TreeMap<Integer, Integer> single;

        public MyCalendarTwo() {
            doubleBook = new TreeMap<>();
            single = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            if (isOverlap(start, end)) return false;
            Integer prevStart = single.floorKey(start);
            if (prevStart == null || single.get(prevStart) <= start) prevStart = start;
            Map<Integer, Integer> map = single.subMap(prevStart, end);
            if (map.isEmpty()) {
                single.put(start, end);
                return true;
            }
            rearrange(map, start, end);
            return true;
        }

        /**
         * 重新安排区间，找到最小的二次重叠区间，放进doubleBook
         *
         * @param map   key为start.....end之间的map
         * @param start
         * @param end
         */
        private void rearrange(Map<Integer, Integer> map, int start, int end) {
            Map<Integer, Integer> temp = new TreeMap<>(map);
            for (Map.Entry<Integer, Integer> entry :
                    temp.entrySet()) {
                single.remove(entry.getKey());
                if (start < entry.getKey()) {
                    single.put(start, entry.getKey());
                    start = entry.getKey();
                } else if (start > entry.getKey()) {
                    single.put(entry.getKey(), start);
                }
                if (end < entry.getValue()) {//存在两个区间重合
                    doubleBook.put(start, end);
                    single.put(end, entry.getValue());
                    end = -1;
                    break;
                } else if (end == entry.getValue()) {
                    doubleBook.put(start, end);
                    end = -1;
                    break;
                } else {
                    doubleBook.put(start, entry.getValue());
                    start = entry.getValue();
                }
            }
            if (start < end) single.put(start, end);
        }

        /**
         * 时间区间发生重合
         *
         * @param start
         * @param end
         * @return
         */
        private boolean isOverlap(int start, int end) {
            if (doubleBook.isEmpty()) return false;
            Integer nextStart = doubleBook.ceilingKey(start);
            if (nextStart != null && end > nextStart) return true;
            Integer prevStart = doubleBook.floorKey(start);
            if (prevStart != null && doubleBook.get(prevStart) > start) return true;
            return false;
        }
    }
}
