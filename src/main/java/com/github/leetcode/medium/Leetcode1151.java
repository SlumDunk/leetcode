package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 19:04
 * @Description: Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,1,0,1]
 * Output: 1
 * Explanation:
 * There are 3 ways to group all 1's together:
 * [1,1,1,0,0] using 1 swap.
 * [0,1,1,1,0] using 2 swaps.
 * [0,0,1,1,1] using 1 swap.
 * The minimum is 1.
 * Example 2:
 * <p>
 * Input: [0,0,0,1,0]
 * Output: 0
 * Explanation:
 * Since there is only one 1 in the array, no swaps needed.
 * Example 3:
 * <p>
 * Input: [1,0,1,0,1,0,0,1,1,0,1]
 * Output: 3
 * Explanation:
 * One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= data.length <= 10^5
 * 0 <= data[i] <= 1
 */
public class Leetcode1151 {
    public int minSwaps(int[] data) {
        if (data.length <= 2) return 0;
        int total = 0;
        for (int d : data) {
            total += (d == 1 ? 1 : 0);
        }

        if (total == 0 || total == data.length) return 0;

        int left = 0, right = 0;
        //记录某个段中最大的1的和
        int count = 0;
        int max = 0;

        while (right < data.length) {
            if (right - left + 1 <= total) {
                count += data[right++];
            } else {
                max = Math.max(count, max);
                count -= data[left++];
                count += data[right++];
            }
        }

        return total - max;
    }
}
