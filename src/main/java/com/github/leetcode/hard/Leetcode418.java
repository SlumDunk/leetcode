package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/2/19 22:51
 * @Description: Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.
 * <p>
 * Note:
 * <p>
 * A word cannot be split into two lines.
 * The order of words in the sentence must remain unchanged.
 * Two consecutive words in a line must be separated by a single space.
 * Total words in the sentence won't exceed 100.
 * Length of each word is greater than 0 and won't exceed 10.
 * 1 ≤ rows, cols ≤ 20,000.
 * Example 1:
 * <p>
 * Input:
 * rows = 2, cols = 8, sentence = ["hello", "world"]
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * hello---
 * world---
 * <p>
 * The character '-' signifies an empty space on the screen.
 * Example 2:
 * <p>
 * Input:
 * rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * a-bcd-
 * e-a---
 * bcd-e-
 * <p>
 * The character '-' signifies an empty space on the screen.
 * Example 3:
 * <p>
 * Input:
 * rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * I-had
 * apple
 * pie-I
 * had--
 * <p>
 * The character '-' signifies an empty space on the screen.
 */
public class Leetcode418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuffer buffer = new StringBuffer();
        for (String word :
                sentence) {
            buffer.append(word);
            buffer.append(" ");
        }
        int count = 0;
        int len = buffer.length();
        for (int i = 0; i < rows; i++) {
            count += cols;
            if (buffer.charAt(count % len) == ' ') {
                count++;
            } else {
                //是在某个单词中间
                while (count > 0 && buffer.charAt((count - 1) % len) != ' ') {
                    count--;
                }
            }
        }

        return count / len;
    }
}
