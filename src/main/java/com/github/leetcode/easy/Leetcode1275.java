package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/1/20 20:13
 * @Description: Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
 * <p>
 * Here are the rules of Tic-Tac-Toe:
 * <p>
 * Players take turns placing characters into empty squares (" ").
 * The first player A always places "X" characters, while the second player B always places "O" characters.
 * "X" and "O" characters are always placed into empty squares, never on filled ones.
 * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play.
 * <p>
 * Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending".
 * <p>
 * You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * Output: "A"
 * Explanation: "A" wins, he always plays first.
 * "X  "    "X  "    "X  "    "X  "    "X  "
 * "   " -> "   " -> " X " -> " X " -> " X "
 * "   "    "O  "    "O  "    "OO "    "OOX"
 * Example 2:
 * <p>
 * Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * Output: "B"
 * Explanation: "B" wins.
 * "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
 * "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
 * "   "    "   "    "   "    "   "    "   "    "O  "
 * Example 3:
 * <p>
 * Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * Output: "Draw"
 * Explanation: The game ends in a draw since there are no moves to make.
 * "XXO"
 * "OOX"
 * "XOX"
 * Example 4:
 * <p>
 * Input: moves = [[0,0],[1,1]]
 * Output: "Pending"
 * Explanation: The game has not finished yet.
 * "X  "
 * " O "
 * "   "
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= moves.length <= 9
 * moves[i].length == 2
 * 0 <= moves[i][j] <= 2
 * There are no repeated elements on moves.
 * moves follow the rules of tic tac toe.
 */
public class Leetcode1275 {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] row = new int[n];
        int[] col = new int[n];

        int diagonal = 0;
        int antiDiagonal = 0;
        int res = 0;
        int sign = 0;

        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                sign = 1;
            } else {
                sign = -1;
            }

            res = sign * n;
            int[] temp = moves[i];
            row[temp[0]] += sign;
            col[temp[1]] += sign;

            if (temp[0] == temp[1]) diagonal += sign;
            if (temp[0] == n - 1 - temp[1]) antiDiagonal += sign;

            if (row[temp[0]] == res || col[temp[1]] == res || diagonal == res || antiDiagonal == res) {
                //轮到A的局，A胜， B的局，B胜
                return res > 0 ? "A" : "B";
            }
        }
        if (moves.length == n * n) {
            return "Draw";
        } else {
            return "Pending";
        }
    }
}
