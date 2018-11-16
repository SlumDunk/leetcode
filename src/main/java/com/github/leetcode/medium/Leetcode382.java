package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

import java.util.Random;

/**
 * @Author: zerongliu
 * @Date: 11/15/18 19:24
 * @Description: Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * <p>
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 * <p>
 * Example:
 * <p>
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 */
public class Leetcode382 {
    class Solution {
        ListNode head;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head=head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            Random random=new Random();
            int result=head.val;
            ListNode currNode=head;
            for(int i=1;currNode.next!=null;i++){
                currNode=currNode.next;
                if(random.nextInt(i+1)==i){
                    result=currNode.val;
                }
            }
            return result;
        }
    }

}
