package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 5/24/19 19:49
 * @Description: Given a chemical formula (given as a string), return the count of each atom.
 * <p>
 * An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 * <p>
 * 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
 * <p>
 * Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.
 * <p>
 * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
 * <p>
 * Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 * <p>
 * Example 1:
 * Input:
 * formula = "H2O"
 * Output: "H2O"
 * Explanation:
 * The count of elements are {'H': 2, 'O': 1}.
 * Example 2:
 * Input:
 * formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation:
 * The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * Example 3:
 * Input:
 * formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation:
 * The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * Note:
 * <p>
 * All atom names consist of lowercase letters, except for the first character which is uppercase.
 * The length of formula will be in the range [1, 1000].
 * formula will only consist of letters, digits, and round parentheses, and is a valid formula as defined in the problem.
 */
public class Leetcode726 {
    public static void main(String[] args) {
        Leetcode726 leetcode726 = new Leetcode726();
        String formula = "K4(ON(SO3)2)2";
        leetcode726.countOfAtoms(formula);
    }

    public String countOfAtoms(String formula) {
        List<Integer> stack = new ArrayList<>();
        Map<String, Integer> map = new TreeMap<>();

        int number = 0;
        int tens = 1;
        String curStr = "";
        int multi = 1;

        for (int i = formula.length() - 1; i >= 0; i--) {
            char c = formula.charAt(i);
            if (Character.isDigit(c)) {
                number += (c - '0') * tens;
                tens *= 10;
            } else if (c == ')') {
                if (number != 0) {
                    stack.add(number);
                    multi *= number;
                }
                number = 0;
                tens = 1;
            } else if (c == '(') {
                if (stack.size() > 0) {
                    multi /= stack.get(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                }
            } else if (Character.isUpperCase(c)) {
                int mul = number == 0 ? 1 : number;
                if (curStr.length() > 0) {
                    curStr = c + curStr;
                    map.put(curStr, map.getOrDefault(curStr, 0) + multi * mul);
                } else {
                    map.put(c + "", map.getOrDefault(c + "", 0) + multi * mul);
                }
                curStr = "";
                number = 0;
                tens = 1;
            } else if (Character.isLowerCase(c)) {
                curStr = c + curStr;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (String key :
                map.keySet()) {
            sb.append(key + (map.get(key) == 1 ? "" : map.get(key)));
        }
        return sb.toString();
    }
}
