package com.github.interview.wepay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/20/19 15:43
 * @Description:
 */
public class Wepay1 {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("MMM/dd/YYYY");
        final Calendar calendar = Calendar.getInstance();
        int year = 1943;
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        List list=new ArrayList();
        list.add("hello");
        list.add(2);
        System.out.println(Calendar.DAY_OF_WEEK);
        int day = (Calendar.TUESDAY - calendar.get(Calendar.DAY_OF_WEEK));

        if (day < 0) {
            calendar.add(Calendar.DATE, 14 - day);
        } else {
            calendar.add(Calendar.DATE, 7 + day);
        }

        System.out.println("Second date is " + sdf.format(calendar.getTime()));

    }
}
