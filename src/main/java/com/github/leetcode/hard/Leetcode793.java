package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 21:44
 * @Description: Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.)
 * <p>
 * For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has 2 zeroes at the end. Given K, find how many non-negative integers x have the property that f(x) = K.
 * <p>
 * Example 1:
 * Input: K = 0
 * Output: 5
 * Explanation: 0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.
 * <p>
 * Example 2:
 * Input: K = 5
 * Output: 0
 * Explanation: There is no x such that x! ends in K = 5 zeroes.
 * Note:
 * <p>
 * K will be an integer in the range [0, 10^9].
 */
public class Leetcode793 {
    public static void main(String[] args) {
        Leetcode793 leetcode793=new Leetcode793();
        leetcode793.preimageSizeFZF(0);
        //System.out.println(leetcode793.getZeroes(100));
    }
    public int preimageSizeFZF(int K) {
         /*
        findRange(K)- All elements factorial <= Kzeroes

        findRange(K-1) -All elements factorial <= K-1 zeroes

        */
        return findRange(K) - findRange(K - 1);
    }

    /**
     * 二分查找
     *
     * @param k
     * @return
     */
    int findRange(int k) {
        long low = 0, high = Long.MAX_VALUE;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (getZeroes(mid) > k) high = mid - 1;
            else
                low = mid + 1;
        }

        return (int) low - 1;
    }

    /**
     * 获取N!的尾部0的数量
     * @param N
     * @return
     */
    long getZeroes(long N){
        long count = 0;
        for(long i=5;N/i>=1;i=i*5){
            count+=N/i;
        }

        return count;
    }
}
