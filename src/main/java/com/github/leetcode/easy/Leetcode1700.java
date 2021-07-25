package com.github.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
 * <p>
 * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
 * <p>
 * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
 * <p>
 * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
 * Output: 0
 * Explanation:
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
 * - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
 * - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
 * - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
 * - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
 * Hence all students are able to eat.
 * Example 2:
 * <p>
 * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i] is 0 or 1.
 * students[i] is 0 or 1.
 */
public class Leetcode1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> stu = new LinkedList<>();
        Stack<Integer> sand = new Stack<>();
        int len = students.length;
        for (int i = 0; i < len; i++) {
            stu.add(students[i]);
        }

        for (int i = len - 1; i >= 0; i--) {
            sand.push(sandwiches[i]);
        }

        int p = 0;
        for (int i = 0; i < len * sandwiches.length; i++) {
            if ((!sand.isEmpty()) && sand.peek() == stu.peek()) {
                sand.pop();
                stu.remove();
            }

            if ((!sand.isEmpty()) && sand.peek() != stu.peek()) {
                stu.add(stu.remove());
            }

            p = stu.size();
        }
        return p;
    }

    public int countStudents2(int[] students, int[] sandwiches) {
        Queue<Integer> que = new LinkedList<>();
        for (int i : students) {
            que.add(i);
        }
        int n;
        for (int i : sandwiches) {
            n = que.size();
            for (int j = 0; j < n; j++) {
                int temp = que.poll();
                if (temp != i) {
                    que.add(temp);
                } else {
                    break;
                }
            }
            if (n == que.size())
                return n;
        }

        return que.size();
    }
}
