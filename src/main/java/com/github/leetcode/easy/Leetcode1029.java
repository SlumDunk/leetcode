package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 12:00
 * @Description: There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * <p>
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 * <p>
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */
public class Leetcode1029 {
    public int twoCitySchedCost(int[][] costs) {
        // Handling edge cases.
        if(costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        // Initializing array with length of costs.
        int[] diff = new int[costs.length];
        int sum = 0;
        for(int i = 0; i <diff.length;i++){
            // Sending everyone to City A and record costs difference
            // if sending to City B instead of City A.
            sum+=costs[i][0];
            diff[i] = costs[i][1]- costs[i][0];
        }
        // Sorting array.
        Arrays.sort(diff);
        // Sending the first N people with lowest costs to B.
        for(int i = 0; i < diff.length/2;i++){
            sum+=diff[i];
        }
        return sum;
    }
}
