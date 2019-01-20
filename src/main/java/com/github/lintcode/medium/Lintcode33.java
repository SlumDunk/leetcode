package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/20/19 11:39
 * @Description: The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p>
 * [
 * // Solution 1
 * [".Q..",
 * "...Q",
 * "Q...",
 * "..Q."
 * ],
 * // Solution 2
 * ["..Q.",
 * "Q...",
 * "...Q",
 * ".Q.."
 * ]
 * ]
 * Challenge
 * Can you do it without recursion?
 */
public class Lintcode33 {
    /*
    * @param n: The number of queens
    * @return: All distinct solutions
    */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            result.add(new ArrayList<String>());
            return result;
        } else {
            List<Integer> temp = new ArrayList<>();
            helper(result, temp, n);
            return result;
        }
    }

    public void helper(List<List<String>> result, List<Integer> temp, int n) {
        if (temp.size() == n) {
            result.add(drawChessboard(temp));
            return;
        } else {
            for (int colIndex = 0; colIndex < n; colIndex++) {
                if (isValid(temp, colIndex)) {
                    temp.add(colIndex);
                    helper(result, temp, n);
                    temp.remove(temp.size() - 1);
                } else {
                    continue;
                }
            }
        }
    }

    public List<String> drawChessboard(List<Integer> temp) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            StringBuilder buffer = new StringBuilder();
            for (int j = 0; j < temp.size(); j++) {
                buffer.append(j == temp.get(i) ? 'Q' : '.');
            }
            chessboard.add(buffer.toString());
        }
        return chessboard;
    }

    public boolean isValid(List<Integer> temp, int colIndex) {
        int row = temp.size();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            if (temp.get(rowIndex) == colIndex) {
                return false;
            }
            if (rowIndex + temp.get(rowIndex) == row + colIndex) {
                return false;
            }
            if (rowIndex - temp.get(rowIndex) == row - colIndex) {
                return false;
            }
        }
        return true;
    }
}
