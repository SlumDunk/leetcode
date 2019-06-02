package com.github.leetcode.hard;

import java.util.HashMap;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 15:50
 * @Description: Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.
 * <p>
 * Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place). Then, if there is a group of 3 or more balls in the same color touching, remove these balls. Keep doing this until no more balls can be removed.
 * <p>
 * Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.
 * <p>
 * Examples:
 * <p>
 * Input: "WRRBBW", "RB"
 * Output: -1
 * Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
 * <p>
 * Input: "WWRRBBWW", "WRBRW"
 * Output: 2
 * Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 * <p>
 * Input:"G", "GGGGG"
 * Output: 2
 * Explanation: G -> G[G] -> GG[G] -> empty
 * <p>
 * Input: "RBYYBBRRB", "YRBGB"
 * Output: 3
 * Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
 * <p>
 * Note:
 * You may assume that the initial row of balls on the table won’t have any 3 or more consecutive balls with the same color.
 * The number of balls on the table won't exceed 20, and the string represents these balls is called "board" in the input.
 * The number of balls in your hand won't exceed 5, and the string represents these balls is called "hand" in the input.
 * Both input strings will be non-empty and only contain characters 'R','Y','B','G','W'.
 */
public class Leetcode488 {
    public int findMinStep(String board, String hand) {
        if (board == null)
            return 0;
        HashMap<Character, Integer> hands = new HashMap<>();
        for (int i = 0; i < hand.length(); i++) {
            hands.put(hand.charAt(i), hands.getOrDefault(hand.charAt(i), 0) + 1);
        }
        return dfs(board, hands);
    }

    /**
     * @param board
     * @param hands
     * @return
     */
    private int dfs(String board, HashMap<Character, Integer> hands) {
        if (board.isEmpty())
            return 0;
        int i = 0, j = 0, ans = Integer.MAX_VALUE;
        while (i < board.length()) {
            while (j < board.length() && (board.charAt(i) == board.charAt(j))) {
                j++;
            }
            int ballNeed = 3 - (j - i);
            if (hands.get(board.charAt(i)) != null && hands.get(board.charAt(i)) >= ballNeed) {
                String newBoard = updateBoard(board.substring(0, i) + board.substring(j));
                hands.put(board.charAt(i), hands.get(board.charAt(i)) - ballNeed);
                int r = dfs(newBoard, hands);
                if (r != -1) {
                    ans = Math.min(ans, r + ballNeed);
                }
                //back track
                hands.put(board.charAt(i), hands.get(board.charAt(i)) + ballNeed);
            }
            i = j;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 消除相同的连续字符超过3个的
     *
     * @param newBoard
     * @return
     */
    private String updateBoard(String newBoard) {
        int i = 0;
        while (i < newBoard.length()) {
            int j = i;
            while (j < newBoard.length() && (newBoard.charAt(i) == newBoard.charAt(j))) {
                j++;
            }
            if (j - i >= 3) {
                newBoard = newBoard.substring(0, i) + newBoard.substring(j);
                i = 0;
            } else {
                ++i;
            }
        }
        return newBoard;
    }
}
