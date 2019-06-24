package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 21:26
 * @Description: We are given non-negative integers nums[i] which are written on a chalkboard.  Alice and Bob take turns erasing exactly one number from the chalkboard, with Alice starting first.  If erasing a number causes the bitwise XOR of all the elements of the chalkboard to become 0, then that player loses.  (Also, we'll say the bitwise XOR of one element is that element itself, and the bitwise XOR of no elements is 0.)
 * <p>
 * Also, if any player starts their turn with the bitwise XOR of all the elements of the chalkboard equal to 0, then that player wins.
 * <p>
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 * <p>
 * Example:
 * Input: nums = [1, 1, 2, 3]
 * Output: false
 * Explanation:
 * Alice has two choices: erase 1 or erase 2.
 * If she erases 1, the nums array becomes [1, 2]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 2 = 3. Now Bob can remove any element he wants, because Alice will be the one to erase the last element and she will lose.
 * If Alice erases 2 first, now nums becomes [1, 1]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 1 = 0. Alice will lose.
 * <p>
 * Notes:
 * <p>
 * 1 <= N <= 1000.
 * 0 <= nums[i] <= 2^16.
 */
public class Leetcode810 {
    public boolean xorGame(int[] nums) {
        int xor = 0;//直接赢了
        for (int i : nums) xor ^= i;
        //如果xor!=0 长度为偶数，那么Alice每次可以擦除不等于当前xor的数
        return xor == 0 || nums.length % 2 == 0;
    }
}
