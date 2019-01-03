package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/1/18 21:23
 * @Description: Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and children. val is the value of the current node, and children is a pointer/reference to the children node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement these functions in your linked list class:
 * <p>
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * Example:
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * Note:
 * <p>
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 */
public class Leetcode707 {
    public static void main(String[] args) {

    }

    class MyLinkedList {
        /**
         * 链表节点类
         */
        private class Node {
            /**
             * 节点值
             */
            public int val;
            /**
             * 指向下一个节点指针
             */
            public Node next;

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }

            public Node(int val) {
                this(val, null);
            }
        }

        /**
         * 虚拟头结点
         */
        private Node dummyHead;
        /**
         * 链表大小
         */
        private int size;

        /**
         * 初始化数据结构
         */
        public MyLinkedList() {
            dummyHead = new Node(-1, null);
            size = 0;
        }

        /**
         * 获取某个位置的元素
         *
         * @param index
         * @return
         */
        public int get(int index) {
            //注意边界条件
            if (index < 0 || index >= size) {
                return -1;
            }
            Node prev = dummyHead;
            //找到index的前置节点
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            return prev.next.val;
        }

        /**
         * 往链表头部插入元素
         *
         * @param val
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * 往链表尾部插入元素
         *
         * @param val
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * 往链表某个位置插入元素
         *
         * @param index
         * @param val
         */
        public void addAtIndex(int index, int val) {
            //注意边界条件
            if (index < 0 || index > size) {
                return;
            }

            Node prev = dummyHead;
            //走到index的前置节点
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = new Node(val, prev.next);
            size++;
        }

        /**
         * 删除某个位置的元素
         *
         * @param index
         */
        public void deleteAtIndex(int index) {
            //注意边界条件
            if (index < 0 || index >= size) {
                return;
            }

            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }
}
