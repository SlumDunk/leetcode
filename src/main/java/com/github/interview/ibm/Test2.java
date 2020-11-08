package com.github.interview.ibm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 10/18/20 17:09
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        int k = 2;
        System.out.println(evenSubarray(numbers, k));
    }

    public static int evenSubarray(List<Integer> numbers, int k) {
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, numbers.get(i) % 2 == 0 ? 0 : 1);
        }
        int ans = 0;


        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        for (int m = 0; m <= k; m++) {
            sum = 0;
            int res = 0;
            for (int i = 0; i < numbers.size(); i++) {
                sum += numbers.get(i);
                if (map.containsKey(sum - m)) {
                    res += map.get(sum - m);
                }
            }
            ans += res;
        }
        return ans;

    }
}
