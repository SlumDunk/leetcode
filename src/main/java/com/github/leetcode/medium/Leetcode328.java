package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 11/1/18 20:40
 * @Description: Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 */
public class Leetcode328 {
    public ListNode oddEvenList(ListNode head) {
        //双指针，一个指向奇数节点，一个指向偶数节点
        if (head == null) return head;
        //奇数节点的当前节点，偶数节点的当前节点，偶数节点的头结点
        ListNode odd = head, even = head.next, evenHead = even;
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        //偶数节点链表对接到奇数链表末尾
        odd.next = evenHead;
        return head;
    }
}
