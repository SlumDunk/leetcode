package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 21:46
 * @Description: Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
 * <p>
 * Choosing any x with 0 < x < N and N % x == 0.
 * Replacing the number N on the chalkboard with N - x.
 * Also, if a player cannot make a move, they lose the game.
 * <p>
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * Example 2:
 * <p>
 * Input: 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 1000
 */
public class Leetcode1025 {
    public boolean divisorGame(int N) {
        return divisorGame(N, 1);
    }

    /**
     * @param N
     * @param count 轮次
     * @return
     */
    public boolean divisorGame(int N, int count) {
        if (N <= 1 && count % 2 != 0) {
            return false;
        } else if (N <= 1 && count % 2 == 0) {
            return true;
        }
        return divisorGame(N - 1, count + 1);
    }
}
