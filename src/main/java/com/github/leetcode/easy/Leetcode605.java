package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 8/31/18 22:46
 * @Description: Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */
public class Leetcode605 {
    public static void main(String[] args) {

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //注意边界问题
        int len = flowerbed.length;
        int count = 0;
        if (len == 1 && flowerbed[0] == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            if (i == 0 && flowerbed[i] == 0) {//左边界
                if (i + 1 < len && flowerbed[i + 1] == 0) {
                    count++;
                    flowerbed[i] = 2;
                }
            } else if (i == len - 1 && flowerbed[i] == 0) {//右边界
                if (i - 1 >= 0 && flowerbed[i - 1] == 0) {
                    count++;
                    flowerbed[i] = 2;
                }
            } else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {//一般情况
                count++;
                flowerbed[i] = 2;
            }
        }
        if (count >= n) {
            return true;
        } else {
            return false;
        }
    }

}
