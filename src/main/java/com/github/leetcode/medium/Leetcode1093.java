package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 23:48
 * @Description: We sampled integers between 0 and 255, and stored the results in an array count:  count[k] is the number of integers we sampled equal to k.
 * <p>
 * Return the minimum, maximum, mean, median, and mode of the sample respectively, as an array of floating point numbers.  The mode is guaranteed to be unique.
 * <p>
 * (Recall that the median of a sample is:
 * <p>
 * The middle element, if the elements of the sample were sorted and the number of elements is odd;
 * The average of the middle two elements, if the elements of the sample were sorted and the number of elements is even.)
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * Output: [1.00000,3.00000,2.37500,2.50000,3.00000]
 * Example 2:
 * <p>
 * Input: count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * Output: [1.00000,4.00000,2.18182,2.00000,1.00000]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * count.length == 256
 * 1 <= sum(count) <= 10^9
 * The mode of the sample that count represents is unique.
 * Answers within 10^-5 of the true value will be accepted as correct.
 */
public class Leetcode1093 {
    public double[] sampleStats(int[] count) {
        int l = 0, r = 255, nl = 0, nr = 0, mn = 255, mx = -1, mid1 = 0, mid2 = 0, mode = 0;
        double avg = 0, mid = 0;
        while (l <= r) {
            while (count[l] == 0) l++;
            while (count[r] == 0) r--;
            if (nl < nr) {
                avg += count[l] * l;
                nl += count[l];
                if (count[l] > count[(int) mode]) mode = l;
                mn = Math.min(mn, l);
                mid1 = l;
                l++;
            } else {
                avg += count[r] * r;
                nr += count[r];
                if (count[r] > count[(int) mode]) mode = r;
                mx = Math.max(mx, r);
                mid2 = r;
                r--;
            }
        }
        avg /= (nl + nr);
        // Find median
        if (nl < nr) mid = mid2;
        else if (nl > nr) mid = mid1;
        else mid = (double) (mid1 + mid2) / 2;
        return new double[]{mn, mx, avg, mid, mode};
    }
}
