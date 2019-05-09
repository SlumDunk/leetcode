package com.github.interview.amazon;

/**
 * @Author: zerongliu
 * @Date: 4/11/19 10:41
 * @Description: You are taking a flight and you wanna watch two movies. You are given int[] dur which includes all the
 * movie durations. You are also given the duration of the flight which is d in minutes. Now, you need to
 * pick two movies and the total duration of the two movies is less than or equal to (d - 30min). Find the
 * pair of movies with the most total duration. If multiple found, return the pair with the longest movie.
 */
public class MoviesInFlight {
    /**
     * 对元素的顺序有要求
     *
     * @param dur
     * @param d
     * @return
     */
    public int[] matchMovie(int[] dur, int d) {
        int[] result = new int[2];
        if (dur == null || dur.length < 2 || d < 30) {
            return result;
        } else {
            int target = d - 30;
            int len = dur.length;
            int longest = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int totalDuration = dur[i] + dur[j];
                    if (totalDuration <= target && totalDuration > longest) {
                        result[0] = i;
                        result[1] = j;
                        longest = totalDuration;
                    }
                }
            }
            return result;
        }
    }
}
