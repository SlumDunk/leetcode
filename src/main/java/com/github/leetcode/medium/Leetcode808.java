package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 16:58
 * @Description: There are two types of soup: type A and type B. Initially we have N ml of each type of soup. There are four kinds of operations:
 * <p>
 * Serve 100 ml of soup A and 0 ml of soup B
 * Serve 75 ml of soup A and 25 ml of soup B
 * Serve 50 ml of soup A and 50 ml of soup B
 * Serve 25 ml of soup A and 75 ml of soup B
 * When we serve some soup, we give it to someone and we no longer have it.  Each turn, we will choose from the four operations with equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as we can.  We stop once we no longer have some quantity of both types of soup.
 * <p>
 * Note that we do not have the operation where all 100 ml's of soup B are used first.
 * <p>
 * Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time.
 * <p>
 * <p>
 * <p>
 * Example:
 * Input: N = 50
 * Output: 0.625
 * Explanation:
 * If we choose the first two operations, A will become empty first. For the third operation, A and B will become empty at the same time. For the fourth operation, B will become empty first. So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
 * <p>
 * Notes:
 * <p>
 * 0 <= N <= 10^9.
 * Answers within 10^-6 of the true value will be accepted as correct.
 */
public class Leetcode808 {
    /**
     * 100 75 50 25
     * 4 3 2 1
     * @param N
     * @return
     */
    public double soupServings(int N) {
        Map<Integer, Map<Integer, Double>> memo = new HashMap<>();
        //最小公倍数4800
        return N > 4800 ? 1.0 : search(N, N, memo);

    }

    /**
     * @param a
     * @param b
     * @param memo
     * @return
     */
    private double search(int a, int b, Map<Integer, Map<Integer, Double>> memo) {
        if (a <= 0 && b <= 0) return 0.5; //a b都清空了
        if (a <= 0) return 1.0;//a 清空
        if (b <= 0) return 0.0;//a 没清空

        if (has(a, b, memo)) {
            return memo.get(a).get(b);
        }

        double p = 0;
        p += search(a - 100, b, memo);
        p += search(a - 75, b - 25, memo);
        p += search(a - 50, b - 50, memo);
        p += search(a - 25, b - 75, memo);
        p /= 4;
        // store it in memo
        put(a, b, memo, p);
        return p;
    }

    /**
     * 从缓存里获取
     *
     * @param a
     * @param b
     * @param memo
     * @return
     */
    private boolean has(int a, int b, Map<Integer, Map<Integer, Double>> memo) {
        if (!memo.containsKey(a)) return false;

        return memo.get(a).containsKey(b);
    }

    /**
     * 放进缓存里
     *
     * @param a
     * @param b
     * @param memo
     * @param p
     */
    private void put(int a, int b, Map<Integer, Map<Integer, Double>> memo, double p) {
        if (!memo.containsKey(a)) {
            memo.put(a, new HashMap<>());
        }
        memo.get(a).put(b, p);
    }
}
