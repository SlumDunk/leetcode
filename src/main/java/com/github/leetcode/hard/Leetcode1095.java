package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 16:02
 * @Description: (This problem is an interactive problem.)
 * <p>
 * You may recall that an array A is a mountain array if and only if:
 * <p>
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  If such an index doesn't exist, return -1.
 * <p>
 * You can't access the mountain array directly.  You may only access the array using a MountainArray interface:
 * <p>
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: array = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 * Example 2:
 * <p>
 * Input: array = [0,1,2,4,2,1], target = 3
 * Output: -1
 * Explanation: 3 does not exist in the array, so we return -1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 */
public class Leetcode1095 {
    interface MountainArray {
        public int get(int index);

        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length(), l, r, m, peak = 0;
        //先找出峰值
        l = 0;
        r = n - 1;
        while (l < r) {
            m = (l + r) / 2;
            if (mountainArr.get(m) < mountainArr.get(m + 1))
                l = peak = m + 1;
            else
                r = m;
        }
        // 从左边二分查找目标对象
        l = 0;
        r = peak;
        while (l <= r) {
            m = (l + r) / 2;
            if (mountainArr.get(m) < target)
                l = m + 1;
            else if (mountainArr.get(m) > target)
                r = m - 1;
            else
                return m;
        }

        // 从右边进行二分查找目标对象
        l = peak;
        r = n - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (mountainArr.get(m) > target)
                l = m + 1;
            else if (mountainArr.get(m) < target)
                r = m - 1;
            else
                return m;
        }
        return -1;
    }
}
