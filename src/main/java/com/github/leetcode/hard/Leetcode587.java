package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 6/22/19 21:53
 * @Description: There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 * Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 * Explanation:
 * <p>
 * Example 2:
 * <p>
 * Input: [[1,2],[2,2],[4,2]]
 * Output: [[1,2],[2,2],[4,2]]
 * Explanation:
 * <p>
 * Even you only have trees in a line, you need to use rope to enclose them.
 * <p>
 * <p>
 * Note:
 * <p>
 * All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
 * All input integers will range from 0 to 100.
 * The garden has at least one tree.
 * All coordinates are distinct.
 * Input points have NO order. No order required for output.
 * input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class Leetcode587 {
    public static void main(String[] args) {
        Point[] points = new Point[6];
        points[0] = new Point(1, 1);
        points[1] = new Point(2, 2);
        points[2] = new Point(2, 0);
        points[3] = new Point(2, 4);
        points[4] = new Point(3, 3);
        points[5] = new Point(4, 2);
        Leetcode587 leetcode587 = new Leetcode587();
        leetcode587.outerTrees(points);
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<Point> outerTrees(Point[] points) {
        Set<Point> result = new HashSet<>();

        // Find the leftmost point
        Point first = points[0];
        int firstIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < first.x) {
                first = points[i];
                firstIndex = i;
            }
        }
        result.add(first);

        //当前位置点和下标 从最左边开始
        Point cur = first;
        int curIndex = firstIndex;
        do {
            //要判断的点
            Point next = points[0];
            int nextIndex = 0;
            //遍历每个参考点
            for (int i = 1; i < points.length; i++) {
                if (i == curIndex) continue;
                int cross = crossProductLength(cur, points[i], next);
                //只考虑一个方向 ba得在bc的顺时针方向
                if (nextIndex == curIndex || cross > 0 ||
                        // 三点在一条直线上，取离参考点位置最远的点为边界上的点
                        (cross == 0 && distance(points[i], cur) > distance(next, cur))) {
                    next = points[i];
                    nextIndex = i;
                }
            }
            // 把找出来的边界上共线的点坐标加载进去
            for (int i = 0; i < points.length; i++) {
                if (i == curIndex) continue;
                int cross = crossProductLength(cur, points[i], next);
                if (cross == 0) {
                    result.add(points[i]);
                }
            }

            cur = next;
            curIndex = nextIndex;

        } while (curIndex != firstIndex);

        int[][] results=new int[result.size()][2];
        int index=0;
        for (Point point :
                result) {
            results[index][0]=point.x;
            results[index][1]=point.y;
            index++;
        }

        return new ArrayList<Point>(result);
    }

    /**
     * 斜率 判断 左右， 交叉积
     * BA=(A.y-B.y)/(A.x-B.x)=BAy/BAx
     * BC=(C.y-B.y)/(C.x-B.x)=BCy/BCx
     *
     * @param A 开始的点
     * @param B 判断的点
     * @param C 参照点
     * @return
     */
    private int crossProductLength(Point A, Point B, Point C) {
        // Get the vectors' coordinates.
        int BAx = A.x - B.x;
        int BAy = A.y - B.y;
        int BCx = C.x - B.x;
        int BCy = C.y - B.y;

        // Calculate the Z coordinate of the cross product. ba得在bc的顺时针
        return (BAx * BCy - BAy * BCx);
    }

    /**
     * 计算两点间的欧式距离
     *
     * @param p1
     * @param p2
     * @return
     */
    private int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}
