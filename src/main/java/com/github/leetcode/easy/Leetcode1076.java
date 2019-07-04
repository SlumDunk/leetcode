package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 21:56
 * @Description:
 */
public class Leetcode1076 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\tqq.project_id \n" +
                "FROM\n" +
                "\t( SELECT project_id, count( employee_id ) AS cnt FROM project GROUP BY project_id ) qq \n" +
                "WHERE\n" +
                "\tcnt = ( SELECT count( employee_id ) FROM project GROUP BY project_id ORDER BY count( employee_id ) DESC LIMIT 1 );");
    }
}
