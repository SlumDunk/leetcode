package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 11/4/18 20:48
 * @Description: Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class Leetcode378 {
    public int kthSmallest(int[][] matrix, int k) {
        //下一个最小元素只可能在当前行或下一行行首出现
        //求最小的
        if (k == 1) return matrix[0][0];
        int n = matrix.length;
        //求最大的
        if (k == n * n) return matrix[n - 1][n - 1];
        List<Cell> list = new ArrayList<>(n);
        //将每行行首加入list
        for (int i = 0; i < n; i++) { // O(n)
            list.add(new Cell(i, 0, matrix[i][0]));
        }
        //构建最小堆
        PriorityQueue<Cell> heap = new PriorityQueue<>(list);
        for (int i = 1; i < k; i++) {
            //当前最小元素出堆
            Cell cell = heap.poll();
            //最小元素右边元素进堆
            if (cell.y + 1 < n)
                heap.add(new Cell(cell.x, cell.y + 1, matrix[cell.x][cell.y + 1]));
        }
        return heap.peek().val;
    }

    class Cell implements Comparable<Cell> {
        int x;
        int y;
        int val;

        Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Cell cell) {
            return Integer.compare(val, cell.val);
        }
    }
}
