package com.github.leetcode.easy;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * <p>
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * <p>
 * The rules of Goat Latin are as follows:
 * <p>
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * <p>
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * <p>
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 * <p>
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class Leetcode824 {
    public static void main(String[] args) {
        Leetcode824 leetcode824 = new Leetcode824();
        String result = leetcode824.toGoatLatin("Each word consists of lowercase and uppercase letters only");
        System.out.println(result);
    }

    public static String vowelString = "aeiouAEIOU";

    public String toGoatLatin(String S) {

        if (S != null && S.length() >= 1 && S.length() <= 150) {
            String[] array = S.split(" ");
            String temp;
            StringBuffer resultBuffer = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                temp = array[i];
                char firstChar = temp.charAt(0);
                //元音开头
                if (vowelString.indexOf(firstChar) != -1) {
                    resultBuffer.append(temp);
                } else {//辅音开头
                    resultBuffer.append(temp.substring(1));
                    resultBuffer.append(firstChar);
                }
                //结尾拼上ma
                resultBuffer.append("ma");
                resultBuffer.append(generateA(i + 1));
                if (i < array.length - 1) {
                    resultBuffer.append(" ");
                }
            }
            return resultBuffer.toString();
        } else {
            return null;
        }
    }

    /**
     * 产生a数组
     *
     * @param num 产生num一个
     * @return
     */
    private char[] generateA(int num) {
        char[] charArray = new char[num];
        for (int j = 0; j < num; j++) {
            charArray[j] = 'a';
        }
        return charArray;
    }
}
