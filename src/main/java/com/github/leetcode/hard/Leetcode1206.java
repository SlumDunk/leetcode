package com.github.leetcode.hard;

import java.util.Random;

/**
 * Design a Skiplist without using any built-in libraries.
 * <p>
 * A skiplist is a data structure that takes O(log(n)) time to add, erase and search. Comparing with treap and red-black tree which has the same function and performance, the code length of Skiplist can be comparatively short and the idea behind Skiplists is just simple linked lists.
 * <p>
 * For example, we have a Skiplist containing [30,40,50,60,70,90] and we want to add 80 and 45 into it. The Skiplist works this way:
 * <p>
 * <p>
 * Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
 * <p>
 * You can see there are many layers in the Skiplist. Each layer is a sorted linked list. With the help of the top layers, add, erase and search can be faster than O(n). It can be proven that the average time complexity for each operation is O(log(n)) and space complexity is O(n).
 * <p>
 * See more about Skiplist: https://en.wikipedia.org/wiki/Skip_list
 * <p>
 * Implement the Skiplist class:
 * <p>
 * Skiplist() Initializes the object of the skiplist.
 * bool search(int target) Returns true if the integer target exists in the Skiplist or false otherwise.
 * void add(int num) Inserts the value num into the SkipList.
 * bool erase(int num) Removes the value num from the Skiplist and returns true. If num does not exist in the Skiplist, do nothing and return false. If there exist multiple num values, removing any one of them is fine.
 * Note that duplicates may exist in the Skiplist, your code needs to handle this situation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
 * [[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
 * Output
 * [null, null, null, null, false, null, true, false, true, false]
 * <p>
 * Explanation
 * Skiplist skiplist = new Skiplist();
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0); // return False
 * skiplist.add(4);
 * skiplist.search(1); // return True
 * skiplist.erase(0);  // return False, 0 is not in skiplist.
 * skiplist.erase(1);  // return True
 * skiplist.search(1); // return False, 1 has already been erased.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= num, target <= 2 * 104
 * At most 5 * 104 calls will be made to search, add, and erase.
 */
public class Leetcode1206 {
    /**
     * https://leetcode.com/problems/design-skiplist/discuss/441212/Short-Java-solution-(average-greater-90-in-time-and-100-in-memory)
     */
    class Skiplist {
        class Node {
            int val;
            int count; // 处理 duplicates
            int h; // 所在的高度
            Node[] next; // 可能指向 0-32 随机的一层

            public Node(int val, int h) {
                this.val = val;
                this.h = h;
                this.count = 1;
                next = new Node[33];
            }
        }

        Node sentinel = new Node(Integer.MIN_VALUE, 32); //一个虚拟前置节点
        int topLevel = 0;
        Node[] stack = new Node[33]; // 回溯的时候使用
        Random rand = new Random();

        public Skiplist() {

        }

        /**
         * 找到最底层的 the first node with val >=num 的前置节点
         *
         * @param num
         * @return
         */
        private Node findPred(int num) {
            Node cur = sentinel;
            // 从上往下找
            for (int r = topLevel; r >= 0; r--) {
                while (cur.next[r] != null && cur.next[r].val < num) {
                    cur = cur.next[r];
                }
                stack[r] = cur; //记录是从当前层哪个 node 跳过去的
            }
            return cur;
        }

        public boolean search(int target) {
            Node pred = findPred(target);
            return pred.next[0] != null && pred.next[0].val == target;
        }

        public void add(int num) {
            Node pred = findPred(num);
            // 如果等于 num, 直接 count++
            if (pred.next[0] != null && pred.next[0].val == num) {
                pred.next[0].count++;
                return;
            }
            // 创建新的节点
            Node w = new Node(num, pickHeight());
            // 如果高度大于当前最高高度
            while (topLevel < w.h) stack[++topLevel] = sentinel;
            // 从下往上绑定节点关系
            for (int i = 0; i <= w.h; i++) {
                Node curNode = stack[i];
                w.next[i] = curNode.next[i];
                curNode.next[i] = w;
            }
        }

        public boolean erase(int num) {
            Node pred = findPred(num);
            if (pred.next[0] == null || pred.next[0].val != num) return false;
            boolean noNeedToRemove = --pred.next[0].count != 0;
            if (noNeedToRemove) return true;

            // 从上往下清理
            for (int r = topLevel; r >= 0; r--) {
                Node cur = stack[r];
                if (cur.next[r] != null && cur.next[r].val == num) {
                    cur.next[r] = cur.next[r].next[r];
                }
                if (cur == sentinel && cur.next[r] == null) topLevel--;
            }

            return true;
        }

        private int pickHeight() {
            return Integer.numberOfTrailingZeros(rand.nextInt());
        }
    }
}
