package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 10:44
 * @Description: In LeetCode Store, there are some kinds of items to sell. Each item has a price.
 * <p>
 * However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.
 * <p>
 * You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.
 * <p>
 * Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.
 * <p>
 * You could use any of special offers as many times as you want.
 * <p>
 * Example 1:
 * Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * Output: 14
 * Explanation:
 * There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
 * In special offer 1, you can pay $5 for 3A and 0B
 * In special offer 2, you can pay $10 for 1A and 2B.
 * You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
 * Example 2:
 * Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 * Output: 11
 * Explanation:
 * The price of A is $2, and $3 for B, $4 for C.
 * You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
 * You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
 * You cannot add more items, though only $9 for 2A ,2B and 1C.
 * Note:
 * There are at most 6 kinds of items, 100 special offers.
 * For each item, you need to buy at most 6 of them.
 * You are not allowed to buy more items than you want, even if that would lower the overall price.
 */
public class Leetcode638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //存储每个组合需要的费用
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needs.size(); i++) {
            sb.append("0").append(",");
        }
        map.put(sb.toString(), 0);
        return dfs(price, special, needs, map);
    }

    /**
     * @param price
     * @param specials
     * @param needs
     * @param map
     * @return
     */
    public int dfs(List<Integer> price, List<List<Integer>> specials, List<Integer> needs, Map<String, Integer> map) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needs.size(); i++) {
            sb.append(needs.get(i)).append(",");
        }

        if (map.containsKey(sb.toString())) return map.get(sb.toString());

        int min = findPossibleMax(price, needs);

        for (int i = 0; i < specials.size(); i++) {
            List<Integer> special = specials.get(i);
            //下一个needs
            List<Integer> temp = new ArrayList<>();
            boolean flag = true;

            for (int j = 0; j < needs.size(); j++) {
                //不满足条件，直接跳过
                if (needs.get(j) < special.get(j)) {
                    flag = false;
                    break;
                } else {
                    temp.add(needs.get(j) - special.get(j));
                }
            }

            if (flag) {
                min = Math.min(min, special.get(special.size() - 1) + dfs(price, specials, temp, map));
            }
        }

        map.put(sb.toString(), min);
        return min;
    }

    /**
     * 返回购买这个组合需要的钱
     *
     * @param price
     * @param needs
     * @return
     */
    public int findPossibleMax(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += price.get(i) * needs.get(i);
        }

        return total;
    }
}
