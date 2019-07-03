package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 22:06
 * @Description: There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.
 * Example 1:
 * <p>
 * Input:
 * Height : 5
 * Width : 7
 * Tree position : [2,2]
 * Squirrel : [4,4]
 * Nuts : [[3,0], [2,5]]
 * Output: 12
 * Explanation:
 * ​​​​​
 * Note:
 * <p>
 * All given positions won't overlap.
 * The squirrel can take at most one nut at one time.
 * The given positions of nuts have no order.
 * Height and width are positive integers. 3 <= height * width <= 10,000.
 * The given positions contain at least one nut, only one tree and one squirrel.
 */
public class Leetcode573 {
    /**
     * The idea is only the choice of first nut matters, the other nuts all consume the distance of (2 * mahattan distance of that nut to tree)
     * The total distance = sum of mahattan distance of every nuts to tree * 2 + distance from squirrel to first nut - distance from first nut to tree ,
     * From above equation, the first part is a constant, so we only consider second and third part. So we need to make this difference smallest to make result shortest distance. In code, I call it diff and minDiff
     * <p>
     * 第一个坚果care, 其他采集坚果的路程等于坚果到树的距离*2
     *
     * @param height
     * @param width
     * @param tree
     * @param sqr
     * @param nuts
     * @return
     */
    public int minDistance(int height, int width, int[] tree, int[] sqr, int[][] nuts) {
        int route = 0;
        int minDiff = height + width;
        for (int[] pos : nuts) {
            //sum of mahattan distance of every nuts to tree * 2
            route += 2 * (dist(pos, tree));
            //松鼠到第一个果仁的距离减去第一个果仁到树的距离，前面走了两趟果仁到树，第一个果仁减去一次，因为出发位置不是树
            int diff = dist(pos, sqr) - dist(pos, tree);
            minDiff = Math.min(diff, minDiff);
        }
        route = route + minDiff;
        return route;
    }

    /**
     * 两点间的曼哈顿距离
     *
     * @param p1
     * @param p2
     * @return
     */
    public int dist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
