package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 3/18/19 13:58
 * @Description: Given an expression such as expression = "e + 8 - a + 5" and an evaluation map such as {"e": 1} (given in terms of evalvars = ["e"] and evalints = [1]), return a list of tokens representing the simplified expression, such as ["-1*a","14"]
 * <p>
 * An expression alternates chunks and symbols, with a space separating each chunk and symbol.
 * A chunk is either an expression in parentheses, a variable, or a non-negative integer.
 * A variable is a string of lowercase letters (not including digits.) Note that variables can be multiple letters, and note that variables never have a leading coefficient or unary operator like "2x" or "-x".
 * Expressions are evaluated in the usual order: brackets first, then multiplication, then addition and subtraction. For example, expression = "1 + 2 * 3" has an answer of ["7"].
 * <p>
 * The format of the output is as follows:
 * <p>
 * For each term of free variables with non-zero coefficient, we write the free variables within a term in sorted order lexicographically. For example, we would never write a term like "b*a*c", only "a*b*c".
 * Terms have degree equal to the number of free variables being multiplied, counting multiplicity. (For example, "a*a*b*c" has degree 4.) We write the largest degree terms of our answer first, breaking ties by lexicographic order ignoring the leading coefficient of the term.
 * The leading coefficient of the term is placed directly to the left with an asterisk separating it from the variables (if they exist.)  A leading coefficient of 1 is still printed.
 * An example of a well formatted answer is ["-2*a*a*a", "3*a*a*b", "3*b*b", "4*a", "5*c", "-6"]
 * Terms (including constant terms) with coefficient 0 are not included.  For example, an expression of "0" has an output of [].
 * Examples:
 * <p>
 * Input: expression = "e + 8 - a + 5", evalvars = ["e"], evalints = [1]
 * Output: ["-1*a","14"]
 * <p>
 * Input: expression = "e - 8 + temperature - pressure",
 * evalvars = ["e", "temperature"], evalints = [1, 12]
 * Output: ["-1*pressure","5"]
 * <p>
 * Input: expression = "(e + 8) * (e - 8)", evalvars = [], evalints = []
 * Output: ["1*e*e","-64"]
 * <p>
 * Input: expression = "7 - 7", evalvars = [], evalints = []
 * Output: []
 * <p>
 * Input: expression = "a * b * c + b * a * c * 4", evalvars = [], evalints = []
 * Output: ["5*a*b*c"]
 * <p>
 * Input: expression = "((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))",
 * evalvars = [], evalints = []
 * Output: ["-1*a*a*b*b","2*a*a*b*c","-1*a*a*c*c","1*a*b*b*b","-1*a*b*b*c","-1*a*b*c*c","1*a*c*c*c","-1*b*b*b*c","2*b*b*c*c","-1*b*c*c*c","2*a*a*b","-2*a*a*c","-2*a*b*b","2*a*c*c","1*b*b*b","-1*b*b*c","1*b*c*c","-1*c*c*c","-1*a*a","1*a*b","1*a*c","-1*b*c"]
 * Note:
 * <p>
 * expression will have length in range [1, 250].
 * evalvars, evalints will have equal lengths in range [0, 100].
 */
public class Leetcode770 {

    /**
     * 单个多项式
     * e.g. -2*a*b*b*c
     */
    class Term implements Comparable<Term> {
        int coef;
        List<String> vars;

        public Term(int n) {
            vars = new ArrayList<>();
            coef = n;
        }

        public Term(String s) {
            vars = new ArrayList<>();
            vars.add(s);
            coef = 1;
        }

        @Override
        public String toString() {
            return coef + varString();
        }

        public String varString() {
            Collections.sort(vars);
            StringBuilder buffer = new StringBuilder();
            for (String s :
                    vars) {
                buffer.append('*');
                buffer.append(s);
            }
            return buffer.toString();
        }

        @Override
        public boolean equals(Object obj) {
            return varString().equals(((Term) obj).varString());
        }

