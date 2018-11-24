package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 11/23/18 16:10
 * @Description: Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * <p>
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * <p>
 * Could you do this in O(n) runtime?
 * <p>
 * Example:
 * <p>
 * Input: [3, 10, 5, 25, 2, 8]
 * <p>
 * Output: 28
 * <p>
 * Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class Leetcode421 {
    class TrieNode {
        int val;
        TrieNode zero, one;
        boolean isEnd;
    }

    class TrieTree {
        TrieNode root;

        public TrieTree() {
            root = new TrieNode();
        }

        public void insert(int num) {
            TrieNode cur = root;
            int j = 1 << 30;
            for (int i = 0; i < 31; i++) {
                // 根据num在j位置的数目判断应该向0还是向1
                int b = (j & num) == 0 ? 0 : 1;
                if (b == 0 && cur.zero == null) {
                    cur.zero = new TrieNode();
                }
                if (b == 1 && cur.one == null) {
                    cur.one = new TrieNode();
                }
                cur = b == 0 ? cur.zero : cur.one;
                j >>= 1;
            }
            cur.isEnd = true;
            cur.val = num;
        }
    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        TrieTree tree = new TrieTree();
        for (int n : nums) {
            tree.insert(n);
        }
        // 获取真正需要开始判断的root
        TrieNode cur = tree.root;
        while (cur.one == null || cur.zero == null) {
            cur = cur.zero != null ? cur.zero : cur.one;
        }
        return maxHelper(cur.one, cur.zero);

    }

    /**
     * 分治法，原则就是尽量使两个分支的高位不同
     * one是1分支，zero是0分支，可以看做图中的左区和右区
     * 1. 当1分支的下一位只有1时，找0分支的0，若没有，就找0分支的1
     * 2. 当1分支的下一位只有0时，找0分支的1，若没有，就找0分支的0
     * 3. 当1分支的下一位0，1均有时，看0分支：如果0分支只有1，则1分支走0，反之则走1
     * 4. 当0，1两个分支均有两个下一位是，尝试1分支走1，0分支走0和1分支走0，0分支走1并取最大值
     */
    private int maxHelper(TrieNode one, TrieNode zero) {
        if (one.isEnd && zero.isEnd) {
            return one.val ^ zero.val;
        }
        if (one.zero == null) {
            return maxHelper(one.one, zero.zero == null ? zero.one : zero.zero);
        } else if (one.one == null) {
            return maxHelper(one.zero, zero.one == null ? zero.zero : zero.one);
        } else if (zero.zero == null) {
            return maxHelper(one.zero, zero.one);
        } else if (zero.one == null) {
            return maxHelper(one.one, zero.zero);
        } else {
            return Math.max(maxHelper(one.one, zero.zero), maxHelper(one.zero, zero.one));
        }
    }
}
