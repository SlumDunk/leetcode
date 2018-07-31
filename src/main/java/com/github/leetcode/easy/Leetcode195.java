package com.github.leetcode.easy;

/**
 * Given a text file file.txt, print just the 10th line of the file.
 * <p>
 * Example:
 * <p>
 * Assume that file.txt has the following content:
 * <p>
 * Line 1
 * Line 2
 * Line 3
 * Line 4
 * Line 5
 * Line 6
 * Line 7
 * Line 8
 * Line 9
 * Line 10
 * Your script should output the tenth line, which is:
 * <p>
 * Line 10
 * Note:
 * 1. If the file contains less than 10 lines, what should you output?
 * 2. There's at least three different solutions. Try to explore all possibilities.
 */
public class Leetcode195 {
    public static void main(String[] args) {
        System.out.println("sed -n '10p' file.txt");
    }
}
