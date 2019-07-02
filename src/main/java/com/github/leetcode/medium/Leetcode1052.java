package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 08:42
 * @Description: Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
 * <p>
 * On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
 * <p>
 * The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
 * <p>
 * Return the maximum number of customers that can be satisfied throughout the day.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * Output: 16
 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 */
public class Leetcode1052 {
    /**
     * 1 0 1 2 1 1 7 5
     * 0 1 0 1 0 1 0 1
     * 3
     *
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0;
        //存储不满意分数的累积和
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            if (i - X >= 0) {//超过能cover的范围了，滑动窗口
                if (grumpy[i - X] == 1) sum -= customers[i - X];
            }
            res = Math.max(res, sum);
        }
        //把满意的分数加上
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) res += customers[i];
        }
        return res;
    }
}
