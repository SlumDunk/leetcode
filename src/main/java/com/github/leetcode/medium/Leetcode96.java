package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 15:55
 * @Description: Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Leetcode96 {
    public static void main(String[] args) {
        Leetcode96 leetcode96=new Leetcode96();
        System.out.println(leetcode96.numTrees(19));
    }
    public int numTrees(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int[] nums = new int[n+1];

        nums[0] = 1;
        nums[1] = 1;

        for(int i = 2;i <= n;i++) {
            for(int j = 0;j < i;j++) {
                nums[i] += nums[j]*nums[i-j-1];
            }
        }

        return nums[n];
    }
}
