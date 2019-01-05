package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 1/5/19 14:51
 * @Description: Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 * <p>
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class Leetcode149 {
    public static void main(String[] args) {
        //[[0,0],[94911151,94911150],[94911152,94911151]]
        Point p1 = new Point(0, 0);
        Point p2 = new Point(94911151, 94911150);
        Point p3 = new Point(94911152, 94911151);
        Point[] points = {p1, p2, p3};
        Leetcode149 leetcode149 = new Leetcode149();
        leetcode149.maxPoints(points);
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    /**
     * 存储计算斜率的分子和分母
     */
    class Pair {
        int deltaY;
        int deltaX;

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Pair pair = (Pair) obj;
            if (deltaY != pair.deltaY) return false;
            return deltaX == pair.deltaX;
        }

        @Override
        public int hashCode() {
            int result = deltaY;
            result = 31 * result + deltaX;
            return result;
        }
    }

    public int maxPoints(Point[] points) {
        //用斜率计算会有精度问题
        if (points == null || points.length == 0) {
            return 0;
        }
        int max = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            //存储从该点出发的某个斜率直线上的点的个数
            Map<Pair, Integer> map = new HashMap<>();
            //平行于y轴方向上的点
            int verticalLine = 1;
            //最多点的直线上的点数
            int onePointMax = 1;
            //重复的点
            int samePoint = 0;
            for (int j = i + 1; j < len; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {//点重复了
                    samePoint++;
                } else if (points[j].x == points[i].x) {//平行于y轴
                    verticalLine++;
                    onePointMax = Math.max(onePointMax, verticalLine);
                } else {
                    int gcd = gcd(points[j].y - points[i].y, points[j].x - points[i].x);
                    Pair p = new Pair();
                    p.deltaY = (points[j].y - points[i].y) / gcd;
                    p.deltaX = (points[j].x - points[i].x) / gcd;
                    int count = 2;
                    if (map.containsKey(p)) {
                        count = map.get(p);
                        count++;
                        map.put(p, count);
                    } else {
                        map.put(p, count);
                    }
                    onePointMax = Math.max(onePointMax, count);
                }
            }
            max = Math.max(onePointMax + samePoint, max);
        }
        return max;
    }

    /**
     * 求出两个数的最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
