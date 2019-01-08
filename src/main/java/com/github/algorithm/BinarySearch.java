package com.github.algorithm;

/**
 * @Author: zerongliu
 * @Date: 1/6/19 08:54
 * @Description:
 */
public class BinarySearch {
    /**
     * 递归写法
     *
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (high <= low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, high, target);
        } else {
            return mid;
        }
    }

    /**
     * 迭代写法 left<=right
     * right<target<left
     * right+1=left
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;//[left,right]
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {//[left,mid-1]
                right = mid - 1;
            } else {//[mid+1,right]
                left = mid + 1;
            }
            System.out.println("mid: " + nums[mid] + " left: " + nums[left] + " right: " + nums[right]);
        }
        System.out.println("第一种 left: " + left + " right " + right);
        return -1;
    }

    /**
     * 迭代写法<
     * target<left=right
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//[left,right)
        while (left < right) {//left=right不执行
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {//[left,mid)
                right = mid;
            } else {//[mid+1,right)
                left = mid + 1;
            }
            System.out.println("mid: " + nums[mid] + " left: " + nums[left] + " right: " + nums[right]);
        }
        System.out.println("第二种 left: " + left + " right " + right);
        return -1;
    }

    /**
     * 没找到的终止条件
     * 迭代写法 left+1<right
     * left<target<right
     * left+1=right
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;//[left,right]
        while (left + 1 < right) {//[1,2,3] left+1=right不执行
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {//[left,mid]
                right = mid;
            } else if (nums[mid] < target) {//[mid,right]
                left = mid;
            } else {
                //any position
                //return mid;
                //first position
                //right=mid;
                //last position
                left = mid;
            }
            System.out.println("mid: " + nums[mid] + " left: " + nums[left] + " right: " + nums[right]);
        }
        System.out.println("第三种 left: " + left + " right " + right);
        //防止2个元素挨着的时候上面while不执行
        //first position先看start, last position先看end
        if (target == nums[left]) {
            return left;
        } else if (target == nums[right]) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] nums = {1, 3, 5, 9, 10};
        int target = 6;
        binarySearch1(nums, target);
        binarySearch2(nums, target);
        binarySearch3(nums, target);
    }
}
