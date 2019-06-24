package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 14:00
 * @Description: Let's say a positive integer is a superpalindrome if it is a palindrome, and it is also the square of a palindrome.
 * <p>
 * Now, given two positive integers L and R (represented as strings), return the number of superpalindromes in the inclusive range [L, R].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: L = "4", R = "1000"
 * Output: 4
 * Explanation: 4, 9, 121, and 484 are superpalindromes.
 * Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= len(L) <= 18
 * 1 <= len(R) <= 18
 * L and R are strings representing integers in the range [1, 10^18).
 * int(L) <= int(R)
 */
public class Leetcode906 {
    public int superpalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        int count = 0;
        //最小的回文数的开方
        long sqrt = (long) Math.sqrt(l);
        long firstPalindrome;
        if (isPalindrome(sqrt)) {
            firstPalindrome = sqrt;
        } else {
            long mirror = mirror(sqrt);
            if (mirror > sqrt) {
                firstPalindrome = mirror;
            } else {
                firstPalindrome = nextPalindrome(sqrt);
            }
        }
        for (long i = firstPalindrome; i * i <= r; i = nextPalindrome(i)) {
            if (i * i <= r && isPalindrome(i * i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断是否是回文数
     *
     * @param n
     * @return
     */
    public boolean isPalindrome(long n) {
        String s = Long.toString(n);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 求出下一个回文数
     *
     * @param number
     * @return
     */
    public long nextPalindrome(long number) {
        String n = Long.toString(number);
        int order = (int) Math.pow(10, n.length() / 2);
        //求出前半部分
        Long half = number / order;
        Long upper = mirror((half) * order + order);
        return upper;
    }

    /**
     * 数字低位翻转到高位，构造回文数 109-->101
     *
     * @param num
     * @return
     */
    public Long mirror(Long num) {
        char[] numArray = Long.toString(num).toCharArray();
        int i = 0;
        int j = numArray.length - 1;
        while (i < j) {
            numArray[j] = numArray[i];
            i++;
            j--;
        }
        return Long.parseLong(new String(numArray));
    }


}
