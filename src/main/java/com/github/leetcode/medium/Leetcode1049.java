package com.github.leetcode.medium;

import java.util.HashSet;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 20:15
 * @Description: We have a collection of rocks, each rock has a positive integer weight.
 * <p>
 * Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
public class Leetcode1049 {
    public int lastStoneWeightII(int[] stones) {
        HashSet<Integer> lastBalanceSet = new HashSet<>();
        lastBalanceSet.add(0);
        HashSet<Integer> nextBalanceSet = new HashSet<>();

        for (int stone : stones) {
            nextBalanceSet.clear();
            for (int lastBalance : lastBalanceSet) {
                nextBalanceSet.add(Math.abs(lastBalance + stone));
                nextBalanceSet.add(Math.abs(lastBalance - stone));
            }
            //交换
            HashSet<Integer> tmpBalanceSet = lastBalanceSet;
            lastBalanceSet = nextBalanceSet;
            nextBalanceSet = tmpBalanceSet;
        }

        int ret = Integer.MAX_VALUE;
        for (int balance : lastBalanceSet) {
            ret = Math.min(ret, balance);
        }

        return ret;
    }
}
