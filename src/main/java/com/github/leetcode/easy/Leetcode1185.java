package com.github.leetcode.easy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 23:00
 * @Description: Given a date, return the corresponding day of the week for that date.
 * <p>
 * The input is given as three integers representing the day, month and year respectively.
 * <p>
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 * Example 2:
 * <p>
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 * Example 3:
 * <p>
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The given dates are valid dates between the years 1971 and 2100.
 */
public class Leetcode1185 {
    public static void main(String[] args) {
        Leetcode1185 leetcode1185 = new Leetcode1185();
        leetcode1185.dayOfTheWeek(31, 8, 2019);
    }

    String[] weekMap = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        StringBuilder dateBuffer = new StringBuilder();
        dateBuffer.append(year);
        dateBuffer.append("-");
        dateBuffer.append(month >= 10 ? month : ("0" + month));
        dateBuffer.append("-");
        dateBuffer.append(day >= 10 ? day : ("0" + day));
        dateBuffer.append(" 00:00:00");
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        try {
            Date date = sdf.parse(dateBuffer.toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return weekMap[calendar.get(Calendar.DAY_OF_WEEK)-1];
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
