package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 19:04
 * @Description: Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * <p>
 * Example 1:
 * <p>
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 * <p>
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class Leetcode241 {
    public class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> res = new ArrayList<Integer>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == '+' || ch == '-' || ch == '*') {
                    List<Integer> left = diffWaysToCompute(input.substring(0, i));
                    List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                    for (int l : left) {
                        for (int r : right) {
                            switch (ch) {
                                case '+':
                                    res.add(l + r);
                                    break;
                                case '-':
                                    res.add(l - r);
                                    break;
                                case '*':
                                    res.add(l * r);
                                    break;
                            }
                        }
                    }
                }
            }
            if (res.size() == 0) res.add(Integer.valueOf(input));
            return res;
        }
    }

}
