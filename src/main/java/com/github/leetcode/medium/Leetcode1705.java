package com.github.leetcode.medium;

import java.util.PriorityQueue;

/**
 * There is a special kind of apple tree that grows apples every day for n days. On the ith day, the tree grows apples[i] apples that will rot after days[i] days, that is on day i + days[i] the apples will be rotten and cannot be eaten. On some days, the apple tree does not grow any apples, which are denoted by apples[i] == 0 and days[i] == 0.
 * <p>
 * You decided to eat at most one apple a day (to keep the doctors away). Note that you can keep eating after the first n days.
 * <p>
 * Given two integer arrays days and apples of length n, return the maximum number of apples you can eat.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * Output: 7
 * Explanation: You can eat 7 apples:
 * - On the first day, you eat an apple that grew on the first day.
 * - On the second day, you eat an apple that grew on the second day.
 * - On the third day, you eat an apple that grew on the second day. After this day, the apples that grew on the third day rot.
 * - On the fourth to the seventh days, you eat apples that grew on the fourth day.
 * Example 2:
 * <p>
 * Input: apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * Output: 5
 * Explanation: You can eat 5 apples:
 * - On the first to the third day you eat apples that grew on the first day.
 * - Do nothing on the fouth and fifth days.
 * - On the sixth and seventh days you eat apples that grew on the sixth day.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * apples.length == n
 * days.length == n
 * 1 <= n <= 2 * 104
 * 0 <= apples[i], days[i] <= 2 * 104
 * days[i] = 0 if and only if apples[i] = 0.
 */
public class Leetcode1705 {
    public int eatenApples(int[] apples, int[] days) {
        int[][] arr = new int[apples.length + 1][3];
        for (int i = 0; i < apples.length; i++) {
            arr[i + 1][0] = i + 1;
            arr[i + 1][1] = i + days[i];
            arr[i + 1][2] = apples[i];
        }
        int day = 1;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));
        int count = 0;
        while (!heap.isEmpty() || day <= apples.length) {
            if (day <= apples.length && arr[day][2] > 0) { // add new apples
                heap.offer(arr[day]);
            }
            while (!heap.isEmpty() && heap.peek()[1] < day) { // remove all rot apples
                heap.poll();
            }
            if (!heap.isEmpty()) {
                int[] cur = heap.poll(); // eat an apple
                if (cur[2] > 1) {
                    heap.offer(new int[]{cur[0], cur[1], cur[2] - 1});
                }
                count++;
            }
            day++;
        }
        return count;
    }
}
