package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 12/18/18 10:44
 * @Description: Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 */
public class Leetcode36 {
    /**
     * 校验行是否满足条件
     *
     * @param board
     * @return
     */
    private Boolean validateRows(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (!rowSet.add(board[i][j])) {
                    return false;
                }
            }

        }

        return true;
    }

    /**
     * 校验列是否满足条件
     *
     * @param board
     * @return
     */
    private Boolean validateColumns(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                } else if (!colSet.add(board[j][i])) {
                    return false;
                }
            }

        }

        return true;

    }

    /**
     * 校验各个块是否满足条件
     *
     * @param board
     * @return
     */
    private Boolean validateSections(char[][] board) {

        for (int i = 0; i < 3; i++) {
            //存储每3行的元素
            ArrayList<Character> list = new ArrayList<>();
            //[0,3), [3,6),[6,9)
            for (int j = i * 3; j < i * 3 + 3; j++) {
                for (char ch : board[j]) {
                    list.add(ch);
                }
            }

            //存储三个方块
            Set<Character> section1 = new HashSet<>();
            Set<Character> section2 = new HashSet<>();
            Set<Character> section3 = new HashSet<>();

            for (int j = 0; j < list.size(); j++) {

                if (list.get(j) == '.') {
                    continue;
                }
                //最左边方块
                if (j % 9 < 3) {
                    if (!section1.add(list.get(j))) {
                        return false;
                    }
                } else if (j % 9 < 6 && j % 9 >= 3) {//中间方块
                    if (!section2.add(list.get(j))) {
                        return false;
                    }
                } else {
                    if (!section3.add(list.get(j))) {//最右边方块
                        return false;
                    }
                }

            }
        }


        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        //校验行条件，列条件和方块条件
        return (validateRows(board) && validateColumns(board) && validateSections(board));
    }
}
