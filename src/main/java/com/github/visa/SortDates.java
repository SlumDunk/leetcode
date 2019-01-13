package com.github.visa;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/12/19 18:01
 * @Description:
 */
public class SortDates {
    /**
     * month map
     */
    static Map<String, Integer> monthMap = new HashMap<String, Integer>();

    static {
        monthMap.put("Jan", 1);
        monthMap.put("Feb", 2);
        monthMap.put("Mar", 3);
        monthMap.put("Apr", 4);
        monthMap.put("May", 5);
        monthMap.put("Jun", 6);
        monthMap.put("July", 7);
        monthMap.put("Aug", 8);
        monthMap.put("Sep", 9);
        monthMap.put("Oct", 10);
        monthMap.put("Nov", 11);
        monthMap.put("Dec", 12);
    }

    /**
     *
     */
    static class DatesComparator implements Comparator<String> {

        @Override
        public int compare(String date1, String date2) {
            String[] arrayDate1 = date1.split(" ");
            String[] arrayDate2 = date2.split(" ");
            if (arrayDate1[2].compareTo(arrayDate2[2]) == 0) {
                if (monthMap.get(arrayDate1[1]).compareTo(monthMap.get(arrayDate2[1])) == 0) {
                    return arrayDate1[0].compareTo(arrayDate2[0]);
                } else {
                    return monthMap.get(arrayDate1[1]).compareTo(monthMap.get(arrayDate2[1]));
                }
            } else {
                return arrayDate1[2].compareTo(arrayDate2[2]);
            }
        }
    }

    public static List<String> sortDates(List<String> dates) {
        if (dates == null) {
            return dates;
        }
        Collections.sort(dates, new DatesComparator());
        return dates;
    }
}
