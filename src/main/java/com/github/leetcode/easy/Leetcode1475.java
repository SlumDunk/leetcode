package com.github.leetcode.easy;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 12:47
 * @Description: Given the array prices where prices[i] is the price of the ith item in a shop. There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i], otherwise, you will not receive any discount at all.
 * <p>
 * Return an array where the ith element is the final price you will pay for the ith item of the shop considering the special discount.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [8,4,6,2,3]
 * Output: [4,2,4,2,3]
 * Explanation:
 * For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
 * For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
 * For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
 * For items 3 and 4 you will not receive any discount at all.
 * Example 2:
 * <p>
 * Input: prices = [1,2,3,4,5]
 * Output: [1,2,3,4,5]
 * Explanation: In this case, for all items, you will not receive any discount at all.
 * Example 3:
 * <p>
 * Input: prices = [10,1,1,6]
 * Output: [9,0,1,6]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 500
 * 1 <= prices[i] <= 10^3
 */
public class Leetcode1475 {
    public int[] finalPrices(int[] prices) {
        int ans[] = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        //find next smaller to right element
        for (int i = prices.length - 1; i >= 0; i--) {
            if (stack.size() == 0) ans[i] = prices[i];
            else {
                while (stack.size() > 0 && stack.peek() > prices[i]) stack.pop();
                if (stack.size() == 0) ans[i] = prices[i] - 0;
                else ans[i] = prices[i] - stack.peek();
            }
            stack.push(prices[i]);
        }
        return ans;
    }
}
