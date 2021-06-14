package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,4,2,7,5,3,8,6,9]
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 * Example 3:
 * <p>
 * Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
 * Output: [1,4,2,5,3,8,6,9,7,10,11]
 * Example 4:
 * <p>
 * Input: nums = [[1,2,3,4,5,6]]
 * Output: [1,2,3,4,5,6]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i].length <= 10^5
 * 1 <= nums[i][j] <= 10^9
 * There at most 10^5 elements in nums.
 */
public class Leetcode1424 {

    /**
     * 超时
     *
     * @param nums
     * @return
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size();
        int n = 0;
        for (int i = 0; i < nums.size(); i++) {
            n = Math.max(n, nums.get(i).size());
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums.get(i - j) != null && nums.get(i - j).size() > j) {
                    ans.add(nums.get(i - j).get(j));
                }
            }
        }

        for (int i = 1; i < n; i++) {
            int sum = m - 1 + i;
            for (int j = m - 1; j >= 0; j--) {
                if (nums.get(j) != null && nums.get(j).size() > sum - j) {
                    ans.add(nums.get(j).get(sum - j));
                }
            }

        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public int[] findDiagonalOrder2(List<List<Integer>> nums) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count += nums.get(i).size();
        }

        int[] ans = new int[count];

        TreeMap<Integer, List<Integer>> res = new TreeMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int s = i + j;
                int e = nums.get(i).get(j);
                List<Integer> valList = res.getOrDefault(s, new ArrayList<>());
                valList.add(e);
                res.put(s, valList);
            }
        }
        int ind = 0;
        for (Map.Entry<Integer, List<Integer>> entry : res.entrySet()) {
            List<Integer> valList = entry.getValue();
            for (int i = valList.size() - 1; i >= 0; i--) {
                ans[ind++] = valList.get(i);
            }
        }

        return ans;
    }
}
