package com.github.leetcode.easy;

import java.util.HashMap;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 20:49
 * @Description: Given a date string in the form Day Month Year, where:
 * <p>
 * Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
 * Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
 * Year is in the range [1900, 2100].
 * Convert the date string to the format YYYY-MM-DD, where:
 * <p>
 * YYYY denotes the 4 digit year.
 * MM denotes the 2 digit month.
 * DD denotes the 2 digit day.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: date = "20th Oct 2052"
 * Output: "2052-10-20"
 * Example 2:
 * <p>
 * Input: date = "6th Jun 1933"
 * Output: "1933-06-06"
 * Example 3:
 * <p>
 * Input: date = "26th May 1960"
 * Output: "1960-05-26"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The given dates are guaranteed to be valid, so no error handling is necessary.
 */
public class Leetcode1507 {
    public String reformatDate(String date) {
        HashMap<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        String[] arr = date.split(" ");
        StringBuilder str = new StringBuilder();
        str.append(arr[2]);
        str.append("-");
        str.append(months.get(arr[1]));
        str.append("-");
        String day = arr[0].substring(0, arr[0].length() - 2);
        if (day.length() == 1) str.append("0");
        str.append(day);
        return str.toString();
    }
}
