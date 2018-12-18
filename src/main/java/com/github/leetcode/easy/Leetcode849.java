package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * <p>
 * There is at least one empty seat, and at least one person sitting.
 * <p>
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * <p>
 * Return that maximum distance to closest person.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * Example 2:
 * <p>
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * Note:
 * <p>
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */
public class Leetcode849 {
    public int maxDistToClosest(int[] seats) {
        //保存1出现的位置
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                set.add(i);
            }
        }
        int max = 0;
        //保存距离最近的人的位置
        int closetPersonIndex;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                continue;
            }
            //find the closet person index
            if (set.floor(i) == null) {//左边没人
                closetPersonIndex = set.ceiling(i);
            } else if (set.ceiling(i) == null) {//左边有人，右边没人
                closetPersonIndex = set.floor(i);
            } else {//左右都有人，找最近的
                closetPersonIndex = (i - set.floor(i) < set.ceiling(i) - i) ? set.floor(i) : set.ceiling(i);
            }
            max = Math.max(max, Math.abs(i - closetPersonIndex));
        }
        return max;
    }
}
