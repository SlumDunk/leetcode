package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 5/11/19 10:34
 * @Description: Your task is to design the basic function of Excel and implement the function of sum formula. Specifically, you need to implement the following functions:
 * <p>
 * Excel(int H, char W): This is the constructor. The inputs represents the height and width of the Excel form. H is a positive integer, range from 1 to 26. It represents the height. W is a character range from 'A' to 'Z'. It represents that the width is the number of characters from 'A' to W. The Excel form content is represented by a height * width 2D integer array C, it should be initialized to zero. You should assume that the first row of C starts from 1, and the first column of C starts from 'A'.
 * <p>
 * <p>
 * void Set(int row, char column, int val): Change the value at C(row, column) to be val.
 * <p>
 * <p>
 * int Get(int row, char column): Return the value at C(row, column).
 * <p>
 * <p>
 * int Sum(int row, char column, List of Strings : numbers): This function calculate and set the value at C(row, column), where the value should be the sum of cells represented by numbers. This function return the sum result at C(row, column). This sum formula should exist until this cell is overlapped by another value or another sum formula.
 * <p>
 * numbers is a list of strings that each string represent a cell or a range of cells. If the string represent a single cell, then it has the following format : ColRow. For example, "F7" represents the cell at (7, F).
 * <p>
 * If the string represent a range of cells, then it has the following format : ColRow1:ColRow2. The range will always be a rectangle, and ColRow1 represent the position of the top-left cell, and ColRow2 represents the position of the bottom-right cell.
 * <p>
 * <p>
 * Example 1:
 * Excel(3,"C");
 * // construct a 3*3 2D array with all zero.
 * //   A B C
 * // 1 0 0 0
 * // 2 0 0 0
 * // 3 0 0 0
 * <p>
 * Set(1, "A", 2);
 * // set C(1,"A") to be 2.
 * //   A B C
 * // 1 2 0 0
 * // 2 0 0 0
 * // 3 0 0 0
 * <p>
 * Sum(3, "C", ["A1", "A1:B2"]);
 * // set C(3,"C") to be the sum of value at C(1,"A") and the values sum of the rectangle range whose top-left cell is C(1,"A") and bottom-right cell is C(2,"B"). Return 4.
 * //   A B C
 * // 1 2 0 0
 * // 2 0 0 0
 * // 3 0 0 4
 * <p>
 * Set(2, "B", 2);
 * // set C(2,"B") to be 2. Note C(3, "C") should also be changed.
 * //   A B C
 * // 1 2 0 0
 * // 2 0 2 0
 * // 3 0 0 6
 * Note:
 * You could assume that there won't be any circular sum reference. For example, A1 = sum(B1) and B1 = sum(A1).
 * The test cases are using double-quotes to represent a character.
 * Please remember to RESET your class variables declared in class Excel, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */
public class Leetcode631 {

    class Excel {
        private class Cell {
            int val = 0;
            /**
             * 存储cell被计算的次数
             */
            Map<Cell, Integer> formula = new HashMap<>();

            public Cell(int val) {
                setValue(val);
            }

            public Cell(String[] formulaStr) {
                setFormula(formulaStr);
            }

            public void setValue(int value) {
                formula.clear();
                this.val = value;
            }

            public void setFormula(String[] formulaStr) {
                formula.clear();
                for (String str :
                        formulaStr) {
                    if (str.indexOf(":") < 0) {
                        int[] pos = getPos(str);
                        addFormulaCell(pos[0], pos[1]);
                    } else {
                        String[] pos = str.split(":");
                        int[] startPos = getPos(pos[0]);
                        int[] endPos = getPos(pos[1]);
                        for (int i = startPos[0]; i <= endPos[0]; i++) {
                            for (int j = startPos[1]; j <= endPos[1]; j++) {
                                addFormulaCell(i, j);
                            }

                        }
                    }
                }
            }

            private void addFormulaCell(int r, int c) {
                if (table[r][c] == null) table[r][c] = new Cell(0);
                Cell rangeCell = table[r][c];
                formula.put(rangeCell, (formula.containsKey(rangeCell) ? formula.get(rangeCell) : 0) + 1);
            }

            private int[] getPos(String str) {
                int[] pos = new int[2];
                pos[1] = str.charAt(0) - 'A';
                pos[0] = Integer.parseInt(str.substring(1));
                return pos;
            }

            private int getValue() {
                if (this.formula.isEmpty()) return this.val;
                int sum = 0;
                for (Cell cell :
                        formula.keySet()) {
                    sum += cell.getValue() * formula.get(cell);
                }
                return sum;
            }
        }

        Cell[][] table;

        public Excel(int H, char W) {
            table = new Cell[H + 1][W - 'A' + 1];
        }

        public void set(int r, char c, int v) {
            if (table[r][c - 'A'] == null) table[r][c - 'A'] = new Cell(v);
            else {
                table[r][c - 'A'].setValue(v);
            }
        }

        public int get(int r, char c) {
            if (table[r][c - 'A'] == null) return 0;
            else return table[r][c - 'A'].getValue();
        }

        public int sum(int r, char c, String[] strs) {
            if (table[r][c - 'A'] == null) {
                table[r][c - 'A'] = new Cell(strs);
            } else {
                table[r][c - 'A'].setFormula(strs);
            }
            return table[r][c - 'A'].getValue();
        }
    }
}
