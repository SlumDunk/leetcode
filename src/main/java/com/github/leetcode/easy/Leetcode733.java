package com.github.leetcode.easy;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 * <p>
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * 1 1 1
 * 1 1 0
 * 1 0 1
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 * <p>
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class Leetcode733 {
    public static void main(String[] args) {
        Leetcode733 leetcode733 = new Leetcode733();
        int[][] image = {{0, 0, 0}, {0, 1, 0}};
        leetcode733.floodFill(image, 1, 1, 1);
    }

    /**
     * O(mn)
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        floodSubFill(image, sr, sc, newColor, oldColor);
        return image;
    }


    private void floodSubFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == oldColor && oldColor != newColor) {
            image[sr][sc] = newColor;
            //left up right down
            floodSubFill(image, sr, sc - 1, newColor, oldColor);
            floodSubFill(image, sr + 1, sc, newColor, oldColor);
            floodSubFill(image, sr, sc + 1, newColor, oldColor);
            floodSubFill(image, sr - 1, sc, newColor, oldColor);
        }
    }
}
