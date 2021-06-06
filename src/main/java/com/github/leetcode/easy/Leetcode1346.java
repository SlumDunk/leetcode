package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 17:40
 * @Description: Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 * <p>
 * More formally check if there exists two indices i and j such that :
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 * Example 2:
 * <p>
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 * Example 3:
 * <p>
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: In this case does not exist N and M, such that N = 2 * M.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
public class Leetcode1346 {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length; //array length
        /*Map to store the elements of the array. We can also
        use a list for this purpose, but HashMap helps when we
        have to check for the number of zeroes in the array as
        explained below. */
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        /* Iterate over the array elements and store them in the HashMap*/
        for (int i = 0; i < n; i++) {
            int count = map.containsKey(arr[i]) ? map.get(arr[i]) : 0; //count = 0 if no occurence before, map.get(arr[i]) otherwise
            map.put(arr[i], count + 1); //increment and store the count
            /* Check if the current arr[i] is double or half of any of the
            exisiting values in the Map.*/
            if (map.containsKey(2 * arr[i]) || (arr[i] % 2 == 0 && map.containsKey(arr[i] / 2))) {
                /*Twice or half of zero is always zero.
                Ignore the cases in which arr[i] == 0  and number
                of zeroes in the HashMap is 1 (i.e., count == 1)*/
                if (arr[i] == 0 && map.get(0) == 1) {
                    continue;
                }
                return true;
            }
        }
        return false; //return false if the condition above is not satisfied
    }
}
