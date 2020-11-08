package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 9/24/18 22:22
 * @Description: Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * <p>
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 * <p>
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 * <p>
 * Return a List of ListNode's representing the linked list parts that are formed.
 * <p>
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1:
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.children.val = 2, \root.children.children.val = 3, and root.children.children.children = null.
 * The first element output[0] has output[0].val = 1, output[0].children = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * Example 2:
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * Note:
 * <p>
 * The length of root will be in the range [0, 1000].
 * Each frequency of a node in the input will be an integer in the range [0, 999].
 * k will be an integer in the range [1, 50].
 */
public class Leetcode725 {
    public static void main(String[] args) {

    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        //先得出链表的长度
        int len = getLen(root);
        //每部分的大小
        int partSize = len / k;
        //余下的长度，因为分组的长度差不超过1，所以每个部分分配1
        int rem = len % k;
        //原链表切成k部分
        ListNode[] result = new ListNode[k];
        int forward = 0;
        for (int i = 0; i < k; i++) {
            result[i] = root;
            forward += partSize;
            if (rem > 0) {
                forward += 1;
                rem--;
            }
            //更新root指针root，即每次进行迁移
            root = getNextRoot(root, forward);
            forward = 0;//重新归位
        }
        return result;
    }

    ListNode getNextRoot(ListNode root, int forward) {
        if (root == null) {
            return null;
        }
        //找到下个节点的前置节点
        for (int i = 0; i < forward - 1; i++) {
            root = root.next;
        }
        ListNode next = root.next;
        root.next = null;
        return next;
    }

    /**
     * 获取链表长度
     *
     * @param root
     * @return
     */
    private int getLen(ListNode root) {
        int len = 0;
        while (root != null) {
            root = root.next;
            len++;
        }
        return len;
    }
}
