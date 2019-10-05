package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 13:30
 * @Description:
 */
public class Leetcode1149 {
    public static void main(String[] args) {
        System.out.println("SELECT DISTINCT\n" +
                "\tv1.viewer_id AS id \n" +
                "FROM\n" +
                "\tViews v1,\n" +
                "\tViews v2 \n" +
                "WHERE\n" +
                "\tv1.viewer_id = v2.viewer_id \n" +
                "\tAND v1.view_date = v2.view_date \n" +
                "\tAND v1.article_id != v2.article_id \n" +
                "ORDER BY\n" +
                "\tid ASC;");
    }
}
