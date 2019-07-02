package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 09:18
 * @Description: On an infinite number line, the position of the i-th stone is given by stones[i].  Call a stone an endpoint stone if it has the smallest or largest position.
 * <p>
 * Each turn, you pick up an endpoint stone and move it to an unoccupied position so that it is no longer an endpoint stone.
 * <p>
 * In particular, if the stones are at say, stones = [1,2,5], you cannot move the endpoint stone at position 5, since moving it to any position (such as 0, or 3) will still keep that stone as an endpoint stone.
 * <p>
 * The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.
 * <p>
 * When the game ends, what is the minimum and maximum number of moves that you could have made?  Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [7,4,9]
 * Output: [1,2]
 * Explanation:
 * We can move 4 -> 8 for one move to finish the game.
 * Or, we can move 9 -> 5, 4 -> 6 for two moves to finish the game.
 * Example 2:
 * <p>
 * Input: [6,5,4,3,10]
 * Output: [2,3]
 * We can move 3 -> 8 then 10 -> 7 to finish the game.
 * Or, we can move 3 -> 7, 4 -> 8, 5 -> 9 to finish the game.
 * Notice we cannot move 10 -> 2 to finish the game, because that would be an illegal move.
 * Example 3:
 * <p>
 * Input: [100,101,104,102,103]
 * Output: [0,0]
 * <p>
 * <p>
 * Note:
 * <p>
 * 3 <= stones.length <= 10^4
 * 1 <= stones[i] <= 10^9
 * stones[i] have distinct values.
 */
public class Leetcode1040 {
    /**
     * Lower Bound
     * As I mentioned in my video last week,
     * in case of n stones,
     * we need to find a consecutive n positions and move the stones in.
     * <p>
     * This idea led the solution with sliding windows.
     * <p>
     * Slide a window of size N, and find how many stones are already in this window.
     * We want moves other stones into this window.
     * For each missing stone, we need at least one move.
     * <p>
     * Generally, the number of missing stones and the moves we need are the same.
     * Only one corner case in this problem, we need to move the endpoint to no endpoint.
     * <p>
     * For case 1,2,4,5,10,
     * 1 move needed from 10 to 3.
     * <p>
     * For case 1,2,3,4,10,
     * 2 move needed from 1 to 6, then from 10 to 5.
     * <p>
     * <p>
     * Upper Bound
     * We try to move all stones to leftmost or rightmost.
     * For example of to rightmost.
     * We move the A[0] to A[1] + 1.
     * Then each time, we pick the stone of left endpoint, move it to the next empty position.
     * During this process, the position of leftmost stones increment 1 by 1 each time.
     * Until the leftmost is at A[n - 1] - n + 1.
     * <p>
     * <p>
     * Complexity
     * Time of quick sorting O(NlogN)
     * Time of sliding window O(N)
     * Space O(1)
     * <p>
     * 1 2 3 4 10
     * 10-2-5+2=5
     * <p>
     * 4-1-5+2=0
     * <p>
     * 把左侧的最小值移动到右侧的空位置
     * <p>
     * 4 7 9
     * 2-3+2=1
     * 3-3+2=2
     *
     * @param stones
     * @return
     */
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        //窗口大小是n
        int i = 0, n = stones.length, low = n;
        //high的取值 填充完n-2之后还剩多少
        int high = Math.max(stones[n - 1] - stones[1] - (n - 2), stones[n - 2] - stones[0] - (n - 2));
        //遍历数组
        for (int j = 0; j < n; ++j) {
            //滑动 差值超过数组长度，不考虑
            while (stones[j] - stones[i] >= n) ++i;
            //窗口大小刚好是n 且连续
            if (j - i == n - 2 && stones[j] - stones[i] == n - 2) {
                low = Math.min(low, 2);
            } else {//j-i+1落在这个范围是n里头的数, n-(j-i+1)是空位数
                low = Math.min(low, n - (j - i + 1));
            }
        }
        return new int[]{low, high};
    }

    public static void main(String[] args) {
        Leetcode1040 leetcode1040 = new Leetcode1040();
        leetcode1040.numMovesStonesII(new int[]{100, 101, 104, 102, 103});
    }
}
