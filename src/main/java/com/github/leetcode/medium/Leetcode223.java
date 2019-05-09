package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 21:30
 * @Description: Find the total area covered by two rectilinear rectangles in a 2D plane.
 * <p>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * <p>
 * Rectangle Area
 * <p>
 * Example:
 * <p>
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * Note:
 * <p>
 * Assume that the total area is never beyond the maximum possible frequency of int.
 */
public class Leetcode223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //两个长方形的面积-覆盖区域的面积
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        int overlapRegion = computeOverlapArea(A, B, C, D, E, F, G, H);
        return Math.abs(area1) + Math.abs(area2) - overlapRegion;

    }

    /**
     * 计算覆盖区域的面积
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    public int computeOverlapArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //覆盖区域的宽
        int down = Math.max(B, F);
        int up = Math.min(D, H);
        int width = up - down;

        //覆盖区域的长
        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int length = right - left;

        if (up < down || right < left) {
            return 0;
        } else if (length <= 0 || width <= 0) {
            return 0;
        } else {
            return length * width;
        }
    }
}
