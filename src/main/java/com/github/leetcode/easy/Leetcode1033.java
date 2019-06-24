package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/3/19 10:02
 * @Description: Three stones are on a number line at positions a, b, and c.
 * <p>
 * Each turn, you pick up a stone at an endpoint (ie., either the lowest or highest position stone), and move it to an unoccupied position between those endpoints.  Formally, let's say the stones are currently at positions x, y, z with x < y < z.  You pick up the stone at either position x or position z, and move that stone to an integer position k, with x < k < z and k != y.
 * <p>
 * The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.
 * <p>
 * When the game ends, what is the minimum and maximum number of moves that you could have made?  Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: a = 1, b = 2, c = 5
 * Output: [1,2]
 * Explanation: Move the stone from 5 to 3, or move the stone from 5 to 4 to 3.
 * Example 2:
 * <p>
 * Input: a = 4, b = 3, c = 2
 * Output: [0,0]
 * Explanation: We cannot make any moves.
 * Example 3:
 * <p>
 * Input: a = 3, b = 5, c = 1
 * Output: [1,2]
 * Explanation: Move the stone from 1 to 4; or move the stone from 1 to 2 to 4.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= a <= 100
 * 1 <= b <= 100
 * 1 <= c <= 100
 * a != b, b != c, c != a
 */
public class Leetcode1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] ret = new int[2];
        int[] input = new int[3];
        input[2] = Math.max(Math.max(a, c), b);
        input[0] = Math.min(Math.min(a, c), b);
        input[1] = a + b + c - input[2] - input[0];
        if (input[2] - input[1] == input[1] - input[0] && input[1] - input[0] == 1) {
            ret[0] = 0;
            ret[1] = 0;
            return ret;
        }
        int tmp = input[2] - input[1] > input[1] - input[0] ? input[1] - input[0] : input[2] - input[1];
        ret[0] = tmp <= 2 ? 1 : 2;
        ret[1] = input[2] - input[1] - 1 + input[1] - input[0] - 1;
        return ret;
    }
}
