package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/21/19 20:13
 * @Description: You are given K eggs, and you have access to a building with N floors from 1 to N.
 * <p>
 * Each egg is identical in function, and if an egg breaks, you cannot drop it again.
 * <p>
 * You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.
 * <p>
 * Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N).
 * <p>
 * Your goal is to know with certainty what the value of F is.
 * <p>
 * What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: K = 1, N = 2
 * Output: 2
 * Explanation:
 * Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
 * Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
 * If it didn't break, then we know with certainty F = 2.
 * Hence, we needed 2 moves in the worst case to know what F is with certainty.
 * Example 2:
 * <p>
 * Input: K = 2, N = 6
 * Output: 3
 * Example 3:
 * <p>
 * Input: K = 3, N = 14
 * Output: 4
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= K <= 100
 * 1 <= N <= 10000
 */
public class Leetcode887 {
    public static void main(String[] args) {
        Leetcode887 leetcode887 = new Leetcode887();
        leetcode887.superEggDrop(3, 14);
    }

    public int superEggDrop(int K, int N) {
        //根据i个蛋确定j层楼的最小移动步数
        int dp[][] = new int[K + 1][N + 1];
        int temp = 0;
        for (int i = 0; i <= N; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= K; i++) {
            int k = 1;
            for (int j = k; j <= N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                //二分查找改进
//                for (int k = 1; k <= j; k++) {
//                    //爆和不爆
//                    temp = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
//                    dp[i][j] = Math.min(dp[i][j], temp);
//                }
                while (k < j && Math.max(dp[i - 1][k - 1], dp[i][j - k]) > Math.max(dp[i - 1][k], dp[i][j - k - 1])) {
                    k++;
                }
                //爆和不爆
                temp = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
                dp[i][j] = Math.min(dp[i][j], temp);
            }
        }

        return dp[K][N];
    }
}
