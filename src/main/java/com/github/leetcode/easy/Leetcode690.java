package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.github.leetcode.vo.Employee;

/**
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his
 * direct subordinates' id.
 * <p>
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15,
 * 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3
 * has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 * <p>
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee
 * and all his subordinates.
 * <p>
 * Example 1:
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3.
 * So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 * Note:
 * One employee has at most one direct leader and may have several subordinates.
 * The maximum number of employees won't exceed 2000.
 *
 * @author liuzhongda
 */
public class Leetcode690 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int getImportance(List<Employee> employees, int id) {
        //递归即可
        int importance = 0;
        List<Integer> subordinates = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.id == id) {
                importance += employee.importance;
                subordinates = employee.subordinates;
                for (Integer value : subordinates) {
                    importance += getImportance(employees, value);
                }
            }
        }
        return importance;
    }

}
