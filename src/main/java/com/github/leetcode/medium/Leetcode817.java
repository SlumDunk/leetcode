package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 20:06
 * @Description: We are given head, the head node of a linked list containing unique integer values.
 * <p>
 * We are also given the list G, a subset of the values in the linked list.
 * <p>
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 * <p>
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 * Note:
 * <p>
 * If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N - 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 */
public class Leetcode817 {
    /**
     * 存储节点和祖宗节点的关系
     */
    private Map<Integer, Integer> roots;
    /**
     * 连通分量个数
     */
    int cnt;

    public int numComponents(ListNode head, int[] G) {
        if (head == null || head.next == null) {
            return G.length;
        }
        roots = new HashMap<>();
        //初始连通分量的大小
        cnt = G.length;
        for (int g : G) {
            roots.put(g, g);
        }
        while (head.next != null) {
            //合并
            if (roots.containsKey(head.val) && roots.containsKey(head.next.val)) {
                int f1 = findRoot(head.val);
                int f2 = findRoot(head.next.val);
                if (f1 != f2) {
                    roots.put(f1, f2);
                    --cnt;
                }
            }
            head = head.next;
        }
        return cnt;
    }

    /**
     * 寻找祖宗节点
     *
     * @param x
     * @return
     */
    private int findRoot(int x) {
        int fx = x;
        //找到祖宗节点
        while (roots.get(fx) != fx) {
            fx = roots.get(fx);
        }
        int p;
        //更新各个节点的祖宗节点
        while (fx != x) {
            //下一个要更新的点
            p = roots.get(x);
            roots.put(x, fx);
            --cnt;
            x = p;
        }
        return fx;
    }
}
