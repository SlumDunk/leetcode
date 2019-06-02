package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 5/26/19 10:38
 * @Description: Given a single positive integer x, we will write an expression of the form x (op1) x (op2) x (op3) x ... where each operator op1, op2, etc. is either addition, subtraction, multiplication, or division (+, -, *, or /).  For example, with x = 3, we might write 3 * 3 / 3 + 3 - 3 which is a value of 3.
 * <p>
 * When writing such an expression, we adhere to the following conventions:
 * <p>
 * The division operator (/) returns rational numbers.
 * There are no parentheses placed anywhere.
 * We use the usual order of operations: multiplication and division happens before addition and subtraction.
 * It's not allowed to use the unary negation operator (-).  For example, "x - x" is a valid expression as it only uses subtraction, but "-x + x" is not because it uses negation.
 * We would like to write an expression with the least number of operators such that the expression equals the given target.  Return the least number of operators used.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 3, target = 19
 * Output: 5
 * Explanation: 3 * 3 + 3 * 3 + 3 / 3.  The expression contains 5 operations.
 * Example 2:
 * <p>
 * Input: x = 5, target = 501
 * Output: 8
 * Explanation: 5 * 5 * 5 * 5 - 5 * 5 * 5 + 5 / 5.  The expression contains 8 operations.
 * Example 3:
 * <p>
 * Input: x = 100, target = 100000000
 * Output: 3
 * Explanation: 100 * 100 * 100 * 100.  The expression contains 3 operations.
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= x <= 100
 * 1 <= target <= 2 * 10^8
 */
public class Leetcode964 {
    public static void main(String[] args) {
        Leetcode964 leetcode964 = new Leetcode964();
        leetcode964.leastOpsExpressTarget(3, 19);

    }

    Map<Integer, Integer> memo = new HashMap<>();

    public int leastOpsExpressTarget(int x, int target) {
        if (target == x) {
            return 0;
        }
        if (target < x) {
            return Math.min(target * 2 - 1, (x - target) * 2);
        }

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        double l = Math.log(target) / Math.log(x);
        if (Math.abs(l - Math.round(l)) < 0.00001) {
            memo.put(target, (int) Math.round(l) - 1);
        } else {
            int a = (int) Math.floor(l);
            int result = a + leastOpsExpressTarget(x, target - (int) Math.round(Math.pow(x, a)));
            if (target * 2 > Math.pow(x, a + 1)) {
                //Tricky: if x^(a+1) >= target * 2, no need to calculate it since the result is always greater than a + f(x, target - x^a).
                result = Math.min(result, a + 1 + leastOpsExpressTarget(x, (int) Math.round(Math.pow(x, a+1) - target)));
            }
            memo.put(target, result);
        }
        return memo.get(target);
    }
}
