package com.github.graph;

import java.util.Deque;
import java.util.LinkedList;

public class StackSolution {

    public static Deque<Integer> sortTwoStacks(LinkedList<Integer> s1) {

        // corner case check
        if (s1 == null || s1.size() == 0) {
            return null;
        }

        LinkedList<Integer> s2 = new LinkedList<>();
        return sortTwo(s1, s2);

    }

    private static Deque<Integer> sortTwo(Deque<Integer> s1, Deque<Integer> s2) {
        int global_min = Integer.MIN_VALUE;
        int gloCounter = 0;
        while (s2.size() > 0 && s2.peek() >= global_min) { // peek input 时都小于gloM 说明是result 的一部分

            //1: push all elements from s1 to s2, find the min, use counter; 先pop element， 在更新gloM， counter
            while (!s1.isEmpty()) {
                int cur = s1.pop();
                if (cur < global_min) {
                    global_min = cur;
                    gloCounter = 1;
                } else if (global_min == gloCounter) {
                    gloCounter++;
                }
                s2.push(cur);
            }

            // 2: 把不是gloM的元素放回到 S1； use peek（） trick 把 比golM 大的元素都放回S1
            int cur2 = s2.pop();
            if (cur2 == global_min) {
                continue; // 不放到S1
            } else if (cur2 != global_min) {
                s1.push(cur2);
            }

            // 3: 怎么 把 多少个count 也给push 到 s2 中？
            for (int i = 0; i < gloCounter; i++) {
                s2.push(global_min);
            }
        }
        return s2;

    }

    public static void main(String[] args) {

        StackSolution sol = new StackSolution();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(34);
        stack.push(14);
        stack.push(9);

        Deque<Integer> result = sol.sortTwoStacks(stack);

        System.out.println(result);
//
//        while (stack.size() != 0){
//            System.out.println(stack.peek() + " ");
//        }

    }
}