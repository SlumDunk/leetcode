package com.github.leetcode.vo;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: zerongliu
 * @Date: 11/22/18 12:01
 * @Description:
 */
public class Solution {

    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        ArrayList<Integer> list = new ArrayList();
        //将等于目标值的位置索引放入list，然后随机返回结果即可
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target)
                list.add(i);
        if (list.size() == 0)
            return -1;
        else {
            int random = (int) (Math.random() * list.size());
            return list.get(random);
        }
    }

}
