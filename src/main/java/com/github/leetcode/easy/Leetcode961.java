package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 15:54
 * @Description: In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * <p>
 * Return the element repeated N times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,1,2,5,3,2]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 * <p>
 * <p>
 * Note:
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length is even
 */
public class Leetcode961 {
    public int repeatedNTimes(int[] A) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int item :
                A) {
            if (count.containsKey(item)) {
                return item;
            } else {
                count.put(item, 1);
            }
        }
        return ans;
    }
}
