package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 12/3/18 14:01
 * @Description: A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 * <p>
 * Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
 * <p>
 * Example 1:
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * <p>
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * Note:
 * N is an integer within the range [1, 20,000].
 * The elements of A are all distinct.
 * Each element of A is an integer within the range [0, N-1].
 */
public class Leetcode565 {
    /**
     * 保存中间结果
     */
    Map<Integer, Integer> lengthMap = new HashMap<Integer, Integer>();

    public int arrayNesting(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else {
            //存储访问过的位置索引
            Set<Integer> indexSet = new HashSet<Integer>();
            //最长长度
            int max = 0;
            for (int i = 0; i < len; i++) {
                //只需遍历森林中不同的树的根节点
                if (!indexSet.contains(i)) {
                    max = Math.max(max, findNestLength(nums, i, indexSet));
                }
            }
            return max;
        }
    }

    /**
     * 查找从根index出发的子树长度
     * @param nums 数组
     * @param index 出发位置
     * @param indexSet 访问过的位置
     * @return
     */
    private int findNestLength(int[] nums, int index, Set<Integer> indexSet) {
        if (indexSet.contains(index)) {
            return 0;
        } else {
            indexSet.add(index);
            int tmpLength = 0;
            if (lengthMap.containsKey(nums[index])) {
                tmpLength = 1 + lengthMap.get(nums[index]);
            } else {
                tmpLength = 1 + findNestLength(nums, nums[index], indexSet);
            }
            lengthMap.put(index, tmpLength);
            return tmpLength;
        }
    }
}
