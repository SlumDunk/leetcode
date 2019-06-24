package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 11:15
 * @Description: We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
 * <p>
 * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.(Note that the rotated number can be greater than the original number.)
 * <p>
 * Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 20
 * Output: 6
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19].
 * 6 converts to 9.
 * 9 converts to 6.
 * 10 converts to 01 which is just 1.
 * 16 converts to 91.
 * 18 converts to 81.
 * 19 converts to 61.
 * Example 2:
 * <p>
 * Input: 100
 * Output: 19
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 */
public class Leetcode1088 {
    Map<Integer, Integer> map = new HashMap<>();
    /**
     * confusing digits 数组
     */
    int[] num = {0, 1, 6, 8, 9};

    public int confusingNumberII(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int count[] = new int[1];
        dfs(0, N, num, count);
        return count[0];
    }

    /**
     * @param start 左边界值
     * @param N     右边界值
     * @param num   cofusing digit数组
     * @param count 结果计数对象
     */
    private void dfs(long start, int N, int[] num, int[] count) {
        if (start > N) {
            return;
        }
        if (start <= N && isConfused(start, map)) {
            count[0]++;
        }
        //排除首位为0的情况
        int i = start == 0 ? 1 : 0;
        for (; i < 5; i++) {//下一位的取值，只能从confusing digits中取
            dfs(start * 10 + num[i], N, num, count);
        }
    }

    /**
     * 判断是否是confusing number
     *
     * @param s   要判断的数字
     * @param map confusing number map 集合
     * @return
     */
    private boolean isConfused(long s, Map<Integer, Integer> map) {
        long res = 0, x = s;
        while (x > 0) {
            //获取最低位数字
            int i = (int) (x % 10);
            if (i == 2 || i == 3 || i == 4 || i == 5 || i == 7) {
                return false;
            }
            long digit = map.get(i);
            //构造新数字
            res = res * 10 + digit;
            //继续取高位
            x = x / 10;
        }
        //判断数字是否相同
        return res != s;
    }
}
