package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * You're now a baseball game point recorder.
 * <p>
 * Given a list of strings, each string can be one of the 4 following types:
 * <p>
 * Integer (one round's score): Directly represents the number of points you get
 * in this round. "+" (one round's score): Represents that the points you get in
 * this round are the sum of the last two valid round's points. "D" (one round's
 * score): Represents that the points you get in this round are the doubled data
 * of the last valid round's points. "C" (an operation, which isn't a round's
 * score): Represents the last valid round's points you get were invalid and
 * should be removed. Each round's operation is permanent and could have an
 * impact on the round before and the round after.
 * <p>
 * You need to return the sum of the points you could get in all the rounds.
 * <p>
 * Example 1: Input: ["5","2","C","D","+"]
 * Output: 30 Explanation:
 * Round 1: You
 * could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum
 * is: 7. Operation 1: The round 2's data was invalid. The sum is: 5.
 * Round 3:
 * You could get 10 points (the round 2's data has been removed). The sum is:
 * 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 *
 * @author liuzhongda
 */
public class Leetcode682 {

    public int calPoints(String[] ops) {
        //5, -2, -4, 9, 5,14
        Stack<Integer> stack = new Stack<Integer>();
        for (String value : ops) {
            switch (value) {
                case "C"://撤销上一次结果，直接出栈
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "D"://上次得分的两倍
                    if (!stack.isEmpty()) {
                        stack.push(2 * stack.peek());
                    }
                    break;
                case "+"://前两次得分之和
                    int factor1 = stack.pop();
                    int factor2 = stack.pop();
                    stack.push(factor2);
                    stack.push(factor1);
                    stack.push(factor1 + factor2);
                    break;
                default:
                    stack.push(Integer.parseInt(value));
                    break;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}
