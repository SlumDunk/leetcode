package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/29/19 10:03
 * @Description: Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: 12
 * Output: 21
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: 21
 * Output: -1
 */
public class Leetcode556 {
    public static void main(String[] args) {
        Leetcode556 leetcode556 = new Leetcode556();
        System.out.println(leetcode556.nextGreaterElement(12));
    }

    public int nextGreaterElement(int n) {
        List<Integer> numList = new ArrayList<>();
        while (n != 0) {
            numList.add(0, n % 10);
            n /= 10;
        }
        int pivot = -1;
        //从后往前找，找到第一个前一个位置的数小于后一个位置的数出现的位置
        for (int i = numList.size() - 1; i >= 0; i--) {
            if (i == 0)
                return -1;
            if (numList.get(i) > numList.get(i - 1)) {
                pivot = i;
                //从后往前扫，找到第一个比pivot位置的数大的
                for (int j = numList.size() - 1; j >= i; j--) {
                    if (numList.get(j) > numList.get(i - 1)) {
                        int temp = numList.get(i - 1);
                        numList.set(i - 1, numList.get(j));
                        numList.set(j, temp);
                        break;
                    }
                }
                break;
            }
        }
        long num = 0;
        for (int i = 0; i <= pivot - 1; i++) {
            num = num * 10 + numList.get(i);
        }
        //翻转从Pivot位置到list尾部的元素
        for (int i = numList.size() - 1; i >= pivot; i--) {
            num = num * 10 + numList.get(i);
        }
        return num > Integer.MAX_VALUE - 1 ? -1 : (int) num;
    }
}
