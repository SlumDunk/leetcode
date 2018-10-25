package com.github.leetcode.medium;

import com.github.leetcode.vo.RandomListNode;

import java.util.HashMap;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 22:14
 * @Description: A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */
public class Leetcode138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> newMap = new HashMap<>();
        //进行第一次遍历  将节点存入哈希表
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            newMap.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            RandomListNode node = newMap.get(cur);
            node.next = newMap.get(cur.next);
            node.random = newMap.get(cur.random);
            cur = cur.next;
        }
        return newMap.get(head);

    }
}
