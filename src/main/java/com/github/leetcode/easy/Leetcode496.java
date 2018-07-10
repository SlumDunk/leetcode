package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
 * @author liuzhongda
 *
 */
public class Leetcode496 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1=new int[] {1,3,5,2,4};
		int[] nums2=new int[] {6,5,4,3,2,1,7};
		System.out.println(nextGreaterElement(nums1,nums2));
	}
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			if (i == nums2.length - 1) {
				numMap.put(nums2[i], -1);
			} else {
				for (int k = 1; k < nums2.length - i; k++) {
					if (nums2[i + k] > nums2[i]) {
						numMap.put(nums2[i], nums2[i + k]);
						break;
					}
				}
				if(numMap.get(nums2[i])==null) {
					numMap.put(nums2[i], -1);
				}

			}
		}
		int[] nums = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			nums[i] = numMap.get(nums1[i]);
		}
		return nums;
	}

}
