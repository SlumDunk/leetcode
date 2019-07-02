package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 17:29
 * @Description: Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * <p>
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */
public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1;
        int r = 0;

        for (int n : piles) {
            r = Math.max(r, n);
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (!meetsRequirement(piles, mid, H)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    /**
     * 是否满足在指定时间内吃完香蕉
     *
     * @param piles
     * @param k     吃香蕉速度
     * @param H     可以吃的总时间
     * @return
     */
    private boolean meetsRequirement(int[] piles, int k, int H) {
        int count = 0;
        for (int n : piles) {
            count += n / k;
            if (n % k != 0) {
                count++;
            }
        }
        return count <= H;
    }
}
