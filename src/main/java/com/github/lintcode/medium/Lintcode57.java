package com.github.lintcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 20:28
 * @Description:
 */
public class Lintcode57 {
    List<List<Integer>> results = new ArrayList<>();

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
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        if (numbers == null || numbers.length < 3) {
            return results;
        }
        Arrays.sort(numbers);
        int len = numbers.length;
        int i;
        for (i = 2; i < len; i++) {
            if (i + 1 < len && numbers[i + 1] == numbers[i]) {
                continue;
            }

            twoSum(numbers, i - 1, -numbers[i]);
        }

        Collections.sort(results, new ListComparator<>());
        return results;
    }

    private void twoSum(int[] A, int right, int target) {
        int left = 0;
        int i, j;
        j = right;
        for (i = 0; i <= right; i++) {
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }

            while (j > i && A[j] + A[i] > target) {
                j--;
            }
            if (i >= j) {
                break;
            }
            if (A[i] + A[j] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(A[i]);
                list.add(A[j]);
                list.add(-target);
                results.add(list);
            }
        }
    }
}
