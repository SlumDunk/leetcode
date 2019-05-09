package com.github.leetcode.hard;

import com.github.leetcode.vo.Master;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: zerongliu
 * @Date: 3/17/19 16:22
 * @Description: This problem is an interactive problem new to the LeetCode platform.
 * <p>
 * We are given a word list of unique words, each word is 6 letters long, and one word in this list is chosen as secret.
 * <p>
 * You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from the original list with 6 lowercase letters.
 * <p>
 * This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.
 * <p>
 * For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or less calls to master.guess and at least one of these guesses was the secret, you pass the testcase.
 * <p>
 * Besides the example test case below, there will be 5 additional test cases, each with 100 words in the word list.  The letters of each word in those testcases were chosen independently at random from 'a' to 'z', such that every word in the given word lists is unique.
 * <p>
 * Example 1:
 * Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
 * <p>
 * Explanation:
 * <p>
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
 * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 * <p>
 * We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
 * Note:  Any solutions that attempt to circumvent the judge will result in disqualification.
 */
public class Leetcode839 {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; i++) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guess);
            List<String> wordList2 = new ArrayList<>();
            for (String word :
                    wordlist) {
                if (match(guess, word) == x) {
                    wordList2.add(word);
                }
            }
            wordlist = wordList2.toArray(new String[wordList2.size()]);
        }
    }

    /**
     * 返回两个字符串匹配的字符个数
     *
     * @param guess
     * @param word
     * @return
     */
    private int match(String guess, String word) {
        int matches = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == word.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}
