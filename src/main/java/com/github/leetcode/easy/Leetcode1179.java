package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 21:27
 * @Description:
 */
public class Leetcode1179 {
    public static void main(String[] args) {
        System.out.println("select t2.id,\n" +
                "max(Jan_Revenue) as Jan_Revenue,\n" +
                "max(Feb_Revenue) as Feb_Revenue,\n" +
                "max(Mar_Revenue) as Mar_Revenue,\n" +
                "max(Apr_Revenue) as Apr_Revenue,\n" +
                "max(May_Revenue) as May_Revenue,\n" +
                "max(Jun_Revenue) as Jun_Revenue,\n" +
                "max(Jul_Revenue) as Jul_Revenue,\n" +
                "max(Aug_Revenue) as Aug_Revenue,\n" +
                "max(Sep_Revenue) as Sep_Revenue,\n" +
                "max(Oct_Revenue) as Oct_Revenue,\n" +
                "max(Nov_Revenue) as Nov_Revenue,\n" +
                "max(Dec_Revenue) as Dec_Revenue\n" +
                "from\n" +
                "(select d.id,\n" +
                "(case when d.month = 'Jan' then d.revenue end) as Jan_Revenue,\n" +
                "(case when d.month = 'Feb' then d.revenue end) as Feb_Revenue,\n" +
                "(case when d.month = 'Mar' then d.revenue end) as Mar_Revenue,\n" +
                "(case when d.month = 'Apr' then d.revenue end) as Apr_Revenue,\n" +
                "(case when d.month = 'May' then d.revenue end) as May_Revenue,\n" +
                "(case when d.month = 'Jun' then d.revenue end) as Jun_Revenue,\n" +
                "(case when d.month = 'Jul' then d.revenue end) as Jul_Revenue,\n" +
                "(case when d.month = 'Aug' then d.revenue end) as Aug_Revenue,\n" +
                "(case when d.month = 'Sep' then d.revenue end) as Sep_Revenue,\n" +
                "(case when d.month = 'Oct' then d.revenue end) as Oct_Revenue,\n" +
                "(case when d.month = 'Nov' then d.revenue end) as Nov_Revenue,\n" +
                "(case when d.month = 'Dec' then d.revenue end) as Dec_Revenue\n" +
                "from Department as d ) t2\n" +
                "group by t2.id");
    }
}
