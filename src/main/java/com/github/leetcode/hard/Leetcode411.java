package com.github.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 12:19
 * @Description: A string such as "word" contains the following abbreviations:
 * <p>
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.
 * <p>
 * Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.
 * <p>
 * Note:
 * In the case of multiple answers as shown in the second example below, you may return any one of them.
 * Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.
 * Examples:
 * "apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")
 * <p>
 * "apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").
 */
public class Leetcode411 {
    /**
     * 存放字符串和长度
     */
    class Pair {
        String str;
        int len;

        public Pair(String str, int len) {
            this.str = str;
            this.len = len;
        }
    }

    public String minAbbreviation(String target, String[] dictionary) {
        if (dictionary.length == 0) {
            return Integer.toString(target.length());
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.len - p2.len;
            }
        });
        generateAbbr(pq, target, "", 0, 0);
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (!isValid(cur, dictionary)) {//不在字典集合中，直接返回
                return cur.str;
            }
        }
        return "";
    }

    /**
     * 判断两字符串是否表达同样的组合
     *
     * @param word
     * @param abbr
     * @return
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;
                ++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            //是数字
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        //两个字符串都顺利走完
        return i == word.length() && j == abbr.length();
    }

    /**
     * 判断是否是有效的组合
     *
     * @param p
     * @param dictionary
     * @return
     */
    public boolean isValid(Pair p, String[] dictionary) {

        for (String s : dictionary) {
            String des = p.str;
            if (validWordAbbreviation(s, des)) {//跟字典中某个字符串冲突
                return true;
            }
        }
        return false;
    }

    /**
     * 获取字符串的长度
     *
     * @param str
     * @return
     */
    public int getLen(String str) {
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            len++;
            if (Character.isDigit(ch)) {//如果是数字， 判断后序是不是数字
                while (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) {
                    i++;
                }
            }
        }
        return len;
    }

    /**
     * @param pq     优先级队列
     * @param target 目标对象
     * @param str    前缀字符串
     * @param pos    开始位置
     * @param cnt    数字
     */
    public void generateAbbr(PriorityQueue<Pair> pq, String target, String str, int pos, int cnt) {
        if (pos == target.length()) {//走完整个字符串
            if (cnt > 0) {
                str = str + cnt;
            }
            pq.offer(new Pair(str, getLen(str)));
            return;
        }
        //not adding 数字替代字母
        generateAbbr(pq, target, str, pos + 1, cnt + 1);

        //adding 字母还是字母， 数字清0
        generateAbbr(pq, target, str + (cnt == 0 ? "" : cnt) + target.charAt(pos), pos + 1, 0);

    }
}
