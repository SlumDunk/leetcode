package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 16:44
 * @Description: On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
 * <p>
 * Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
 * <p>
 * <p>
 * <p>
 * We may make the following moves:
 * <p>
 * 'U' moves our position up one row, if the position exists on the board;
 * 'D' moves our position down one row, if the position exists on the board;
 * 'L' moves our position left one column, if the position exists on the board;
 * 'R' moves our position right one column, if the position exists on the board;
 * '!' adds the character board[r][c] at our current position (r, c) to the answer.
 * (Here, the only positions that exist on the board are positions with letters on them.)
 * <p>
 * Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = "leet"
 * Output: "DDR!UURRR!!DDD!"
 * Example 2:
 * <p>
 * Input: target = "code"
 * Output: "RR!DDRR!UUL!R!"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target.length <= 100
 * target consists only of English lowercase letters.
 */
public class Leetcode1138 {

    public static void main(String[] args) {
        Leetcode1138 leetcode1138 = new Leetcode1138();
        System.out.println(leetcode1138.alphabetBoardPath("zdz"));
    }

    char[][] board = new char[][]{
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'},
            {'z'}
    };

    public String alphabetBoardPath(String target) {
        char[] array = target.toCharArray();
        StringBuilder buffer = new StringBuilder();
        int preX = 0, preY = 0;
        for (char letter :
                array) {
            int delta = letter - 'a';
            int x = delta / 5;
            int y = delta % 5;

            int dx = x - preX;
            int dy = y - preY;

            while (dx != 0) {
                if (dx < 0) {
                    buffer.append("U");
                    dx++;
                } else {
                    if (preY != 0 && x == 5 && dx == x - preX) {
                        dx--;
                        continue;
                    }
                    buffer.append("D");
                    dx--;
                }
            }

            while (dy != 0) {
                if (dy < 0) {
                    buffer.append("L");
                    dy++;
                } else {
                    buffer.append("R");
                    dy--;
                }
            }

            if (preY != 0 && x == 5) {
                buffer.append("D");
            }
            buffer.append("!");
            preX = x;
            preY = y;
        }

        return buffer.toString();
    }
}
