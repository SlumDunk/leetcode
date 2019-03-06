package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 11:56
 * @Description: The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class Leetcode52 {
    private int count = 0;

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        } else {
            search(new ArrayList<Integer>(), n);
            return count;
        }
    }

    private void search(ArrayList<Integer> cols, int n) {
        if (cols.size() == n) {
            count++;
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private boolean isValid(ArrayList<Integer> cols, int colIndex) {
        int row = cols.size();
        for (int i = 0; i < cols.size(); i++) {
            if (cols.get(i) == colIndex) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(colIndex - cols.get(i))) {
                return false;
            }
        }
        return true;
    }

}
