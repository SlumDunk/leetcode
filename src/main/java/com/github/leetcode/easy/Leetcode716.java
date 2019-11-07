package com.github.leetcode.easy;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 3/17/19 22:34
 * @Description: Design a max stack that supports push, pop, top, peekMax and popMax.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 */
public class Leetcode716 {
    class MaxStack {
        Stack<Integer> stack;
        int max = Integer.MIN_VALUE;

        /**
         * initialize your data structure here.
         */
        public MaxStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (x >= max) {
                stack.push(max);
                max = x;
            }
            stack.push(x);
        }

        public int pop() {
            int pop = stack.pop();
            if (pop == max) {
                max = stack.pop();
            }
            return pop;
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return max;
        }

        public int popMax() {
            if (stack.peek() == max) {
                int pop = stack.pop();
                max = stack.pop();
                return pop;
            } else {
                Stack<Integer> temp = new Stack<>();
                while (stack.peek() != max) {
                    temp.push(stack.pop());
                }
                int pop = stack.pop();
                max = stack.pop();
                while (!temp.isEmpty()) {
                    push(temp.pop());
                }
                return pop;
            }
        }
    }


    class MaxStack_ {

        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;

        /**
         * initialize your data structure here.
         */
        public MaxStack_() {

        }

        public void push(int x) {
            if (max <= x) {
                stack.push(max);
                max = x;
            }
            stack.push(x);
        }

        public int pop() {
            int pop = stack.pop();
            if (pop == max) {
                max = stack.pop();
            }
            return pop;
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return max;
        }

        /**
         * O(N)
         *
         * @return
         */
        public int popMax() {
            if (stack.peek() == max) {
                int pop = stack.pop();
                max = stack.pop();
                return pop;
            } else {
                Stack<Integer> temp = new Stack<Integer>();
                while (stack.peek() != max) {
                    temp.push(stack.pop());
                }
                int pop = stack.pop();
                max = stack.pop();
                while (!temp.isEmpty()) {
                    push(temp.pop());
                }
                return pop;
            }
        }
    }

    class MaxStack__ {
        TreeMap<Integer, List<Node>> treeMap = new TreeMap<>();
        DoubleLinkedList ddl;

        public MaxStack__() {
            ddl = new DoubleLinkedList();
        }

        public void push(int x) {
            Node node = ddl.add(x);
            if (!treeMap.containsKey(node.val)) {
                treeMap.put(x, new ArrayList<>());
            }
            treeMap.get(x).add(node);
        }

        public int pop() {
            int val = ddl.pop();
            List<Node> list = treeMap.get(val);
            list.remove(list.size() - 1);
            if (list.isEmpty()) {
                treeMap.remove(val);
            }
            return val;
        }

        public int top() {
            return ddl.peek();
        }

        public int peekMax() {
            return treeMap.lastKey();
        }

        /**
         * O(lgN)
         *
         * @return
         */
        public int popMax() {
            int max = peekMax();
            List<Node> list = treeMap.get(max);
            Node node = list.remove(list.size() - 1);
            ddl.unlink(node);
            if (list.isEmpty()) {
                treeMap.remove(max);
            }
            return max;
        }

        class DoubleLinkedList {
            Node head;
            Node tail;

            public DoubleLinkedList() {
                head = new Node(0);
                tail = new Node(0);
                head.next = tail;
                tail.prev = head;

            }

            public Node add(int x) {
                Node cur = new Node(x);
                tail.prev.next = cur;
                cur.prev = tail.prev;
                cur.next = tail;
                tail.prev = cur;
                return cur;
            }

            public int peek() {
                return tail.prev.val;
            }

            public int pop() {
                return unlink(tail.prev).val;
            }

            public Node unlink(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;

                return node;
            }


        }

        class Node {
            public int val;
            public Node prev;
            public Node next;

            public Node(int val) {
                this.val = val;
            }
        }
    }


    class MaxStack___ {
        TreeMap<Integer, List<Node>> treeMap = new TreeMap<>();
        Deque<Node> ddl;

        public MaxStack___() {
            ddl = new LinkedList();
        }

        public void push(int x) {
            Node node = new Node(x);
            ddl.offerLast(node);
            if (!treeMap.containsKey(node.val)) {
                treeMap.put(x, new ArrayList<>());
            }
            treeMap.get(x).add(node);
        }

        public int pop() {
            Node node = ddl.pollLast();
            List<Node> list = treeMap.get(node.val);
            list.remove(list.size() - 1);
            if (list.isEmpty()) {
                treeMap.remove(node.val);
            }
            return node.val;
        }

        public int top() {
            return ddl.peekLast().val;
        }

        public int peekMax() {
            return treeMap.lastKey();
        }

        /**
         * O(lgN)
         *
         * @return
         */
        public int popMax() {
            int max = peekMax();
            List<Node> list = treeMap.get(max);
            Node node = list.remove(list.size() - 1);
            ddl.remove(node);
            if (list.isEmpty()) {
                treeMap.remove(max);
            }
            return max;
        }

        class Node {
            public int val;

            public Node(int val) {
                this.val = val;
            }
        }
    }
}
