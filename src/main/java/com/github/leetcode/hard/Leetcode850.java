package com.github.leetcode.hard;

import com.github.leetcode.vo.Interval;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 5/30/19 11:05
 * @Description: We are given a list of (axis-aligned) rectangles.  Each rectangle[i] = [x1, y1, x2, y2] , where (x1, y1) are the coordinates of the bottom-left corner, and (x2, y2) are the coordinates of the top-right corner of the ith rectangle.
 * <p>
 * Find the total area covered by all rectangles in the plane.  Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
 * Output: 6
 * Explanation: As illustrated in the picture.
 * Example 2:
 * <p>
 * Input: [[0,0,1000000000,1000000000]]
 * Output: 49
 * Explanation: The answer is 10^18 modulo (10^9 + 7), which is (10^9)^2 = (-7)^2 = 49.
 * Note:
 * <p>
 * 1 <= rectangles.length <= 200
 * rectanges[i].length = 4
 * 0 <= rectangles[i][j] <= 10^9
 * The total area covered by all rectangles will never exceed 2^63 - 1 and thus will fit in a 64-bit signed integer.
 */
public class Leetcode850 {
    public static void main(String[] args) {
        Leetcode850 leetcode850 = new Leetcode850();
        int[][] rectangles = new int[][]{{0, 0, 2, 2}, {1, 0, 2, 3},{1, 0, 3, 1}};
        System.out.println(leetcode850.rectangleArea(rectangles));
    }

    /**
     * 存储x位置对应的y值列表
     */
    class IntervalY {
        int[] y;
        /**
         * 是否是end
         */
        boolean isRemove;

        public IntervalY(int[] y, boolean remove) {
            this.y = y;
            isRemove = remove;
        }
    }

    public int rectangleArea(int[][] rectangles) {
        /**
         * 保证有序,每个Interval x方向长度为1
         */
        TreeMap<Integer, List<IntervalY>> map = new TreeMap<Integer, List<IntervalY>>();
        for (int[] rect : rectangles
                ) {
            List<IntervalY> listStart = map.get(rect[0]);
            List<IntervalY> listEnd = map.get(rect[2]);
            if (listStart == null) listStart = new LinkedList<>();
            if (listEnd == null) listEnd = new LinkedList<>();

            int[] ys = new int[]{rect[1], rect[3]};
            listStart.add(new IntervalY(ys, false));
            listEnd.add(new IntervalY(ys, true));
            map.put(rect[0], listStart);
            map.put(rect[2], listEnd);
        }

        long sum = 0, prevX = map.firstKey();
        int mod = (int) 1e9 + 7;
        //滑动跟踪每个interval的y
        TreeMap<Integer, Integer> mapY = new TreeMap<>();
        for (Integer x :
                map.keySet()) {
            List<IntervalY> ys = map.get(x);
            sum += (x - prevX) * getY(mapY);
            sum %= mod;
            prevX = x;

            /**
             * 动态更新interval
             */
            for (IntervalY in :
                    ys) {
                Integer count = mapY.get(in.y[0]);
                if (count == null) count = 0;
                count += (in.isRemove ? -1 : 1);
                if (count == 0) mapY.remove(in.y[0]);
                else mapY.put(in.y[0], count);

                count = mapY.get(in.y[1]);
                if (count == null) count = 0;
                count += (in.isRemove ? 1 : -1);
                if (count == 0) mapY.remove(in.y[1]);
                else mapY.put(in.y[1], count);
            }
        }
        return (int) sum;

    }

    /**
     * 获取y方向边的长度
     *
     * @param map
     * @return
     */
    private long getY(TreeMap<Integer, Integer> map) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, count = 0, res = 0;
        for (int y :
                map.keySet()) {
            boolean isEnd = map.get(y) < 0;
            count += map.get(y);
            if (!isEnd) {
                min = Math.min(min, y);
            } else {
                max = Math.max(max, y);
            }
            if (count == 0) {
                res += (max - min);
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
        }

        return res;
    }
}
