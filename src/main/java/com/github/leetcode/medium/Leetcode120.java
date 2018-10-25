package com.github.leetcode.medium;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 19:30
 * @Description: Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * <p>
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
            int row=triangle.size();    //行数
            if(row==0) return 0;

            int[] res=new int[row+1];       //倒着求，求最后一行到第一行最小和，这样就可以用o(n)空间了

            for(int i=row-1;i>=0;i--){
                List<Integer> list=triangle.get(i);
                for(int j=0;j<list.size();j++){
                    res[j]=(Math.min(res[j+1],res[j])+list.get(j));//最后一行的最小值就是当前数
                }
            }

            return res[0];
    }
}
