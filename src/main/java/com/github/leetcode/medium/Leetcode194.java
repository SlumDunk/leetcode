package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 13:49
 * @Description: Given a text file file.txt, transpose its content.
 * <p>
 * You may assume that each row has the same number of columns and each field is separated by the ' ' character.
 * <p>
 * Example:
 * <p>
 * If file.txt has the following content:
 * <p>
 * name age
 * alice 21
 * ryan 30
 * Output the following:
 * <p>
 * name alice ryan
 * age 21 30
 */
public class Leetcode194 {
    public static void main(String[] args) {
        System.out.printf("awk '\n" +
                "{\n" +
                "    for(i=1;i<=NF;i++){\n" +
                "        if(NR==1){\n" +
                "            s[i]=$i;\n" +
                "        }else{\n" +
                "            s[i]=s[i]\" \"$i;\n" +
                "        }\n" +
                "    }\n" +
                "}  \n" +
                "END{\n" +
                "    for(i=1;s[i]!=\"\";i++)\n" +
                "        print s[i];\n" +
                "}\n" +
                "' file.txt");
    }
}
