package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 16:23
 * @Description: Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Leetcode238 {
    public static void main(String[] args) {
        Leetcode238 leetcode238 = new Leetcode238();
        int[] nums = {0, 1, 2, 3, 4};
        leetcode238.productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[len - 1] = 1;//最右边没元素，初始化为1
        //先利用res存储各个位置右边的元素累积
        for (int i = len - 2; i >= 0; i--) {
            res[i] = res[i + 1] * nums[i + 1];
        }
        //从左到右，用变量left存储左边元素的累积
        int left = 1;//最左边初始化为1
        for (int i = 0; i < len; i++) {
            res[i] = res[i] * left;
            left *= nums[i];//左边元素累积
        }
        return res;
    }


    public int[] productExceptSelf__(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] result = new int[len];

        //1     2   3     4
        //24    12  4     1
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        // 1 2 3 4
        // 1 1 2 3
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }


        return result;
    }

    /**
     * O(n)
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf___(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[len - 1] = 1;

        for (int i = len - 2; i >= 0; i--) {
            res[i] = res[i + 1] * nums[i + 1];
        }

        int left = 1;
        for (int i = 0; i < len; i++) {
            res[i] = left * res[i];
            left = left * nums[i];
        }

        return res;
    }

}
