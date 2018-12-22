package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 12/21/18 14:34
 * @Description: Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * <p>
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class Leetcode24 {
    public static void main(String[] args) {
        Leetcode24 leetcode24 = new Leetcode24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        leetcode24.swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        //注意空值
        if (head == null) {
            return null;
        }
        if (head.next == null) {//只有一个节点
            return head;
        }
        //两两一组
        ListNode odd = head;
        ListNode even = head.next;
        //最终的头结点
        head = head.next;

        //下一波交换开始的地方
        ListNode previousNode = null;
        ListNode nextNode = even.next;
        while (odd != null || even != null) {
            //交换当前两个节点的值
            if (previousNode != null && even != null) {
                //奇数节点的前置节点指向偶数节点
                previousNode.next = even;
            }
            //奇数节点的下一个节点指向偶数节点的下一个节点
            if (even != null) {
                odd.next = even.next;
                //偶数节点的下一个节点指针指向奇数节点
                even.next = odd;
            }

            //交换完成，当前奇数节点变成下一轮的前置节点
            previousNode = odd;
            if (nextNode != null) {
                //下一轮的开始节点赋予奇数节点
                odd = nextNode;
                //下一轮的偶数节点
                even = nextNode.next;
                //下下一轮的开始节点
                if (even != null) {
                    nextNode = even.next;
                } else {
                    nextNode = null;
                }
            } else {
                even = null;
                odd = null;
            }
        }

        return head;
    }
}
