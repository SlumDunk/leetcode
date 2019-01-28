package com.github.lintcode.medium;

import com.github.leetcode.vo.ListNode;

/**
 * @Author: zerongliu
 * @Date: 1/25/19 10:54
 * @Description:
 */
public class Lintcode129 {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return null;
        } else {
            int len = hashTable.length;
            int newCapacity = 2 * len;
            ListNode[] newTable = new ListNode[newCapacity];
            for (int i = 0; i < len; i++) {
                while (hashTable[i] != null) {
                    //负数的情况
                    int newIndex = (hashTable[i].val % newCapacity + newCapacity) % newCapacity;
                    //int newIndex=hashTable[i].val%newCapacity;
                    if (newTable[newIndex] == null) {
                        newTable[newIndex] = new ListNode(hashTable[i].val);
                    } else {
                        ListNode dummyNode = newTable[newIndex];
                        while (dummyNode.next != null) {
                            dummyNode = dummyNode.next;
                        }
                        dummyNode.next = new ListNode(hashTable[i].val);
                    }
                    hashTable[i] = hashTable[i].next;
                }
            }
            return newTable;
        }
    }
}
