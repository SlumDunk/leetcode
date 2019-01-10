package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 15:16
 * @Description: Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class Leetcode93 {
    public static void main(String[] args) {
        Leetcode93 leetcode93 = new Leetcode93();
        System.out.println(leetcode93.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        List<String> temp = new ArrayList<String>();
        backTrack(result, s, temp, 0);
        return result;
    }

    /**
     * @param result   结果集
     * @param s        字符串
     * @param temp     IP段集合
     * @param curIndex 开始位置
     */
    private void backTrack(List<String> result, String s, List<String> temp, int curIndex) {
        if (temp.size() == 4) {
            if (curIndex == s.length()) {
                //遍历完字符串，且得到4个段，所以是合法IP
                result.add(generateIP(temp));
            } else {
                return;
            }
        }
        //要拼接的下一个子网IP段
        String subDomain = "";
        for (int i = curIndex; i < s.length(); i++) {
            subDomain = subDomain + s.charAt(i);
            //该子网ip不合法，跳过
            if (subDomain.length() > 1 && subDomain.startsWith("0") || Integer.parseInt(subDomain) > 255)
                break;
            temp.add(subDomain);
            backTrack(result, s, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 产生IP字符串
     *
     * @param list
     * @return
     */
    public String generateIP(List<String> list) {
        StringBuilder buffer = new StringBuilder();
        for (String domain : list) {
            buffer.append(domain);
            buffer.append(".");
        }

        return buffer.deleteCharAt(buffer.length() - 1).toString();
    }

}
