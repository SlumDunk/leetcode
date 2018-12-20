package com.github.leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class Leetcode447 {
    public static void main(String[] args) {

    }

    public int numberOfBoomerangs(int[][] points) {
        //遍历数组，每次以某个点为中心，再次遍历数组，找出它与所有的点的距离关系
        //距离为key,点的数量为value
        int result = 0;
        //创建map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                //计算该点和其他点的距离
                int distance = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (Integer value : map.values()) {
                result += value * (value - 1);//排列组合公式
            }
            //清空map
            map.clear();
        }
        return result;
    }
}
