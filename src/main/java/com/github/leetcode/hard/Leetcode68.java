package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 12:50
 * @Description: Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 * <p>
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Example 2:
 * <p>
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 * <p>
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */
public class Leetcode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < len) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                //1代表中间空格
                count += 1 + words[last].length();
                last++;
            }
            StringBuilder buffer = new StringBuilder();
            buffer.append(words[index]);
            int diff = last - index - 1;
            //走到数组最后了，或者一个单词占据一行的情况
            if (last == len || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    buffer.append(" ");
                    buffer.append(words[i]);
                }
                //剩下的空格补足
                for (int i = buffer.length(); i < maxWidth; i++) {
                    buffer.append(" ");
                }
            } else {
                //每个单词之间平均填补的空格数
                int spaces = (maxWidth - count) / diff;
                //剩余待补的空位数
                int extra = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int j = spaces; j > 0; j--) {
                        buffer.append(" ");
                    }
                    // the empty slots on the left will be assigned more spaces than the slots on the right.
                    if (extra > 0) {
                        buffer.append(" ");
                        extra--;
                    }
                    buffer.append(" ");
                    buffer.append(words[i]);
                }
            }
            result.add(buffer.toString());
            index = last;
        }
        return result;
    }
}
