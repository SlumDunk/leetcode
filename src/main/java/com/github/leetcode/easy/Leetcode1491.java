package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 21:19
 * @Description: Given an array of unique integers salary where salary[i] is the salary of the employee i.
 * <p>
 * Return the average salary of employees excluding the minimum and maximum salary.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: salary = [4000,3000,1000,2000]
 * Output: 2500.00000
 * Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
 * Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500
 * Example 2:
 * <p>
 * Input: salary = [1000,2000,3000]
 * Output: 2000.00000
 * Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
 * Average salary excluding minimum and maximum salary is (2000)/1= 2000
 * Example 3:
 * <p>
 * Input: salary = [6000,5000,4000,3000,2000,1000]
 * Output: 3500.00000
 * Example 4:
 * <p>
 * Input: salary = [8000,9000,2000,3000,6000,1000]
 * Output: 4750.00000
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= salary.length <= 100
 * 10^3 <= salary[i] <= 10^6
 * salary[i] is unique.
 * Answers within 10^-5 of the actual value will be accepted as correct.
 */
public class Leetcode1491 {
    public double average(int[] salary) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int sal : salary) {
            min = Math.min(sal, min);
            max = Math.max(sal, max);
            sum += sal;
        }
        return (double) (sum - max - min) / (salary.length - 2);
    }
}
