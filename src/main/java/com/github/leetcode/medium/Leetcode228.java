package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 15:23
 * @Description: Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * <p>
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 * <p>
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class Leetcode228 {
    public List<String> summaryRanges(int[] nums) {
//        List<String> resultList = new ArrayList<>();
//        int pos = 0;
//        while (pos < nums.length) {
//            StringBuilder it = new StringBuilder("" + nums[pos]);
//            int temp = pos;
//            while (pos + 1 < nums.length && nums[pos + 1] == nums[pos] + 1)
//                pos++;
//
//            if (pos != temp)
//                it.append("->").append(nums[pos]);
//            resultList.add(it.toString());
//            pos++;
//        }
//        return resultList;
        List<String> resultList = new ArrayList<>();
        int pos = 0;
        StringBuilder buffer = new StringBuilder();
        while (pos < nums.length) {
            buffer.append("" + nums[pos]);
            int temp = nums[pos];
            while (pos + 1 < nums.length && nums[pos + 1] == nums[pos] + 1) {//连续范围，指针往前移
                pos++;
            }
            if (nums[pos] != temp) {
                buffer.append("->" + nums[pos]);
            }
            resultList.add(buffer.toString());
            pos++;
            buffer.delete(0,buffer.length());
        }
        return resultList;
    }
}
