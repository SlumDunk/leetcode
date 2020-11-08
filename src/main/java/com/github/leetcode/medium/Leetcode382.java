package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

import java.util.Random;

/**
 * @Author: zerongliu
 * @Date: 11/15/18 19:24
 * @Description: Given a singly linked list, return a random node's frequency from the linked list. Each node must have the same probability of being chosen.
 * <p>
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 * <p>
 * Example:
 * <p>
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.children = new ListNode(2);
 * head.children.children = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 */
public class Leetcode382 {
    class Solution {
        /**
         * 头结点
         */
        ListNode head;

        /**
         * @param head 头结点
         */
        public Solution(ListNode head) {
            this.head = head;
        }

        /**
         * 随机返回节点的值
         *
         * @return
         */
        public int getRandom() {
            Random random = new Random();
            int result = head.val;
            ListNode curNode = head;
            //蓄水池算法，假设有3个节点
            //第一个节点留下的概率是1*1/2*2/3=1/3
            //第二个节点留下的概率是1/2*2/3=1/3
            //第三个节点留下的概率是1/3
            for (int i = 1; curNode.next != null; i++) {
                curNode = curNode.next;
                if (random.nextInt(i + 1) == i) {
                    result = curNode.val;
                }
            }
            return result;
        }
    }

}
