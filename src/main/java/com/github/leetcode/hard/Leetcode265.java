package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 15:06
 * @Description: There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 * <p>
 * Note:
 * All costs are positive integers.
 * <p>
 * Example:
 * <p>
 * Input: [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 * Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 * Follow up:
 * Could you solve it in O(nk) runtime?
 */
public class Leetcode265 {

    class Color {
        public int index;
        public int value;

        public Color(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        } else {
            int n = costs.length;
            int k = costs[0].length;
            int[][] dp = new int[n][k];

            for (int i = 0; i < k; i++) {
                dp[0][i] = costs[0][i];
            }

            for (int i = 1; i < n; i++) {
                Color firstMin = new Color(0, Integer.MAX_VALUE);
                Color secondMin = new Color(0, Integer.MAX_VALUE);

                //求出上一次最小值
                for (int j = 0; j < k; j++) {
                    if (dp[i - 1][j] < firstMin.value) {
                        firstMin.value = dp[i - 1][j];
                        firstMin.index = j;
                    }
                }
                //求出上一次第二小值
                for (int j = 0; j < k; j++) {
                    if (j == firstMin.index) {
                        continue;
                    }
                    if (dp[i - 1][j] < firstMin.value) {
                        firstMin.value = dp[i - 1][j];
                        firstMin.index = j;
                    }
                }

                for (int j = 0; j < k; j++) {
                    if (j != firstMin.index) {
                        dp[i][j] = firstMin.value + costs[i][j];
                    } else {
                        dp[i][j] = secondMin.value + costs[i][j];
                    }
                }
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                res = Math.min(res, dp[n - 1][i]);
            }
            return res;
        }
    }


    public int minCostII_(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int len = costs.length;
        int k = costs[0].length;


        int[][] dp = new int[len + 1][k];

        for (int i = 0; i < k; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 1) {
                    dp[i][j] = costs[i - 1][j];
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (l != j) {
                        dp[i][j] = Math.min(dp[i - 1][l] + costs[i - 1][j], dp[i][j]);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            result = Math.min(result, dp[len][i]);
        }

        return result;
    }


    class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int minCostII__(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int len = costs.length;
        int k = costs[0].length;


        int[][] dp = new int[len + 1][k];

        for (int i = 0; i < k; i++) {
            dp[0][i] = 0;
        }

        Pair firstMin = new Pair(-1, Integer.MAX_VALUE), secondMin = new Pair(-1, Integer.MAX_VALUE);
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 1) {
                    dp[i][j] = costs[i - 1][j];
                    if (firstMin.value > dp[i][j]) {
                        secondMin.index = firstMin.index;
                        secondMin.value = firstMin.value;

                        firstMin.index = j;
                        firstMin.value = dp[i][j];
                    } else if (secondMin.value > dp[i][j]) {
                        secondMin.index = j;
                        secondMin.value = dp[i][j];
                    }
                    continue;
                }

                if (firstMin.index != j) {
                    dp[i][j] = firstMin.value + costs[i - 1][j];
                } else {
                    dp[i][j] = secondMin.value + costs[i - 1][j];
                }
            }
            firstMin = new Pair(-1, Integer.MAX_VALUE);
            secondMin = new Pair(-1, Integer.MAX_VALUE);
            for (int j = 0; j < k; j++) {
                if (firstMin.value > dp[i][j]) {
                    secondMin.index = firstMin.index;
                    secondMin.value = firstMin.value;

                    firstMin.index = j;
                    firstMin.value = dp[i][j];
                } else if (secondMin.value > dp[i][j]) {
                    secondMin.index = j;
                    secondMin.value = dp[i][j];
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            result = Math.min(result, dp[len][i]);
        }

        return result;
    }
}
