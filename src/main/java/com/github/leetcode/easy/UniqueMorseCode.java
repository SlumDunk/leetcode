package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 * <p>
 * Return the number of different transformations among all words we have.
 * <p>
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * There are 2 different transformations, "--...-." and "--...--.".
 */
public class UniqueMorseCode {
    /**
     * morse code array
     */
    public static String[] arrMorse = new String[]
            {
                    ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
            };
    /**
     * morse map
     */
    private static Map<Character, String> morseMap = new HashMap<Character, String>(64);

    /**
     * initial morse map
     */
    static {
        Character initialChar=new Character('a');
        for (int i = 0; i < 26; i++) {
            morseMap.put(initialChar++, arrMorse[i]);
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{
                "gin", "zen", "gig", "msg"
        };
        int size = uniqueMorseRepresentations(words);
        System.out.println(size);
    }

    public static int uniqueMorseRepresentations(String[] words) {
        if (words.length > 100) {
            System.out.println("the max length of words could not longer than 100");
            return 0;
        } else {
            Set<String> morseSet = new HashSet<String>();
            for (int i = 0; i < words.length; i++) {
                StringBuffer morseCodeBuffer = new StringBuffer();
                for (int j = 0; j < words[i].length(); j++) {
                    morseCodeBuffer.append(morseMap.get(words[i].charAt(j)));
                }
                morseSet.add(morseCodeBuffer.toString());
            }
            return morseSet.size();
        }
    }
}
