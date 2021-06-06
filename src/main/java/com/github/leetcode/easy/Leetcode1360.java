package com.github.leetcode.easy;

import java.time.LocalDate;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 17:27
 * @Description: Write a program to count the number of days between two dates.
 * <p>
 * The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: date1 = "2019-06-29", date2 = "2019-06-30"
 * Output: 1
 * Example 2:
 * <p>
 * Input: date1 = "2020-01-15", date2 = "2019-12-31"
 * Output: 15
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The given dates are valid dates between the years 1971 and 2100.
 */
public class Leetcode1360 {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate localDate1 = LocalDate.parse(date1);
        LocalDate localDate2 = LocalDate.parse(date2);
        long numberOfDays = localDate1.toEpochDay();
        long numberOfDays2 = localDate2.toEpochDay();
        return (int) (Math.max(numberOfDays, numberOfDays2) - Math.min(numberOfDays, numberOfDays2));
    }
}
