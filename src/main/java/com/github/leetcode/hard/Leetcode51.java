package com.github.leetcode.hard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 11:04
 * @Description: The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: [
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
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class Leetcode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        if (n == 0) {
            return resultList;
        } else {
            search(resultList, new ArrayList<Integer>(), n);
            return resultList;
        }
    }

    private void search(List<List<String>> resultList, ArrayList<Integer> cols, int n) {
        if (cols.size() == n) {
            resultList.add(drawChessboard(cols));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(resultList, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private boolean isValid(ArrayList<Integer> cols, int colIndex) {
        int row = cols.size();
        for (int i = 0; i < cols.size(); i++) {
            if (cols.get(i) == colIndex) {
                return false;
            }
            if (i + cols.get(i) == row + colIndex) {
                return false;
            }

            if (i - cols.get(i) == row - colIndex) {
                return false;
            }
        }
        return true;
    }

    private List<String> drawChessboard(ArrayList<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder buffer = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                buffer.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(buffer.toString());
        }
        return chessboard;
    }
}
