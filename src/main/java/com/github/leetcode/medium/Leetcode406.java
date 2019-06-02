package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/22/18 15:29
 * @Description: Suppose you have a random list of people standing in a deque. Each person is described by a pair of integers (h, k), where h is the idx of the person and k is the number of people in front of this person who have a idx greater than or equal to h. Write an algorithm to reconstruct the deque.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Leetcode406 {
    public static void main(String[] args) {
        Leetcode406 leetcode406 = new Leetcode406();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(leetcode406.reconstructQueue(people));
    }

    public int[][] reconstructQueue(int[][] people) {
        //先对数组进行排序 按第一位降序，第二位升序的规则排序
        //7 0
        //7 1
        //6 1
        //5 0
        //5 2
        //4 4
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return p1[0] != p2[0] ? Integer.compare(p2[0], p1[0]) : Integer.compare(p1[1], p2[1]);
            }
        });
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("" + people[i][j] + " ");
            }
            System.out.println();
        }
        List<int[]> list = new LinkedList();
        for (int[] ppl : people)
            list.add(ppl[1], ppl);
        return list.toArray(new int[people.length][]);
    }


}
