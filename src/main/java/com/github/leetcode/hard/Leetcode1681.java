package com.github.leetcode.hard;

import java.util.*;

/**
 * You are given an integer array nums​​​ and an integer k. You are asked to distribute this array into k subsets of equal size such that there are no two equal elements in the same subset.
 * <p>
 * A subset's incompatibility is the difference between the maximum and minimum elements in that array.
 * <p>
 * Return the minimum possible sum of incompatibilities of the k subsets after distributing the array optimally, or return -1 if it is not possible.
 * <p>
 * A subset is a group integers that appear in the array with no particular order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,1,4], k = 2
 * Output: 4
 * Explanation: The optimal distribution of subsets is [1,2] and [1,4].
 * The incompatibility is (2-1) + (4-1) = 4.
 * Note that [1,1] and [2,4] would result in a smaller sum, but the first subset contains 2 equal elements.
 * Example 2:
 * <p>
 * Input: nums = [6,3,8,1,3,1,2,2], k = 4
 * Output: 6
 * Explanation: The optimal distribution of subsets is [1,2], [2,3], [6,8], and [1,3].
 * The incompatibility is (2-1) + (3-2) + (8-6) + (3-1) = 6.
 * Example 3:
 * <p>
 * Input: nums = [5,3,3,6,3,3], k = 3
 * Output: -1
 * Explanation: It is impossible to distribute nums into 3 subsets where no two elements are equal in the same subset.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= nums.length <= 16
 * nums.length is divisible by k
 * 1 <= nums[i] <= nums.length
 */
public class Leetcode1681 {
    int k;
    int n;
    Set<Integer> visited = new HashSet<>();
    int ret = Integer.MAX_VALUE;

    /**
     * https://www.youtube.com/watch?v=i2w1z7cQPoA
     * @param nums
     * @param k
     * @return
     */
    public int minimumIncompatibility(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key :
                map.keySet()) {
            if (map.get(key) > k) {
                return -1;
            }
        }

        Arrays.sort(nums);
        this.k = k;
        this.n = nums.length;
        visited.add(0);
        dfs(nums, 0, 1, nums[0], nums[0], 0);
        return ret;
    }

    private void dfs(int[] nums, int cur, int count, int low, int high, int sum) {
        if (count == n / k) {
            int j = 0;
            while (j < n && visited.contains(j)) {
                j++;
            }
            if (j == n) {
                ret = Math.min(ret, sum + high - low);
            } else {
                visited.add(j);
                dfs(nums, j, 1, nums[j], nums[j], sum + high - low);
                visited.remove(j);
            }
        } else {
            int last = -1;
            for (int i = cur + 1; i < n; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                if (nums[i] == nums[cur]) {
                    continue;
                }
                if (i > cur + 1 && nums[i] == last) {
                    continue;
                }
                visited.add(i);
                dfs(nums, i, count + 1, low, nums[i], sum);
                last = nums[i];
                visited.remove(i);
            }
        }
    }

    int ans = Integer.MAX_VALUE;

    /**
     * O(k^n)
     * @param nums
     * @param k
     * @return
     */
    public int minimumIncompatibility2(int[] nums, int k) {
        Arrays.sort(nums);
        helper(nums, 0, new LinkedList<>(), k, nums.length / k, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void helper(int[] nums, int s, LinkedList<LinkedList<Integer>> buckets, int k, int size, int sum) {
        if (sum >= ans) {
            return;
        }
        if (s == nums.length) {
            ans = sum;
        } else {
            for (int i = 0; i < buckets.size(); i++) {
                LinkedList<Integer> bucket = buckets.get(i);
                if (bucket.size() < size && bucket.peekLast() < nums[s]) {
                    int distance = nums[s] - bucket.peekLast();
                    bucket.addLast(nums[s]);
                    helper(nums, s + 1, buckets, k, size, sum + distance);
                    bucket.removeLast();
                }
            }
            if (buckets.size() < k) {
                LinkedList<Integer> bucket = new LinkedList<>();
                bucket.add(nums[s]);
                buckets.addLast(bucket);
                helper(nums, s + 1, buckets, k, size, sum);
                buckets.removeLast();
            }
        }
    }
}
