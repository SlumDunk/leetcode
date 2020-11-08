package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/31/20 21:04
 * @Description: Given a function  f(x, y) and a value z, return all positive integer pairs x and y where f(x,y) == z.
 * <p>
 * The function is constantly increasing, i.e.:
 * <p>
 * f(x, y) < f(x + 1, y)
 * f(x, y) < f(x, y + 1)
 * The function interface is defined like this:
 * <p>
 * interface CustomFunction {
 * public:
 * // Returns positive integer f(x, y) for any given positive integer x and y.
 * int f(int x, int y);
 * };
 * For custom testing purposes you're given an integer function_id and a target z as input, where function_id represent one function from an secret internal list, on the examples you'll know only two functions from the list.
 * <p>
 * You may return the solutions in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: function_id = 1, z = 5
 * Output: [[1,4],[2,3],[3,2],[4,1]]
 * Explanation: function_id = 1 means that f(x, y) = x + y
 * Example 2:
 * <p>
 * Input: function_id = 2, z = 5
 * Output: [[1,5],[5,1]]
 * Explanation: function_id = 2 means that f(x, y) = x * y
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= function_id <= 9
 * 1 <= z <= 100
 * It's guaranteed that the solutions of f(x, y) == z will be on the range 1 <= x, y <= 1000
 * It's also guaranteed that f(x, y) will fit in 32 bit signed integer if 1 <= x, y <= 1000
 */
public class Leetcode1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList();
        //scan x values
        for (int x = 1; x <= 1000; x++) {
            //check treshold values - if min > z or max < z
            if (customfunction.f(x, 1) > z || customfunction.f(x, 1000) < z)
                break;
            //init y values for binary search lookup
            int l = 1, r = 1000;
            //binary search loop
            while (l < r) {
                //mid point for this iteration
                int y = (r + l) / 2;
                int z1 = customfunction.f(x, y);
                //we found the solution  for this x - move to x + 1
                if (z1 == z) {
                    List<Integer> sol = new ArrayList();
                    sol.add(x);
                    sol.add(y);
                    res.add(sol);
                    break;
                }
                //change search window for next binary search iteration
                if (z1 > z)
                    r = y;
                else
                    l = y + 1;
            }
        }
        return res;
    }

    class CustomFunction {
        public int f(int x, int y) {
            return 0;
        }
    }
}
