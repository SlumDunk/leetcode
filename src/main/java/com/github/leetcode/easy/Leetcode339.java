package com.github.leetcode.easy;

import com.github.leetcode.vo.NestedInteger;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 20:52
 * @Description: Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 * Example 2:
 * <p>
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */
public class Leetcode339 {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        } else {
            return helper(nestedList, 1);
        }
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger nest :
                nestedList) {
            if (nest.isInteger()) {
                res += nest.getInteger() * depth;
            } else {
                res += helper(nest.getList(), depth + 1);
            }
        }
        return res;
    }
}
