package com.github.leetcode.medium;

import java.sql.Time;
import java.util.*;

/**
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.
 * <p>
 * If there is no common time slot that satisfies the requirements, return an empty array.
 * <p>
 * The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
 * <p>
 * It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * Output: [60,68]
 * Example 2:
 * <p>
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= slots1.length, slots2.length <= 104
 * slots1[i].length, slots2[i].length == 2
 * slots1[i][0] < slots1[i][1]
 * slots2[i][0] < slots2[i][1]
 * 0 <= slots1[i][j], slots2[i][j] <= 109
 * 1 <= duration <= 106
 */
public class Leetcode1229 {

    class TimeSlot {
        int start;
        int end;

        public TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> (a[0] - b[0]));
        Arrays.sort(slots2, (a, b) -> (a[0] - b[0]));

        int n1 = slots1.length;
        int n2 = slots2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            int[] timeSlot1 = slots1[i];
            int[] timeSlot2 = slots2[j];
            //有交集的时候
            if (!(timeSlot1[1] < timeSlot2[0] || timeSlot2[1] < timeSlot1[0])) {
                int start = Math.max(timeSlot1[0], timeSlot2[0]);
                int end = Math.min(timeSlot1[1], timeSlot2[1]);
                if (start + duration <= end) {
                    return Arrays.asList(start, start + duration);
                } else {
                    // 小的就往前移
                    if (timeSlot1[1] < timeSlot2[1]) {
                        i++;
                    } else {
                        j++;
                    }
                }
            }
            if (timeSlot1[1] < timeSlot2[0]) {
                i++;
            } else if (timeSlot1[0] > timeSlot2[1]) {
                j++;
            }
        }
        return Collections.emptyList();
    }
}
