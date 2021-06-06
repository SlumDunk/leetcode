package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 13:20
 * @Description: Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.
 * <p>
 * For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * Output: [true,true,true,false,true]
 * Explanation:
 * Kid 1 has 2 candies and if he or she receives all extra candies (3) will have 5 candies --- the greatest number of candies among the kids.
 * Kid 2 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids.
 * Kid 3 has 5 candies and this is already the greatest number of candies among the kids.
 * Kid 4 has 1 candy and even if he or she receives all extra candies will only have 4 candies.
 * Kid 5 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids.
 * Example 2:
 * <p>
 * Input: candies = [4,2,1,1,2], extraCandies = 1
 * Output: [true,false,false,false,false]
 * Explanation: There is only 1 extra candy, therefore only kid 1 will have the greatest number of candies among the kids regardless of who takes the extra candy.
 * Example 3:
 * <p>
 * Input: candies = [12,1,12], extraCandies = 10
 * Output: [true,false,true]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= candies.length <= 100
 * 1 <= candies[i] <= 100
 * 1 <= extraCandies <= 50
 */
public class Leetcode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        Boolean[] ans = new Boolean[n];
        for (int i = 0; i < n; i++) {
            ans[i] = false;
        }
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (candies[i] > candies[maxIdx]) {
                maxIdx = i;
            }
        }
        ans[maxIdx] = true;

        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= candies[maxIdx]) {
                ans[i] = true;
            }
        }

        List<Boolean> resultList = new ArrayList<>();
        for (Boolean val :
                ans) {
            resultList.add(val);
        }

        return resultList;

    }
}
