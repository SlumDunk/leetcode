package com.github.leetcode.hard;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 21:19
 * @Description: Return the result of evaluating a given boolean expression, represented as a string.
 * <p>
 * An expression can either be:
 * <p>
 * "t", evaluating to True;
 * "f", evaluating to False;
 * "!(expr)", evaluating to the logical NOT of the inner expression expr;
 * "&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner expressions expr1, expr2, ...;
 * "|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner expressions expr1, expr2, ...
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: expression = "!(f)"
 * Output: true
 * Example 2:
 * <p>
 * Input: expression = "|(f,t)"
 * Output: true
 * Example 3:
 * <p>
 * Input: expression = "&(t,f)"
 * Output: false
 * Example 4:
 * <p>
 * Input: expression = "|(&(t,f,t),!(t))"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= expression.length <= 20000
 * expression[i] consists of characters in {'(', ')', '&', '|', '!', 't', 'f', ','}.
 * expression is a valid expression representing a boolean, as given in the description.
 */
public class Leetcode1106 {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operands = new Stack<Character>();
        Stack<Character> operators = new Stack<Character>();
        for (char ch : expression.toCharArray()) {
            if (ch == ',') {
                continue;
            } else if (ch == '(' || ch == 't' || ch == 'f') {
                operands.push(ch);
            } else if (ch == ')') {
                //pop until open bracket
                boolean val;
                char opr = operators.pop();
                String popped = "";
                while (!operands.isEmpty() && operands.peek() != '(') {
                    popped += operands.pop();
                }
                val = eval(opr, popped);
                //把左括号弹出来
                if (!operands.isEmpty())
                    operands.pop();
                if (val == true)
                    operands.push('t');
                else
                    operands.push('f');
            } else if (ch == '&' || ch == '|' || ch == '!') {
                operators.push(ch);
            }
        }
        char res = operands.pop();
        if (res == 't')
            return true;
        else
            return false;
    }

    /**
     * 解析
     *
     * @param opr    操作符
     * @param popped 操作字符串
     * @return
     */
    public boolean eval(char opr, String popped) {
        int tcount = 0;
        for (char ch : popped.toCharArray()) {
            if (ch == 't')
                tcount++;
            if (opr == '&' && ch == 'f')
                return false;
            else if (opr == '!' && ch == 't')
                return false;
            else if (opr == '!' && ch == 'f')
                return true;
        }
        // |
        return tcount > 0 ? true : false;
    }
}
