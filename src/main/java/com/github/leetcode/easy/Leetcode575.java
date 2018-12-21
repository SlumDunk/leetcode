package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
 * Example 1:
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 * The sister has three different kinds of candies.
 * Example 2:
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 * The sister has two different kinds of candies, the brother has only one kind of candies.
 * Note:
 * <p>
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 *
 * @author liuzhongda
 */
public class Leetcode575 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static int distributeCandies(int[] candies) {
        //计算蜡烛的总数和种类数量
        Set<Integer> candySet = new HashSet<Integer>();
        for (int i = 0; i < candies.length; i++) {
            candySet.add(candies[i]);
        }
        if (candies.length >= 2 * candySet.size()) {//尽量将不同种类的蜡烛分给姐姐
            return candySet.size();
        } else {
            return candies.length / 2;
        }
    }

}
