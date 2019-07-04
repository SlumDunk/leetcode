package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 23:08
 * @Description: We distribute some number of candies, to a row of n = num_people people in the following way:
 * <p>
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
 * <p>
 * Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
 * <p>
 * This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
 * <p>
 * Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candies = 7, num_people = 4
 * Output: [1,2,3,1]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3,0].
 * On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
 * Example 2:
 * <p>
 * Input: candies = 10, num_people = 3
 * Output: [5,2,3]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3].
 * On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 */
public class Leetcode1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        //下一个要分配的蜡烛数
        int idx = 0, num = 1;

        while (candies > 0) {
            result[idx] += (candies > num) ? num : candies;
            idx = (idx < num_people - 1) ? idx + 1 : 0;
            candies -= num;
            num++;
        }

        return result;
    }
}
