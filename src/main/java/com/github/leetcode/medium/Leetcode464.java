package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/25/19 15:34
 * @Description: In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.
 * <p>
 * What if we change the game so that players cannot re-use integers?
 * <p>
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.
 * <p>
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.
 * <p>
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 * <p>
 * Example
 * <p>
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 */
public class Leetcode464 {
    /**
     * 每一位标志是都用过
     */
    private byte[] memory;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        memory = new byte[1 << maxChoosableInteger];
        return canIWin(maxChoosableInteger, desiredTotal, 0);
    }

    /**
     * @param maxChoosableInteger
     * @param desiredTotal        剩余的值
     * @param state               当前状态
     * @return
     */
    private boolean canIWin(int maxChoosableInteger, int desiredTotal, int state) {
        if (desiredTotal <= 0) return false;
        //已经访问过
        if (memory[state] != 0) return memory[state] == 1;

        for (int i = 0; i < maxChoosableInteger; ++i) {
            //已经用过了，跳过
            if ((state & (1 << i)) > 0) continue;
            //注意数字是从1开始
            if (!canIWin(maxChoosableInteger, desiredTotal - (i + 1), state | (1 << i))) {
                memory[state] = 1;
                return true;
            }
        }
        //对手赢，置为-1
        memory[state] = -1;
        return false;
    }
}
