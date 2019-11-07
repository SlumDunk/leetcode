package com.github.lintcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 10:37
 * @Description: Given a sorted array of n integers, find the starting and ending position of a given target value.
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * <p>
 * Challenge
 * O(log n) time.
 */
public class Lintcode61 {
    /**
     * @param A:      an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = A.length - 1;

        int[] bound = new int[2];
        //先找第一次出现的位置
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (A[mid] == target) {
                right = mid;
            } else if (A[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (A[left] == target) {
            bound[0] = left;
        } else if (A[right] == target) {
            bound[0] = right;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        //找最后一次出现的位置
        left = 0;
        right = A.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (A[mid] == target) {
                left = mid;
            } else if (A[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (A[right] == target) {
            bound[1] = right;
        } else if (A[left] == target) {
            bound[1] = left;
        } else {
            bound[0] = bound[1] = -1;
        }
        return bound;
    }


    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange__(int[] A, int target) {
        // write your code here
        int n=A.length;

        int start=0,end=n-1;
        int mid=0;
        int[] ans=new int[2];
        Arrays.fill(ans,-1);
        if(n==0){
            return ans;
        }

        //寻找第一次出现的位置
        while(start+1<end){
            mid=start+(end-start)/2;
            if(A[mid]==target){
                end=mid;
            }else if(A[mid]>target){
                end=mid;
            }else{
                start=mid;
            }
        }

        if(A[start]==target){
            ans[0]=start;
        }else if(A[end]==target){
            ans[0]=end;
        }

        start=0;
        end=n-1;
        //寻找最后一次出现的位置
        while(start+1<end){
            mid=start+(end-start)/2;
            if(A[mid]==target){
                start=mid;
            }else if(A[mid]>target){
                end=mid;
            }else{
                start=mid;
            }
        }

        if(A[end]==target){
            ans[1]=end;
        }else if(A[start]==target){
            ans[1]=start;
        }

        return ans;
    }
}
