package com.github.interview.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 09:37
 * @Description:
 */
public class FindPairWithGivenSum {
    public static List<Integer> findPair(List<Integer> nums, int target) {
        target -= 30;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = Arrays.asList(-1, -1);
        int largest = 0;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums.get(i);
            if ((nums.get(i) > largest || complement > largest) && map.containsKey(complement)) {
                result.set(0, map.get(complement));
                result.set(1, i);
                largest = Math.max(nums.get(i), complement);
            }
            map.put(nums.get(i), i);
        }
        return result;
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 10, 25, 35, 60), 90);
        test(Arrays.asList(20, 50, 40, 25, 30, 10), 90);
        test(Arrays.asList(5, 55, 40, 20, 30, 30), 90);
    }

    private static void test(List<Integer> nums, int target) {
        System.out.println(findPair(nums, target));
    }
}
