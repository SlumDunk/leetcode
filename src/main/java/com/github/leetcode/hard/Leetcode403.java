package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 2/21/19 13:14
 * @Description: A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * <p>
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * <p>
 * If the frog'word last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * <p>
 * Note:
 * <p>
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone'word position will be a non-negative integer < 231.
 * The first stone'word position is always 0.
 * Example 1:
 * <p>
 * [0,1,3,5,6,8,12,17]
 * <p>
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 * <p>
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 * <p>
 * [0,1,2,3,4,8,9,11]
 * <p>
 * Return false. There is no way to jump to the last stone as
 * the gap between the 5th and 6th stone is too large.
 */
public class Leetcode403 {
    public boolean canCross(int[] stones) {
        //存储到达某个石头的last k units set
        HashMap<Integer, HashSet<Integer>> dp = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            dp.put(stones[i], new HashSet<>());
        }
        dp.get(0).add(0);
        //因为stone是递增的
        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int k : dp.get(stone)) {
                //k-1
                if (k - 1 > 0 && dp.containsKey(stone + k - 1)) {
                    dp.get(stone + k - 1).add(k - 1);
                }
                //k
                if (dp.containsKey(stone + k)) {
                    dp.get(stone + k).add(k);
                }
                //k+1
                if (dp.containsKey(stone + k + 1)) {
                    dp.get(stone + k + 1).add(k + 1);
                }
            }
        }
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }

    public boolean canCross__(int[] stones) {
        int n = stones.length;
        Map<Integer, HashSet<Integer>> dp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            dp.put(stones[i], new HashSet<>());
        }

        dp.get(0).add(0);

        //从前往后推
        for (int i = 0; i < n - 1; i++) {
            int stone = stones[i];
            for (int k : dp.get(stone)) {
                if (k - 1 > 0 && dp.containsKey(stone + k - 1)) {
                    dp.get(stone + k - 1).add(k - 1);
                }
                if (dp.containsKey(stone + k)) {
                    dp.get(stone + k).add(k);
                }
                if (dp.containsKey(stone + k + 1)) {
                    dp.get(stone + k + 1).add(k + 1);
                }
            }
        }

        return !dp.get(stones[n - 1]).isEmpty();
    }

    /**
     * 超时版本
     *
     * @param stones
     * @return
     */
    public boolean canCross___(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        boolean ans = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = false;
                } else {
                    //遍历上块石头的可能位置
                    for (int k = 0; k < i; k++) {
                        if (stones[k] + j == stones[i]) {
                            //上一步还是j
                            dp[i][j] |= dp[k][j];
                            //上一步是j-1
                            dp[i][j] |= dp[k][j - 1];
                            //上一步是j+1
                            if (j < n - 1) {
                                dp[i][j] |= dp[k][j + 1];
                            }
                            if (dp[i][j] == true) {
                                break;
                            }
                        }
                    }
                }
                if (i == n - 1) {
                    ans |= dp[i][j];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Leetcode403 leetcode403 = new Leetcode403();
        int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        leetcode403.canCross___(stones);
    }
}
