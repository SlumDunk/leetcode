package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 21:12
 * @Description: Given a picture consisting of black and white pixels, find the number of black lonely pixels.
 * <p>
 * The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.
 * <p>
 * A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.
 * <p>
 * Example:
 * Input:
 * [['W', 'W', 'B'],
 * ['W', 'B', 'W'],
 * ['B', 'W', 'W']]
 * <p>
 * Output: 3
 * Explanation: All the three 'B's are black lonely pixels.
 * Note:
 * The range of width and height of the input 2D array is [1,500].
 */
public class Leetcode531 {
    public int findLonelyPixel(char[][] picture) {
        int M = picture.length, N = picture[0].length;
        //统计每一行每一列黑色像素的个数
        int[] row = new int[M], col = new int[N];

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
