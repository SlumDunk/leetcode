package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 14:15
 * @Description: Follow up for Search in Rotated Sorted Array:
 * <p>
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * <p>
 * Write a function to determine if a given target is in the array.
 * <p>
 * Example
 * Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
 * Given [1, 1, 1, 1, 1, 1] and target = 0, return false.
 */
public class Lintcode63 {
    /**
     * @param A:      an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean
     */
    public boolean search(int[] A, int target) {
        // write your code here
        // 这个问题在面试中不会让实现完整程序
        // 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
        // 在这种情况下是无法使用二分法的，复杂度是O(n)
        // 因此写个for循环最坏也是O(n)，那就写个for循环就好了
        //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
        //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
        if (A == null || A.length == 0) {
            return false;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
