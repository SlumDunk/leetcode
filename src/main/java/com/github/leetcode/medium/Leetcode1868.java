package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Run-length encoding is a compression algorithm that allows for an integer array nums with many segments of consecutive repeated numbers to be represented by a (generally smaller) 2D array encoded. Each encoded[i] = [vali, freqi] describes the ith segment of repeated numbers in nums where vali is the value that is repeated freqi times.
 * <p>
 * For example, nums = [1,1,1,2,2,2,2,2] is represented by the run-length encoded array encoded = [[1,3],[2,5]]. Another way to read this is "three 1's followed by five 2's".
 * The product of two run-length encoded arrays encoded1 and encoded2 can be calculated using the following steps:
 * <p>
 * Expand both encoded1 and encoded2 into the full arrays nums1 and nums2 respectively.
 * Create a new array prodNums of length nums1.length and set prodNums[i] = nums1[i] * nums2[i].
 * Compress prodNums into a run-length encoded array and return it.
 * You are given two run-length encoded arrays encoded1 and encoded2 representing full arrays nums1 and nums2 respectively. Both nums1 and nums2 have the same length. Each encoded1[i] = [vali, freqi] describes the ith segment of nums1, and each encoded2[j] = [valj, freqj] describes the jth segment of nums2.
 * <p>
 * Return the product of encoded1 and encoded2.
 * <p>
 * Note: Compression should be done such that the run-length encoded array has the minimum possible length.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: encoded1 = [[1,3],[2,3]], encoded2 = [[6,3],[3,3]]
 * Output: [[6,6]]
 * Explanation: encoded1 expands to [1,1,1,2,2,2] and encoded2 expands to [6,6,6,3,3,3].
 * prodNums = [6,6,6,6,6,6], which is compressed into the run-length encoded array [[6,6]].
 * Example 2:
 * <p>
 * Input: encoded1 = [[1,3],[2,1],[3,2]], encoded2 = [[2,3],[3,3]]
 * Output: [[2,3],[6,1],[9,2]]
 * Explanation: encoded1 expands to [1,1,1,2,3,3] and encoded2 expands to [2,2,2,3,3,3].
 * prodNums = [2,2,2,6,9,9], which is compressed into the run-length encoded array [[2,3],[6,1],[9,2]].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= encoded1.length, encoded2.length <= 105
 * encoded1[i].length == 2
 * encoded2[j].length == 2
 * 1 <= vali, freqi <= 104 for each encoded1[i].
 * 1 <= valj, freqj <= 104 for each encoded2[j].
 * The full arrays that encoded1 and encoded2 represent are the same length.
 */
public class Leetcode1868 {
    /**
     * 1,2,1,2,1
     * 1,2,1,2,1
     * 1,4,1,4,1
     *
     * @param encoded1
     * @param encoded2
     * @return
     */
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<Integer> decodeList1 = new ArrayList<>();
        List<Integer> decodeList2 = new ArrayList<>();
        for (int[] arr :
                encoded1) {
            for (int i = 0; i < arr[1]; i++) {
                decodeList1.add(arr[0]);
            }
        }

        for (int[] arr :
                encoded2) {
            for (int i = 0; i < arr[1]; i++) {
                decodeList2.add(arr[0]);
            }
        }

        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < decodeList1.size(); i++) {
            tempList.add(decodeList1.get(i) * decodeList2.get(i));
        }

        int item = tempList.get(0);
        int count = 1;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < tempList.size(); i++) {
            if (item == tempList.get(i)) {
                count++;
            } else {
                ans.add(Arrays.asList(item, count));
                item = tempList.get(i);
                count = 1;
            }
        }
        ans.add(Arrays.asList(item, count));
        return ans;
    }

    public List<List<Integer>> findRLEArray2(int[][] encoded1, int[][] encoded2) {
        int i1 = 0, i2 = 0;
        int f1 = 0, f2 = 0;
        int p = 0;
        int len1 = encoded1.length, len2 = encoded2.length;
        List<int[]> lst = new ArrayList<>();
        while (i1 < len1 && i2 < len2) {
            f1 = encoded1[i1][1];
            f2 = encoded2[i2][1];
            p = encoded1[i1][0] * encoded2[i2][0];
            if (f1 == f2) {
                lst.add(new int[]{p, f1});
                i1++;
                i2++;
            } else if (f1 < f2) {
                lst.add(new int[]{p, f1});
                encoded2[i2][1] = f2 - f1;
                i1++;
            } else {
                lst.add(new int[]{p, f2});
                encoded1[i1][1] = f1 - f2;
                i2++;
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        int[] cur = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i)[0] != cur[0]) {
                res.add(Arrays.asList(new Integer[]{cur[0], cur[1]})); // if diff from prev, add to result.
                cur = lst.get(i);
            } else {
                cur[1] += lst.get(i)[1]; // if same as prev, then add freq.
            }
        }
        res.add(Arrays.asList(new Integer[]{cur[0], cur[1]})); // last one
        return res;

    }
}
