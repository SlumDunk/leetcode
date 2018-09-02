package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 15:27
 * @Description: Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given list will be between 1 and 100
 */
public class Leetcode876 {
    public static void main(String[] args) {
        Leetcode876 leetcode876 = new Leetcode876();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(leetcode876.middleNode(head));
    }

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode copyHead = head;
        while (head != null) {
            count++;
            head = head.next;
        }

        int index = count / 2;
        int start = 0;
        while (start < index) {
            copyHead = copyHead.next;
            start++;
        }
        return copyHead;
    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
