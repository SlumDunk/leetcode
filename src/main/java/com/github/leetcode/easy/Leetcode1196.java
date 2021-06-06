package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 12/25/20 19:46
 * @Description: You have some apples, where arr[i] is the weight of the i-th apple.  You also have a basket that can carry up to 5000 units of weight.
 * <p>
 * Return the maximum number of apples you can put in the basket.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [100,200,150,1000]
 * Output: 4
 * Explanation: All 4 apples can be carried by the basket since their sum of weights is 1450.
 * Example 2:
 * <p>
 * Input: arr = [900,950,800,1000,700,800]
 * Output: 5
 * Explanation: The sum of weights of the 6 apples exceeds 5000 so we choose any 5 of them.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 10^3
 * 1 <= arr[i] <= 10^3
 */
public class Leetcode1196 {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        int remain = 5000;
        for (int i = 0; i < arr.length; i++) {
            if (remain > arr[i]) {
                remain -= arr[i];
                ans++;
            } else {
                return ans;
            }
        }
        return ans;
    }
}
