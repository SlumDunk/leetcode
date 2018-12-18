package com.github.leetcode.easy;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class Leetcode832 {
    public static void main(String[] args) {

    }

    public int[][] flipAndInvertImage(int[][] A) {
        int[][] flipImage = flipImage(A);
        return invertImage(flipImage);
    }

    /**
     * 每行reverse
     *
     * @param originalImage
     * @return
     */
    public int[][] flipImage(int[][] originalImage) {
        int temp;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0, k = originalImage[i].length - 1; j < originalImage[i].length / 2; j++, k--) {
                temp = originalImage[i][k];
                originalImage[i][k] = originalImage[i][j];
                originalImage[i][j] = temp;
            }
        }
        return originalImage;
    }

    /**
     * 将1转换为0，将0转换为1
     *
     * @param originalImage
     * @return
     */
    public int[][] invertImage(int[][] originalImage) {
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                if (originalImage[i][j] == 0) {
                    originalImage[i][j] = 1;
                } else {
                    originalImage[i][j] = 0;
                }

            }
        }
        return originalImage;
    }
}

