package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * At a lemonade stand, each lemonade costs $5.
 * <p>
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 * <p>
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 * <p>
 * Note that you don't have any change in hand at first.
 * <p>
 * Return true if and only if you can provide every customer with correct change.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,5,5,10,20]
 * Output: true
 * Explanation:
 * From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change, we output true.
 */
public class Leetcode860 {
    public static void main(String[] args) {

    }

    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTen = 0;
        if (bills.length < 0 || bills.length > 10000) {
            return false;
        } else if (bills[0] != 5) {
            return false;
        } else {
            countFive++;
            for (int i = 1; i < bills.length; i++) {
                switch (bills[i]) {
                    case 5:
                        countFive++;
                        break;
                    case 10:
                        countFive--;
                        countTen++;
                        break;
                    case 20:
                        if (countTen > 0) {
                            countTen--;
                            countFive--;
                        } else {
                            countFive -= 3;
                        }
                        break;
                    default:
                        break;
                }
                if (countFive < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
