package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 12:38
 * @Description: Write a bash script to calculate the frequency of each word in a text file words.txt.
 * <p>
 * For simplicity sake, you may assume:
 * <p>
 * words.txt contains only lowercase characters and space ' ' characters.
 * Each word must consist of lowercase characters only.
 * Words are separated by one or more whitespace characters.
 * Example:
 * <p>
 * Assume that words.txt has the following content:
 * <p>
 * the day is sunny the the
 * the sunny is is
 * Your script should output the following, sorted by descending frequency:
 * <p>
 * the 4
 * is 3
 * sunny 2
 * day 1
 */
public class Leetcode192 {
    public static void main(String[] args) {
        System.out.printf("awk '{i=1;while(i<=NF){print $i;i++}}' words.txt \\\n" +
                "  | sort | uniq -c \\\n" +
                "  | sort -k1nr \\\n" +
                "  |awk '{print $2 \" \" $1}'\n");
    }
}
