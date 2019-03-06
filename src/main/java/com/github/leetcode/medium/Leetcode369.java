package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 3/6/19 09:28
 * @Description: Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example :
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 */
public class Leetcode369 {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //i代表最低位非9的节点
        //dummy->1->9->9
        //dummy->9
        ListNode i = dummy;
        ListNode j = dummy;
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }

        i.val++;
        i = i.next;
        while (i != null) {
            i.val = 0;
            i = i.next;
        }
        if(dummy.val==0){
            return dummy.next;
        }else{
            return dummy;
        }
    }
}
