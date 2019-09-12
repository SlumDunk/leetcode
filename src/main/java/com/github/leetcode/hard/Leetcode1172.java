package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @Author: zerongliu
 * @Date: 9/12/19 15:46
 * @Description: You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has the same maximum capacity.
 * <p>
 * Implement the DinnerPlates class:
 * <p>
 * DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
 * void push(int val) pushes the given positive integer val into the leftmost stack with size less than capacity.
 * int pop() returns the value at the top of the rightmost non-empty stack and removes it from that stack, and returns -1 if all stacks are empty.
 * int popAtStack(int index) returns the value at the top of the stack with the given index and removes it from that stack, and returns -1 if the stack with that given index is empty.
 * Example:
 * <p>
 * Input:
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * Output:
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 * <p>
 * Explanation:
 * DinnerPlates D = DinnerPlates(2);  // Initialize with capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // The stacks are now:  2  4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // Returns 2.  The stacks are now:     4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.push(20);        // The stacks are now: 20  4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.push(21);        // The stacks are now: 20  4 21
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(2);   // Returns 21.  The stacks are now:     4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.pop()            // Returns 5.  The stacks are now:      4
 * 1  3
 * ﹈ ﹈
 * D.pop()            // Returns 4.  The stacks are now:   1  3
 * ﹈ ﹈
 * D.pop()            // Returns 3.  The stacks are now:   1
 * ﹈
 * D.pop()            // Returns 1.  There are no stacks.
 * D.pop()            // Returns -1.  There are still no stacks.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * At most 200000 calls will be made to push, pop, and popAtStack.
 */
public class Leetcode1172 {
    class DinnerPlates {
        /**
         * 栈list
         */
        List<Stack<Integer>> stacks;
        /**
         * 放置还没满的栈的index
         */
        TreeSet<Integer> openStacks;
        int capacity;

        public DinnerPlates(int capacity) {
            this.stacks = new ArrayList();
            this.openStacks = new TreeSet();
            this.capacity = capacity;
        }

        public void push(int val) {
            //已有的栈都满了，开辟新一个
            if (openStacks.isEmpty()) {
                stacks.add(new Stack());
                openStacks.add(stacks.size() - 1);
            }
            //将元素放进最左边未满的栈里头
            stacks.get(openStacks.first()).push(val);
            //候选栈放满了，移除treeet
            if (stacks.get(openStacks.first()).size() == capacity)
                openStacks.pollFirst();
        }

        /**
         * 返回最右边的非空的栈的栈顶元素
         *
         * @return
         */
        public int pop() {
            return myPop(stacks.size() - 1);
        }

        /**
         * @param index 最右边的栈的index
         * @return
         */
        public int popAtStack(int index) {
            return myPop(index);
        }

        private int myPop(int i) {
            if (i < 0 || i >= stacks.size() || stacks.get(i).isEmpty())
                return -1;
            int ret = stacks.get(i).pop();
            //出栈之后，有空位，将该栈的index加入 openStacks
            openStacks.add(i);
            //最右边有栈是空的，移除，回收内存，保证stacks最右边的栈都是非空的
            while (stacks.size() > 0 && stacks.get(stacks.size() - 1).isEmpty())
                stacks.remove((int) openStacks.pollLast()); // Cast is necessary!
            return ret;
        }
    }
}
