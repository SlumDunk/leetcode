package com.github.leetcode.medium;

import java.util.Random;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 6/28/19 22:57
 * @Description: Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.
 * <p>
 * Note:
 * <p>
 * An integer point is a point that has integer coordinates.
 * A point on the perimeter of a rectangle is included in the space covered by the rectangles.
 * ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
 * length and width of each rectangle does not exceed 2000.
 * 1 <= rects.length <= 100
 * pick return a point as an array of integer coordinates [p_x, p_y]
 * pick is called at most 10000 times.
 * Example 1:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * Output:
 * [null,[4,1],[4,1],[3,3]]
 * Example 2:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * Output:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class Leetcode497 {
    class Solution {

        private TreeMap<Integer, Integer> tm = new TreeMap<>();
        private int total = 0;
        private Random rnd = new Random();
        private int[][] rects;

        public Solution(int[][] rects) {
            this.rects = rects;

            for (int i = 0; i < rects.length; i++) {
                int[] p = rects[i];
                int dx = p[2] - p[0] + 1, dy = p[3] - p[1] + 1;
                total += dx * dy;
                tm.put(total, i);
            }
        }

        public int[] pick() {
            //随机取出一个点
            int random = rnd.nextInt(total) + 1;
            Integer ceilingKey = tm.ceilingKey(random), lowerKey = tm.lowerKey(ceilingKey);
            //获取累积到上个长方形位置的点个数
            int prevSum = lowerKey == null ? 0 : lowerKey;
            //获取当前的矩形
            int[] p = rects[tm.get(ceilingKey)];
            //列数
            int cols = p[2] - p[0] + 1, idx = random - prevSum - 1;
            //获取坐标位置
            return new int[]{p[0] + idx % cols, p[1] + idx / cols};
        }
    }
}
