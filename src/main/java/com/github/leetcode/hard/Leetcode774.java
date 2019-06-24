package com.github.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 6/4/19 17:11
 * @Description: On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.
 * <p>
 * Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.
 * <p>
 * Return the smallest possible value of D.
 * <p>
 * Example:
 * <p>
 * Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
 * Output: 0.500000
 * Note:
 * <p>
 * stations.length will be an integer in range [10, 2000].
 * stations[i] will be an integer in range [0, 10^8].
 * K will be an integer in range [1, 10^6].
 * Answers within 10^-6 of the true value will be accepted as correct.
 */
public class Leetcode774 {
    public static void main(String[] args) {
        Leetcode774 leetcode774 = new Leetcode774();
        int[] stations = new int[]{1, 5, 3, 4, 2, 6, 7, 8, 9, 10};
        int k = 9;

        leetcode774.minmaxGasDist(stations, k);
    }

    /**
     * I initilze left = 0 and right = the distance between the first and the last station
     * count is the number of gas station we need to make it possible.
     * if count > K, mid太小，需要更多的stations
     * if count <= K, mid可以，但可能存在更大的distance
     * When left + 1e-6 >= right, it means the answer within 10^-6 of the true value and it will be accepted.
     *
     * @param stations
     * @param K
     * @return
     */
    public double minmaxGasDist(int[] stations, int K) {
        int count, N = stations.length;
        int[] copy = Arrays.copyOf(stations, stations.length);
        Arrays.sort(copy);

        double left = 0, right = copy[N - 1] - copy[0], mid;

        while (left + 1e-6 < right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < N - 1; ++i)
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            if (count > K) left = mid;
            else right = mid;
        }
        return right;
    }
}
