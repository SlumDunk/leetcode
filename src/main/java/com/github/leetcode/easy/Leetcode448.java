package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 *
 * @author liuzhongda
 */
public class Leetcode448 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return resultList;
        } else {
            int len = nums.length;
            //利用元素的取值范围在1-n，数组位置索引，和元素符号属性
            for (int i = 0; i < len; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] > 0) {
                    nums[index] = -nums[index];//将该位置的元素取负
                }
            }
            for (int i = 0; i < len; i++) {
                if (nums[i] > 0) {
                    resultList.add(i + 1);//将元素非0的位置添加到集合
                }
            }
            return resultList;
        }
    }

}
