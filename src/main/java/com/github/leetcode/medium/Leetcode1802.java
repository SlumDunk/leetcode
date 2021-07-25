package com.github.leetcode.medium;

/**
 * You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:
 * <p>
 * nums.length == n
 * nums[i] is a positive integer where 0 <= i < n.
 * abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
 * The sum of all the elements of nums does not exceed maxSum.
 * nums[index] is maximized.
 * Return nums[index] of the constructed array.
 * <p>
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, index = 2,  maxSum = 6
 * Output: 2
 * Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
 * There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].
 * Example 2:
 * <p>
 * Input: n = 6, index = 1,  maxSum = 10
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= maxSum <= 109
 * 0 <= index < n
 */
public class Leetcode1802 {
    public int maxValue(int n, int index, int maxSum) {
        int l = index;
        int r = index;
        int sum = n;
        int ans = 1; // 保底，大家都是 1
        // 从中间点向左右扩散分配
        while (sum + (r - l + 1) <= maxSum) {
            sum += (r - l + 1);
            if (l != 0)
                l -= 1;
            if (r != n - 1)
                r += 1;
            ans++;
            if (l == 0 && r == n - 1) {
                ans += (maxSum - sum) / n;
                sum += (((maxSum - sum) / n) * n);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode1802 leetcode1802 = new Leetcode1802();
        leetcode1802.maxValue(6, 1, 10);
    }
}
