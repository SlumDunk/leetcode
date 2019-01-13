package com.github.visa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/12/19 18:24
 * @Description:
 */
public class FindSchedules {

    public static void main(String[] args) {
        findSchedules(56, 8, "??8????");
    }

    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        // Write your code here
        int[] digits = new int[7];
        //total number of '?'
        int count = 0;
        int workSum = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '?') {
                digits[i] = -1;
                count++;
            } else {
                digits[i] = pattern.charAt(i) - '0';
                workSum += digits[i];
            }
        }
        //the work hours that need to be filled
        int gap = workHours - workSum;
        //result list
        List<String> ans = new ArrayList<>();
        //combination list
        List<List<Integer>> result = new ArrayList<>();
        //temp list
        List<Integer> temp = new ArrayList<>();
        //find all the combinations
        //find(gap, temp, 0, result, count, dayHours);
        helper(count, gap, dayHours, temp, result);

        //use the result list to fill the positons of '?'
        for (List<Integer> list : result) {
            StringBuilder buffer = new StringBuilder();
            int index = 0;
            for (int digit : digits) {
                if (digit == -1) {
                    buffer.append(list.get(index));
                    index++;
                } else {
                    buffer.append(digit);
                }
            }
            ans.add(buffer.toString());

        }
        Collections.sort(ans);
        return ans;
    }

    /**
     * @param sum     target sum
     * @param temp    temp list
     * @param count   the number of '?' that has been parsed
     * @param results result set
     * @param k       the total number of '?'
     */
    static private void find(int sum, List<Integer> temp, int count, List<List<Integer>> results, int k, int dayHours) {
        // if sum <0, return
        if (sum < 0)
            return;
        // all the '?' has been parsed
        if (count == k) {
            // all workhours have been filled
            if (sum == 0) {
                results.add(new ArrayList<Integer>(temp));
            }
            return;
        }

        for (int i = 0; i < dayHours + 1 && i <= sum; i++) {
            // add the element to the temp list
            temp.add(i);
            find(sum - i, temp, count + 1, results, k, dayHours);
            // back track and remove the element
            temp.remove(temp.size() - 1);
        }

    }

    /**
     * @param count    还有多少个未知值
     * @param gap      未知值总和
     * @param dayHours 工作时间上限
     * @param temp     暂存集合
     * @param result   结果集
     */
    private static void helper(int count, int gap, int dayHours, List<Integer> temp, List<List<Integer>> result) {
        if (gap < 0) {
            return;
        }
        if (count == 0) {
            if (gap == 0) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = 0; i <= dayHours && i <= gap; i++) {
            temp.add(i);
            helper(count - 1, gap - i, dayHours, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
