package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 13:28
 * @Description: You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
 * <p>
 * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time .
 * <p>
 * Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.
 * <p>
 * Example1
 * <p>
 * Input: [1,0,5]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * 1st move:    1     0 <-- 5    =>    1     1     4
 * 2nd move:    1 <-- 1 <-- 4    =>    2     1     3
 * 3rd move:    2     1 <-- 3    =>    2     2     2
 * Example2
 * <p>
 * Input: [0,3,0]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1st move:    0 <-- 3     0    =>    1     2     0
 * 2nd move:    1     2 --> 0    =>    1     1     1
 * Example3
 * <p>
 * Input: [0,2,0]
 * <p>
 * Output: -1
 * <p>
 * Explanation:
 * It's impossible to make all the three washing machines have the same number of dresses.
 * Note:
 * The range of n is [1, 10000].
 * The range of dresses number in a super washing machine is [0, 1e5].
 */
public class Leetcode517 {
    public static void main(String[] args) {
        Leetcode517 leetcode517 = new Leetcode517();
        int[] machines = new int[]{1, 0, 5};
        leetcode517.findMinMoves(machines);
    }

    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) {
            return -1;
        }

        int sum = 0;
        for (int i : machines) {
            sum += i;
        }

        if (sum % machines.length != 0) {
            return -1;
        }

        int avg = sum / machines.length;
        int move = 0;
        int maxMoveAbs = 0;


        for (int i : machines) {
            int delta = i - avg;
            if (delta == 0) {
                continue;
            }
            //delta > 0， 输出；delta<0, 输入
            move += delta;
            if (delta > 0) {//如果此位置是对外输出
                maxMoveAbs = Math.max(maxMoveAbs, delta);
            }
            maxMoveAbs = Math.max(maxMoveAbs, Math.abs(move));

        }
        return maxMoveAbs;
    }
}
