package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/22/19 14:25
 * @Description: An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.
 * <p>
 * Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has size at least 2.
 * <p>
 * Example 1:
 * Input: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
 * Output: 3
 * Explanation:
 * Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
 * Also, there isn't a smaller size set that fulfills the above condition.
 * Thus, we output the size of this set, which is 3.
 * Example 2:
 * Input: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
 * Output: 5
 * Explanation:
 * An example of a minimum sized set is {1, 2, 3, 4, 5}.
 * Note:
 * <p>
 * intervals will have length in range [1, 3000].
 * intervals[i] will have length 2, representing some integer interval.
 * intervals[i][j] will be an integer in [0, 10^8].
 */
public class Leetcode757 {
    public int intersectionSizeTwo(int[][] intervals) {
        //按右边界递增排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        //list中的最大值
        int index = -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //这个interval跟现有加进去的值没有交集
            if (intervals[i][0] > index) {
                index = intervals[i][1];
                list.add(index - 1);
                list.add(index);
            } else {
                //查看是否有超过两个值的交集
                int prev = list.get(list.size() - 2);
                if (prev < intervals[i][0]) {
                    list.add(intervals[i][1]);
                    index = intervals[i][1];
                }
            }
        }
        return list.size();
    }
}
