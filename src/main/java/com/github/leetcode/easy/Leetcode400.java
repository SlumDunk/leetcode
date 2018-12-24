package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 8/28/18 18:49
 * @Description:
 */
public class Leetcode400 {
    public static void main(String[] args) {
        Leetcode400 leetcode400 = new Leetcode400();
        System.out.println(leetcode400.findNthDigit(192));
    }

    public int findNthDigit(int n) {
        //位数,开始位置，基数
        long digit = 1, ith = 1, base = 9;
        //找到该数字属于哪一开始段，1-9 9位,10-99 180位,100-999 2700位
        while (n > base * digit) {
            n -= (digit * base);
            digit++;
            ith += base;
            base *= 10;
        }

        //找到从哪个数字开始，通过(n-1)/digit定位第n-1位开始于哪个数字,通过(n-1)%digit定位取该数字哪个位
        long number = ith + (n - 1) / digit;
        int index = (n - 1) % (int) digit;
        return String.valueOf(number).charAt(index) - '0';
    }
}
