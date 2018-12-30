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
        //叶子节点存储的值
        int val;
        //0节点，1节点
        TrieNode zero, one;
        //是否叶子节点
        boolean isEnd;
    }

    class TrieTree {
        TrieNode root;

        public TrieTree() {
            root = new TrieNode();
        }

        public void insert(int num) {
            TrieNode current = root;
            int j = 1 << 30;
            for (int i = 0; i < 31; i++) {
                int bit = (num & j) == 0 ? 0 : 1;
                if (bit == 1) {//走1分支
                    if (current.one == null) {
                        current.one = new TrieNode();
                    }
                } else {//走0分支
                    if (current.zero == null) {
                        current.zero = new TrieNode();
                    }
                }
                current = bit == 0 ? current.zero : current.one;
                j >>= 1;
            }
            current.isEnd = true;
            current.val = num;
        }
    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        //创建根节点
        TrieTree tree = new TrieTree();
        for (int num :
                nums) {
            tree.insert(num);
        }
        // 获取真正需要开始判断的root
        TrieNode cur = tree.root;
        //找到第一个0节点和1节点非空的节点
        while (cur.zero == null || cur.one == null) {
            cur = cur.zero == null ? cur.one : cur.zero;
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
        //先查看两个节点的四个子分支是否有为空的情况
        if (one.zero == null) {//1分支的0子分支为空，只能走它的1子分支
            return maxHelper(one.one, zero.zero != null ? zero.zero : zero.one);
        } else if (one.one == null) {//1分支的1子分支为空，只能走它的0子分支
            return maxHelper(one.zero, zero.one != null ? zero.one : zero.zero);
        } else if (zero.zero == null) {//0分支的0子分支为空，只能走它的1子分支
            return maxHelper(one.zero != null ? one.zero : one.one, zero.one);
        } else if (zero.one == null) {//0分支的1子分支为空，只能走它的0子分支
            return maxHelper(one.one != null ? one.one : one.zero, zero.zero);
        } else {//四个子节点都不为空
            return Math.max(maxHelper(one.zero, zero.one), maxHelper(one.one, zero.zero));
        }
    }
}
