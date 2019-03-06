package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 14:33
 * @Description: A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 * <p>
 * Example:
 * <p>
 * Input: low = "50", high = "100"
 * Output: 3
 * Explanation: 69, 88, and 96 are three strobogrammatic numbers.
 */
public class Leetcode248 {
    public int strobogrammaticInRange(String low, String high) {
        int res = 0;
        List<String> list = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); i++) {
            list.addAll(helper(i, i));
        }

        for (String num :
                list) {
            if ((num.length() == low.length() && num.compareTo(low) < 0) || (num.length() == high.length() && num.compareTo(high) > 0)) {
                continue;
            }

            res++;
        }

        return res;
    }

    private List<String> helper(int cur, int max) {
        if (cur == 0) return new ArrayList<>(Arrays.asList(""));
        if (cur == 1) return new ArrayList<>(Arrays.asList("1", "8", "0"));

        List<String> res = new ArrayList<>();
        List<String> centerList = helper(cur - 2, max);

        for (int i = 0; i < centerList.size(); i++) {
            String center = centerList.get(i);
            if (cur != max) {
                res.add("0" + center + "0");
            }

            res.add("1" + center + "1");
            res.add("8" + center + "8");
            res.add("9" + center + "6");
            res.add("6" + center + "9");
        }
        return res;
    }
}
