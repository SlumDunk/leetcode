package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 22:33
 * @Description:
 */
public class Leetcode1098 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "b.book_id,b.name\n" +
                "from books b\n" +
                "left join orders o\n" +
                "on o.book_id=b.book_id\n" +
                "where datediff('2019-06-23',available_from)>30\n" +
                "group by 1,2\n" +
                "having sum(case when datediff('2019-06-23',dispatch_date)>365 then quantity=0 else quantity end)<10 or sum(quantity) is null");
    }
}