        @Override
        public int compareTo(Term o) {
            if (vars.size() != o.vars.size()) {
                return o.vars.size() - vars.size();
            }
            return varString().compareTo(o.varString());
        }

        public Term multi(Term t) {
            Term result = new Term(coef);
            result.vars.addAll(vars);
            result.coef *= t.coef;
            for (String v :
                    t.vars) {
                result.vars.add(v);
            }
            return result;
        }
    }

    /**
     * 一个sequence由多个多项式组成
     * a list of Terms. e.g. [-2*a*b*b*c, 3*a, 4]
     */
    class Sequence {
        List<Term> terms;

        public Sequence() {
            terms = new ArrayList<>();
        }

        public Sequence(int n) {
            terms = new ArrayList<>();
            terms.add(new Term(n));
        }

        public Sequence(String s) {
            terms = new ArrayList<>();
            terms.add(new Term(s));
        }

        public Sequence(Term t) {
            terms = new ArrayList<>();
            terms.add(t);
        }

        public Sequence add(Sequence sq) {
            for (Term t2 :
                    sq.terms) {
                boolean found = false;
                for (Term t1 :
                        terms) {
                    if (t1.equals(t2)) {
                        t1.coef += t2.coef;
                        if (t1.coef == 0) {
                            terms.remove(t1);
                        }
                        found = true;
                        break;
                    }
                }
                if (!found && t2.coef != 0) {
                    terms.add(t2);
                }
            }
            return this;
        }

        public Sequence multi(Sequence sq) {
            Sequence result = new Sequence();
            for (Term t1 :
                    terms) {
                for (Term t2 :
                        sq.terms) {
                    result.add(new Sequence(t1.multi(t2)));
                }
            }
            return result;
        }
    }

    /**
     * 全局变量
     */
    private int i;

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> map = new HashMap<>();
        for (int j = 0; j < evalvars.length; j++) {
            map.put(evalvars[j], evalints[j]);
        }
        i = 0;
        Sequence sq = helper(expression, map);
        List<String> result = new LinkedList<>();
        Collections.sort(sq.terms);
        for (Term t :
                sq.terms) {
            if (!t.toString().equals("0")) {
                result.add(t.toString());
            }
        }
        return result;
    }

    /**
     * flag 1->add, -1->sub, 0->multi
     *
     * @param expression
     * @param map
     * @return
     */
    private Sequence helper(String expression, Map<String, Integer> map) {
        Stack<Sequence> stack = new Stack<>();
        int flag = 1;
        stack.push(new Sequence(0));
        while (i < expression.length()) {
            if (expression.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (expression.charAt(i) == '(') {//递归调用
                i++;
                Sequence sq = helper(expression, map);
                addToStack(stack, sq, flag);
            } else if (expression.charAt(i) == ')') {//递归结束条件
                break;
            } else if (expression.charAt(i) == '+') {
                flag = 1;
            } else if (expression.charAt(i) == '-') {
                flag = -1;
            } else if (expression.charAt(i) == '*') {
                flag = 0;
            } else if (Character.isDigit(expression.charAt(i))) {//数字
                int j = i + 1;
                while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                    j++;
                }
                int coef = Integer.valueOf(expression.substring(i, j));
                i = j - 1;
                addToStack(stack, new Sequence(coef), flag);
            } else {//非数字
                int j = i + 1;
                while (j < expression.length() && expression.charAt(j) != ' ' && expression.charAt(j) != ')') {
                    j++;
                }
                String var = expression.substring(i, j);
                i = j - 1;
                if (map.containsKey(var)) {
                    addToStack(stack, new Sequence(map.get(var)), flag);
                } else {
                    addToStack(stack, new Sequence(var), flag);
                }
            }
            i++;
        }
        Sequence result = new Sequence();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 1->add, -1->sub, 0->multi
     *
     * @param stack
     * @param sq
     * @param flag
     */
    private void addToStack(Stack<Sequence> stack, Sequence sq, int flag) {
        if (flag == 0) {
            stack.push(stack.pop().multi(sq));
        } else {
            stack.push(sq.multi(new Sequence(flag)));
        }
    }
}
