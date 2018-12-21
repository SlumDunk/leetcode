package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image below.
 * <p>
 * <p>
 * American keyboard
 * <p>
 * <p>
 * Example 1: Input: ["Hello", "Alaska", "Dad", "Peace"] Output: ["Alaska",
 * "Dad"] Note: You may use one character in the keyboard more than once. You
 * may assume the input string will only contain letters of alphabet.
 *
 * @author liuzhongda
 */
public class Leetcode500 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String[] findWords(String[] words) {
        //用数组存储三行字母， 遍历每个字符串，查找每个字符在三个行字符串中的索引
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";
        List<String> resultList = new ArrayList<String>();
        //遍历字符串数组
        for (String word : words) {
            //三行三个标志位
            int first = 0, second = 0, third = 0;
            for (char value : word.toLowerCase().toCharArray()) {
                if (firstRow.indexOf(value) != -1) {
                    first = 1;
                } else if (secondRow.indexOf(value) != -1) {
                    second = 1;
                } else if (thirdRow.indexOf(value) != -1) {
                    third = 1;
                }
            }
            //只在某一行出现
            if (first + second + third == 1) {
                resultList.add(word);
            }
        }
        String[] result = new String[resultList.size()];
        //将结果复制到结果数组
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

}
