package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 12:51
 * @Description: Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
 * <p>
 * After doing so, return the head of the final linked list.  You may return any such answer.
 * <p>
 * <p>
 * <p>
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,-3,3,1]
 * Output: [3,1]
 * Note: The answer [1,2,1] would also be accepted.
 * Example 2:
 * <p>
 * Input: head = [1,2,3,-3,4]
 * Output: [1,2,4]
 * Example 3:
 * <p>
 * Input: head = [1,2,3,-3,-2]
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The given linked list will contain between 1 and 1000 nodes.
 * Each node in the linked list has -1000 <= node.val <= 1000.
 */
public class Leetcode1171 {
    /**
     * delete samPreSumNode.children->curNode
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode node = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int preSum = 0;
        while (node != null) {
            preSum += node.val;
            ListNode samePreSumNode = map.get(preSum);
            if (preSum == 0 || samePreSumNode != null) {
                ListNode temp;
                if (preSum == 0) {
                    temp = head;
                    head = node.next;
                } else {
                    temp = samePreSumNode.next;
                    samePreSumNode.next = node.next;
                }

                int tempSum = preSum;
                while (temp.next != node.next) {
                    tempSum += temp.val;
                    map.remove(tempSum);
                    temp = temp.next;
                }
            } else {
                map.put(preSum, node);
            }

            node = node.next;
        }
        return head;
    }
}
