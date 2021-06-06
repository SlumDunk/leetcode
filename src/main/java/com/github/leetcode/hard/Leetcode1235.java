package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 *
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 * Example 2:
 *
 *
 *
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job.
 * Profit obtained 150 = 20 + 70 + 60.
 * Example 3:
 *
 *
 *
 * Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= startTime.length == endTime.length == profit.length <= 5 * 104
 * 1 <= startTime[i] < endTime[i] <= 109
 * 1 <= profit[i] <= 104
 */
public class Leetcode1235 {
    class Job {
        int start;
        int end;
        int profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++)
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));

        Collections.sort(jobs, (a, b) -> Integer.compare(a.start,b.start));
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return maxProfit(jobs, memo, 0);
    }

    private int maxProfit(List<Job> jobs, int[] memo, int index) {
        int n = jobs.size();
        if (index == n || index == -1)
            return 0;
        if (memo[index] != -1)
            return memo[index];

        int maxProfit = 0;
        // 取和不取 两种情况
        int workProfit = jobs.get(index).profit + maxProfit(jobs, memo, findNextJob(jobs, jobs.get(index).end, index + 1));
        int skipProfit = maxProfit(jobs, memo, index + 1);
        maxProfit = Math.max(workProfit, skipProfit);
        memo[index] = maxProfit;
        return maxProfit;
    }

    /**
     * Binary Search
     * @param jobs
     * @param target
     * @param prevIndex
     * @return
     */
    private int findNextJob(List<Job> jobs, int target, int prevIndex) {
        int low = prevIndex;
        int high = jobs.size() - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs.get(mid).start < target) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }
}
