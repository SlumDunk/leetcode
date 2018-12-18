package com.github.leetcode.easy;

/**
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by
 * two bits (10 or 11).
 * <p>
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given
 * string will always end with a zero.
 * <p>
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * Note:
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 *
 * @author liuzhongda
 */
public class Leetcode717 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (; i < bits.length - 1; ) {
            if (bits[i] == 1) {//遇到1，和下一位合并
                i += 2;
            } else {//非1,单步前进
                i++;
            }
        }
        //判断是不是走到最后一位
        return i == bits.length - 1;
    }

}
