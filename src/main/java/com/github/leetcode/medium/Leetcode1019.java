package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 6/25/19 08:15
 * @Description: We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 * <p>
 * Each node may have a children larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the children larger value is 0.
 * <p>
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 * <p>
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1,5]
 * Output: [5,5,0]
 * Example 2:
 * <p>
 * Input: [2,7,4,3,5]
 * Output: [7,0,5,5,0]
 * Example 3:
 * <p>
 * Input: [1,7,5,1,9,2,5,1]
 * Output: [7,9,9,9,0,5,0,0]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= node.val <= 10^9 for each node in the linked list.
 * The given list has length in the range [0, 10000].
 */
public class Leetcode1019 {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        //单调递增栈
        Stack<Integer> stack = new Stack<>();
        //从后往前扫
        for (int i = list.size() - 1; i >= 0; i--) {
            //找到最近第一个比当前元素大的数
            while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            } else {
                ans[i] = 0;
            }
            stack.push(list.get(i));
        }
        return ans;
    }
}
