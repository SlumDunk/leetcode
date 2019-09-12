package com.github.leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 9/12/19 16:37
 * @Description: Consider a matrix M with dimensions width * height, such that every cell has value 0 or 1, and any square sub-matrix of M of size sideLength * sideLength has at most maxOnes ones.
 * <p>
 * Return the maximum possible number of ones that the matrix M can have.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: width = 3, height = 3, sideLength = 2, maxOnes = 1
 * Output: 4
 * Explanation:
 * In a 3*3 matrix, no 2*2 sub-matrix can have more than 1 one.
 * The best solution that has 4 ones is:
 * [1,0,1]
 * [0,0,0]
 * [1,0,1]
 * Example 2:
 * <p>
 * Input: width = 3, height = 3, sideLength = 2, maxOnes = 2
 * Output: 6
 * Explanation:
 * [1,0,1]
 * [1,0,1]
 * [1,0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= width, height <= 100
 * 1 <= sideLength <= width, height
 * 0 <= maxOnes <= sideLength * sideLength
 */
public class Leetcode1183 {
    public static void main(String[] args) {
        Leetcode1183 leetcode1183 = new Leetcode1183();
        leetcode1183.maximumNumberOfOnes(3, 3, 2, 1);
    }

    /**
     * 0 0
     * 0 2
     * 2 0
     * 2 2
     *
     * 1 0
     * 1 2
     * @param width
     * @param height
     * @param sideLength
     * @param maxOnes
     * @return
     */
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[][] sq = new int[sideLength][sideLength];
        //每个位置能放1的最大次数 落在哪个坑里头
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sq[i % sideLength][j % sideLength]++;
            }
        }
        //维护一个最大堆
        Queue<Integer> priorityQueue = new PriorityQueue<>((a1, a2) -> {
            return a2 - a1;
        });
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                priorityQueue.add(sq[i][j]);
            }
        }


        int total = 0;
        for (int i = 0; i < maxOnes; i++) {
            total += priorityQueue.poll();
        }

        return total;
    }
}
