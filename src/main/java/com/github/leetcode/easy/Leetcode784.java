package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 */
public class Leetcode784 {
    public static void main(String[] args) {
        Leetcode784 leetcode784 = new Leetcode784();
        leetcode784.letterCasePermutation("a1b2");
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<String>();
        if (S == null) {
            return null;
        }
        //字符串转化为字符数组
        char[] array = S.toLowerCase().toCharArray();
        backTrack(array, 0, res);
        return res;
    }

    /**
     * @param array    字符数组
     * @param position 开始位置
     * @param res      结果集
     */
    private void backTrack(char[] array, int position, List<String> res) {
        //走完了，证明产生了新字符串，添加到结果集
        if (position == array.length) {
            res.add(new String(array));
            return;
        }
        //当前字符不改变，往前走
        backTrack(array, position + 1, res);

        //当前位置是字母
        if (Character.isUpperCase(array[position])) {
            //转化为小写字母
            array[position] = Character.toLowerCase(array[position]);
            backTrack(array, position + 1, res);
        } else if (Character.isLowerCase(array[position])) {
            //转化为大写字母
            array[position] = Character.toUpperCase(array[position]);
            backTrack(array, position + 1, res);
        }
    }
}
