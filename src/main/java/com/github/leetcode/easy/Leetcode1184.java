package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 22:42
 * @Description: A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.
 * <p>
 * The bus goes along both directions i.e. clockwise and counterclockwise.
 * <p>
 * Return the shortest distance between the given start and destination stops.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: distance = [1,2,3,4], start = 0, destination = 1
 * Output: 1
 * Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: distance = [1,2,3,4], start = 0, destination = 2
 * Output: 3
 * Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: distance = [1,2,3,4], start = 0, destination = 3
 * Output: 4
 * Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 */
public class Leetcode1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        //n stops 0~n-1
        // i~(i+1)%n
        //两个路径，要么顺时针到达，要么逆时针到达
        if (destination == start) {
            return 0;
        }
        if (destination < start) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        //顺时针
        int path1 = 0;
        for (int i = start; i < destination; i++) {
            path1 += distance[i];
        }

        int path2 = 0;
        int len = distance.length;
        //逆时针
        for (int i = destination; i < start + len; i++) {
            path2 += distance[i % len];
        }
        return Math.min(path1, path2);
    }
}
