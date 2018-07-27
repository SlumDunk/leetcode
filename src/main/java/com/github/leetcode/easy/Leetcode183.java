package com.github.leetcode.easy;

/**
 * Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.
 * <p>
 * Table: Customers.
 * <p>
 * +----+-------+
 * | Id | Name  |
 * +----+-------+
 * | 1  | Joe   |
 * | 2  | Henry |
 * | 3  | Sam   |
 * | 4  | Max   |
 * +----+-------+
 * Table: Orders.
 * <p>
 * +----+------------+
 * | Id | CustomerId |
 * +----+------------+
 * | 1  | 3          |
 * | 2  | 1          |
 * +----+------------+
 * Using the above tables as example, return the following:
 * <p>
 * +-----------+
 * | Customers |
 * +-----------+
 * | Henry     |
 * | Max       |
 * +-----------+
 */
public class Leetcode183 {
    public static void main(String[] args) {
        System.out.println("select c.Name as Customers from Customers c where not exists (select 1 from Orders o where o.CustomerId=c.Id);");
    }
}
