package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 09:30
 * @Description: There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * <p>
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 * <p>
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * <p>
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 */
public class Leetcode554 {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        if (n == 0)
            return 0;
        if (n == 1) {
            if (wall.get(0).size() == 1)
                return 1;
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int num;
        //最大的空隙数
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            //每行的累积和
            int curr = 0;
            for (int j = 0; j < wall.get(i).size(); j++) {
                if (j == 0) {
                    curr = wall.get(i).get(j);
                } else {
                    curr = curr + wall.get(i).get(j);
                }
                num = map.getOrDefault(curr, 0) + 1;
                map.put(curr, num);
                //末尾的不记
                if (j != wall.get(i).size() - 1)
                    cnt = Math.max(cnt, num);
            }
        }

        return n - cnt;
    }
}
