package com.github.lintcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 7/26/19 08:18
 * @Description: There are n items and a backpack with size m. Given array A representing the size of each item and array V representing the value of each item.
 * <p>
 * What's the maximum value can you put into the backpack?
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
 * Output: 9
 * Explanation: Put A[1] and A[3] into backpack, getting the maximum value V[1] + V[3] = 9
 * Example 2:
 * <p>
 * Input: m = 10, A = [2, 3, 8], V = [2, 5, 8]
 * Output: 10
 * Explanation: Put A[0] and A[2] into backpack, getting the maximum value V[0] + V[2] = 10
 * Challenge
 * O(nm) memory is acceptable, can you do it in O(m) memory?
 * <p>
 * Notice
 * A[i], V[i], n, m are all integers.
 * You can not split an item.
 * The sum size of the items you want to put into backpack can not exceed m.
 * Each item can only be picked up once
 */
public class Lintcode125 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int n=A.length;
        if(n==0){
            return 0;
        }
        int[][] f=new int[n+1][m+1];
        int i,j;
        for(i=0;i<=n;i++){
            Arrays.fill(f[i],-1);
        }
        f[0][0]=0;
        for(i=1;i<=n;i++){
            for(j=0;j<=m;j++){
                f[i][j]=f[i-1][j];
                if(A[i-1]<=j&&f[i-1][j-A[i-1]]!=-1){
                    f[i][j]=Math.max(f[i][j],f[i-1][j-A[i-1]]+V[i-1]);
                }
            }
        }
        int res=0;
        for(i=0;i<=m;i++){
            res=Math.max(res,f[n][i]);
        }
        return res;
    }
}
