package com.github.lintcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 20:54
 * @Description:
 */
public class Lintcode58 {
    public static void main(String[] args) {
        Lintcode58 lintcode58 = new Lintcode58();
        int[] numbers = {-8, -0, -7, -101, -123, -1, -2, 1, 1, 4, -2, 0, -1, 0, -1111, 0, -1, -2, -3, -4, -5, -6, -100, -98, -111, -11};
        int target = -111;
        lintcode58.fourSum(numbers, target);
    }

    class ListComparator<T extends Comparable<T>> implements Comparator<List<Integer>> {
        public int compare(List<Integer> a, List<Integer> b) {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int c = a.get(i).compareTo(b.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(a.size(), b.size());
        }
    }

    /**
     * @param numbers: Give an array
     * @param target:  An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return result;
        } else {
            Arrays.sort(numbers);
            List<Integer> temp = new ArrayList<>();
            helper(numbers, 0, temp, result, target);
            Collections.sort(result, new ListComparator<>());
            return result;
        }
    }

    public void helper(int[] numbers, int startIndex, List<Integer> temp, List<List<Integer>> result, int target) {
        if (startIndex > numbers.length || temp.size() > 4) {
            return;
        }
        if (temp.size() == 4 && target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        if (temp.size() == 4) {
            return;
        }

        for (int i = startIndex; i < numbers.length; i++) {
            if (numbers[i] > target && numbers[i] > 0) {
                break;
            }
            if (i > startIndex && numbers[i] == numbers[i - 1]) {
                continue;
            }
            temp.add(numbers[i]);
            helper(numbers, i + 1, temp, result, target - numbers[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
